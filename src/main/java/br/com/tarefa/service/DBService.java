package br.com.tarefa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefa.domain.Tidy;
import br.com.tarefa.repository.TidyRepository;

@Service
public class DBService {
	
	@Autowired
	private TidyRepository repo;

	public void instanciaBaseDados() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Tidy t1 = new Tidy(null, "Estudar Java", "Spring boot framework", sdf.parse("07/12/2022"), false);
		Tidy t2 = new Tidy(null, "Estudar Angular", "Angular 12 framework", sdf.parse("08/12/2022"), true);
		repo.saveAll(Arrays.asList(t1,t2));
	}
}
