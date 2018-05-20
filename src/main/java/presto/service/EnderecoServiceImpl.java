package presto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import presto.model.Endereco;
import presto.repository.EnderecoRepository;

@Service("enderecoService")
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository endRepo;
	
	public Endereco save(Endereco endereco) {
		return endRepo.save(endereco);
	}
}
