package br.com.tarefa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarefa.domain.Tidy;
import br.com.tarefa.service.TidyService;

@RestController
@RequestMapping(value = "/tidy")
public class TidyResource {
	
	@Autowired
	private TidyService ts;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Tidy>> findAll(){
		List<Tidy> list = ts.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}")
	public ResponseEntity<Tidy> findById(@PathVariable Integer id){
		Tidy obj = ts.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/open", method=RequestMethod.GET)
	public ResponseEntity<List<Tidy>> listOpen(){
		List<Tidy> list = ts.listOpen();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/openEnd",method=RequestMethod.GET)
	public ResponseEntity<List<Tidy>> listClose(){
		List<Tidy> list = ts.listOpen();
		return ResponseEntity.ok().body(list);
	}
}
