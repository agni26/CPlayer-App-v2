package cplayer.recommended.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cplayer.recommended.app.model.Recommended;
import cplayer.recommended.app.repository.RecommendedRepository;

@Service
public class RecommendedService {
	
	@Autowired
	private RecommendedRepository recommendedRepository;
	
	public List<Recommended> getAllData() {
		return (List<Recommended>) recommendedRepository.findAll();
	}

	public boolean addData(Recommended zomato) {
		try {
			recommendedRepository.save(zomato);
			return true;
		}catch(Exception e) {
			return false;
		}
	}	
	
	public boolean removeData(int id) {
		try {
			recommendedRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}		
}
