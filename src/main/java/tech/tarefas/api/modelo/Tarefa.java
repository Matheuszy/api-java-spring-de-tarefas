package tech.tarefas.api.modelo;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Tarefa {
    private String nome;
    private String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeInicio;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeTermino;

    public Tarefa(String nome, String descricao, LocalDate dataDeInicio, LocalDate dataDeTermino) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public void setDataDeTermino(LocalDate dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    @Override
    public String toString() {
        return "Tarefa{'" + '\'' +
                "nome:'" + nome + '\'' +
                "descrição:' " + descricao + '\'' +
                "data de inicio:' " + dataDeInicio + '\'' +
                "data de término:' " + dataDeTermino +
                '}';
    }
}
