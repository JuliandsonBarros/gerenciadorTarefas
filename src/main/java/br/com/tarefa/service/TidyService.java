package br.com.tarefa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefa.domain.Tidy;
import br.com.tarefa.repository.TidyRepository;

@Service
public class TidyService {

	@Autowired
	private TidyRepository repo;

	public List<Tidy> findAll() {
		return repo.findAll();

	}

	public Tidy findById(Integer id) {
		Optional<Tidy> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Tidy> listOpen() {
		List<Tidy> list = repo.findAllOpen();
		return list;
	}

	public List<Tidy> listOpenEnd() {
		List<Tidy> list = repo.findAllClose();
		return list;
	}

}