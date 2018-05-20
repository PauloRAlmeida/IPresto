package presto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import presto.model.Comentario;
import presto.repository.ComentarioRepository;

@Service("comentarioService")
public class ComentarioServiceImpl implements ComentarioService{

	@Autowired
	private ComentarioRepository comRepo;
	
	public void save(Comentario comentario) {
		comRepo.save(comentario);
		
	}

}
