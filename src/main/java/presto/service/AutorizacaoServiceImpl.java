package presto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import presto.model.Autorizacao;
import presto.repository.AutorizacaoRepository;

@Service("autorizacaoService")
@Transactional
public class AutorizacaoServiceImpl implements AutorizacaoService {

	@Autowired
	private AutorizacaoRepository autorizacaoRepo;
	
	public void setAutorizacaoRepo(AutorizacaoRepository autorizacaoRepo) {
		this.autorizacaoRepo = autorizacaoRepo;
	}
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Autorizacao salvar(Autorizacao autorizacao) {
		return autorizacaoRepo.save(autorizacao);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void excluir(Long idAutorizacao) {
		autorizacaoRepo.delete(idAutorizacao);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Autorizacao> todos() {
		List<Autorizacao> retorno = new ArrayList<Autorizacao>();
		for(Autorizacao autorizacao: autorizacaoRepo.findAll()) {
			retorno.add(autorizacao);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Autorizacao> buscar(String nome) {
		if(nome == null || nome.isEmpty()) {
			return todos();
		}
		return autorizacaoRepo.findByNomeContainsIgnoreCase(nome);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Autorizacao buscarPorId(Long idAutorizacao) {
		return autorizacaoRepo.findOne(idAutorizacao);
	}

}

