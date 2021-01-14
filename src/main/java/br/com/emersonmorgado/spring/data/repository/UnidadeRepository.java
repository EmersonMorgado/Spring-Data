package br.com.emersonmorgado.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.emersonmorgado.spring.data.orm.UnidadeTrabalho;

@Repository
public interface UnidadeRepository extends CrudRepository<UnidadeTrabalho, Integer> {

}
