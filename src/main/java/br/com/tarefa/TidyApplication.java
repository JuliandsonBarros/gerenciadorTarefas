package br.com.tarefa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tarefa.service.DBService;

@SpringBootApplication
public class TidyApplication implements CommandLineRunner {


	
	public static void main(String[] args) {
		SpringApplication.run(TidyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		DBService db = new DBService();
		
	}
}
