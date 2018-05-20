package presto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import presto.model.Cliente;
import presto.repository.ClienteRepository;


@Service("segurancaService")
public class SegurancaServiceImpl implements UserDetailsService {
	
	@Autowired
	private ClienteRepository clieRepo;

	
	public void setUsuarioRepo(ClienteRepository clieRepo) {
		this.clieRepo = clieRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cliente = clieRepo.findByEmail(email);
		if(cliente == null) {
			throw new UsernameNotFoundException(email);
		}
		return cliente;
	}

}
