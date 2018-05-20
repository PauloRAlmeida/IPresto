package presto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import presto.model.Autorizacao;

public interface AutorizacaoRepository extends CrudRepository<Autorizacao, Long> {

	public List<Autorizacao> findByNomeContainsIgnoreCase(String nome);
	
}