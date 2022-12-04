package br.com.tarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tarefa.domain.Tidy;

@Repository
public interface TidyRepository extends JpaRepository<Tidy, Integer> {

}
