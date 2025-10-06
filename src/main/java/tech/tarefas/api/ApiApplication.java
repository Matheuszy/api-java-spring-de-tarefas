package tech.tarefas.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.tarefas.api.main.Main;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception{
		Main main = new Main();
		main.menu();
	}

}
