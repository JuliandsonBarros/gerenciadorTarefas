package br.com.tarefa.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tarefa.domain.Tidy;
import br.com.tarefa.service.TidyService;

@CrossOrigin("*")
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
	
	@RequestMapping
	public ResponseEntity<Tidy> create(@RequestBody Tidy obj){
		obj = ts.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Tidy> delete(@PathVariable Integer id){
		ts.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Tidy> updatte(@PathVariable Integer id, @RequestBody Tidy obj){
		Tidy newObj = ts.update(id,obj);
		return ResponseEntity.ok().body(newObj);
		
	}
}
