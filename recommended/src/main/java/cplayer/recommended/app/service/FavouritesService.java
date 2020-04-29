package cplayer.recommended.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cplayer.recommended.app.model.Favourites;
import cplayer.recommended.app.repository.FavouritesRepository;

@Service
public class FavouritesService {
	
	@Autowired
	private FavouritesRepository favouritesRepository;
	
	public List<Favourites> getAllData() {
		return (List<Favourites>) favouritesRepository.findAll();
	}

	public boolean addData(Favourites zomato) {
		try {
			favouritesRepository.save(zomato);
			return true;
		}catch(Exception e) {
			return false;
		}
	}	
	
	public boolean removeData(int id) {
		try {
			favouritesRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			System.out.println("no");
			return false;
		}
	}		
}
