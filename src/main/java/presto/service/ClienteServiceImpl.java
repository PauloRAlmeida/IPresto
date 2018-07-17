package presto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import presto.model.Autorizacao;
import presto.model.Cliente;
import presto.repository.AutorizacaoRepository;
import presto.repository.ClienteRepository;
import presto.repository.EnderecoRepository;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService{

	
	@Autowired
	private ClienteRepository cliRepo;
	
	@Autowired
	private EnderecoRepository endRepo;
	
	@Transactional
	public Cliente save(Cliente cliente) {
		
		if(cliente.getAutorizacoes()!=null) {
		cliente.setAutorizacoes(cliente.getAutorizacoes());
		}
		
		else {
			Autorizacao aut = new Autorizacao();
			aut.setId(cliente.getId());
			aut.setNome("ROLE_USER");
			cliente.addAutorizacao(aut);
		}
		
		if(cliente.getEndereco() != null) {
			if(cliente.getEndereco().getId() != null) {
				endRepo.save(cliente.getEndereco());
			}
			else {
				cliente.setEndereco(endRepo.findOne(cliente.getEndereco().getId()));
			}
		}
		
		return cliRepo.save(cliente);
		
	}

	public List<Cliente> getAll() {
		return (List<Cliente>) cliRepo.findAll();
	}

	@Override
	public Cliente findByEmail(String username) {
		return cliRepo.findByNome(username);
	}
	
	@Override
	public Cliente findById(Long id) {
		return cliRepo.findById(id);
	}

}
