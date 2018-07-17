package presto.service;

import java.util.List;

import presto.model.Cliente;


public interface ClienteService {
	
	public Cliente save(Cliente cliente);
	public List<Cliente> getAll();
	public Cliente findByEmail(String username);
	public Cliente findById(Long id);

	
}
