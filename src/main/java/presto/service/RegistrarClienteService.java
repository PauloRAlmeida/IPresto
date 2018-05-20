package presto.service;

import presto.model.Cliente;
import presto.model.Endereco;

public interface RegistrarClienteService {

	public  Cliente save(Cliente cliente);
	
	public Endereco save(Endereco endereco);
}
