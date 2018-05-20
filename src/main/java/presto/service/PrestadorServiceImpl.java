package presto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import presto.model.Prestador;
import presto.repository.PrestadorRepository;

@Service("prestadorService")
public class PrestadorServiceImpl implements PrestadorService{

	@Autowired
	private PrestadorRepository preRepo;
	
	public void save(Prestador prestador) {
		preRepo.save(prestador);
	}
	
}
