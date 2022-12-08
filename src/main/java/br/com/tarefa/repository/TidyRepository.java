package br.com.tarefa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tarefa.domain.Tidy;

@Repository
public interface TidyRepository extends JpaRepository<Tidy, Integer> {
	
	@Query("SELECT obj from Tidy obj where obj.finalizado = false ORDER BY obj.date")
	List<Tidy> findAllOpen();
	
	@Query("SELECT obj from Tidy obj where obj.finalizado = true ORDER BY obj.date")
	List<Tidy> findAllClose();

}
