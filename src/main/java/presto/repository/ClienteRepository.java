package presto.repository;

import org.springframework.data.repository.CrudRepository;

import presto.model.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	public Cliente findByNome(String username);
	public Cliente findByEmail(String email);
	public Cliente findById(Long id);

}
