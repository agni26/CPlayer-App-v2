package cplayer.favourites.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.runtime.reflect.ListIterator;

import cplayer.favourites.app.model.Favourites;
import cplayer.favourites.app.repository.FavouritesRepository;

@Service
public class FavouritesService {

	@Autowired
	private FavouritesRepository favouritesRepository;

	public List<Favourites> getAllData(String username) {
		return (List<Favourites>) favouritesRepository.findByUsername(username);
	}

	public boolean addData(Favourites favs) {
		try {
			favouritesRepository.save(favs);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean removeData(String username) {
		try {
			List<Favourites> list = favouritesRepository.findByUsername(username);
			for (Favourites temp : list) {
				favouritesRepository.deleteById(temp.getId());
			}
			return true;
		} catch (Exception e) {
			System.out.println("no");
			return false;
		}
	}

	public boolean removeUserData(String username, int pid) {
		try {
			List<Favourites> list = favouritesRepository.findByUsername(username);
			for(Favourites temp : list ) {
				if(temp.getPid() == pid) {
					favouritesRepository.deleteById(temp.getId());
					return true;
				}
			}
			return false;	
		}catch (Exception e) {
			return false;
		}
	}

}
