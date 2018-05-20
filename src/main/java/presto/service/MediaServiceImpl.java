package presto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import presto.model.Media;
import presto.repository.MediaRepository;

@Service("mediaService")
public class MediaServiceImpl implements MediaService {

	@Autowired
	private MediaRepository medRepo;
	
	public void save(Media media) {
		medRepo.save(media);
	}

}
