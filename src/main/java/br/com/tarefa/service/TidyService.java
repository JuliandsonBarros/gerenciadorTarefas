package br.com.tarefa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefa.domain.Tidy;
import br.com.tarefa.exceptions.ObjectNotFoundException;
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
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado!" + 
					id + ", tipo: " + Tidy.class.getName(), null));
	}

	public List<Tidy> listOpen() {
		List<Tidy> list = repo.findAllOpen();
		return list;
	}

	public List<Tidy> listClose() {
		List<Tidy> list = repo.findAllClose();
		return list;
	}
	
	public Tidy create(Tidy obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public Tidy update(Integer id, Tidy obj) {
		Tidy newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDescricao(obj.getDescricao());
		newObj.setDate(obj.getDate());
		newObj.setFinalizado(obj.getFinalizado());
		return repo.save(newObj);
	}

}