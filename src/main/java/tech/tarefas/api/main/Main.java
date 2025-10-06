package tech.tarefas.api.main;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import tech.tarefas.api.modelo.Tarefa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
     private Scanner entrada = new Scanner(System.in);
     private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     private LocalDate dataAtual = LocalDate.now();

     public void menu() {
         while (true) {
             System.out.println("Digite a sua tarefa ou sair para encerrar: ");
             var nome = entrada.nextLine();

             if (nome.trim().equalsIgnoreCase("sair")){
                 System.exit(0);
             }

             System.out.println("Digite a descrição da tarefa");
             var descricao = entrada.nextLine();

             LocalDate dataComeco = null;
             while (true) {
                 System.out.println("Digite a data de inicio da tarefa");
                 var dataComecoStr = entrada.nextLine();
                 try {
                     dataComeco = LocalDate.parse(dataComecoStr, formatador);
                     if (dataComeco.isBefore(dataAtual)) {
                         System.out.println("Insira um data de inicio valida igual ou maior que " + dataAtual);
                         continue;
                     }
                     break;
                 } catch (DateTimeParseException E){
                     System.out.println("Fomato de data inválido" + E);
                 }
             }

             LocalDate dataTermino = null;
             while(true) {
                 System.out.println("Digite a data de término da tarefa");
                 var dataTerminoStr = entrada.nextLine();
                 try {
                     dataTermino = LocalDate.parse(dataTerminoStr, formatador);
                     if (dataTermino.isBefore(dataComeco)) {
                         System.out.println("Insira um data de término válida igual ou após a data de inicio");
                         continue;
                     }
                     break;
                 }catch (DateTimeParseException E){
                     System.out.println("Fomato de data inválido" + E);
                 }

             }

             try {


                 Tarefa tarefa = new Tarefa(nome, descricao, dataComeco, dataTermino);
                 RestTemplate restTemplate = new RestTemplate();
                 HttpHeaders headers = new HttpHeaders();
                 headers.setContentType(MediaType.APPLICATION_JSON);

                 HttpEntity<Tarefa> request = new HttpEntity<>(tarefa, headers);
                 restTemplate.postForEntity("http://localhost:8080/tarefas", request, Void.class);

                 System.out.println("Tarefa criada com sucesso!");

             } catch (DateTimeParseException e) {
                 System.out.println("Data informada incorretamente. por favor, informe como dd/MM/yyyy");
             }
         }





    }


}
