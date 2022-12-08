package br.com.tarefa.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.tarefa.service.DBService;

@Configuration
@Profile("tidy")
public class TesteConfig {
	
	@Autowired
	private DBService db;
	
	@Bean
	public boolean instancia() throws ParseException {
		this.db.instanciaBaseDados();
		return true;
	}

}
