package cplayer.favourites.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cplayer.favourites.app.model.Favourites;
import cplayer.favourites.app.service.FavouritesService;

@RestController                 //takes care of mapping request data to the defined request handler method.
@RequestMapping("/api/fav")     //maps HTTP requests to handler methods of MVC and REST controllers.
@CrossOrigin(value = "*")       //helps to request additional resources into browser from other domains
public class FavouritesController {
	
	@Autowired          //injecting the object dependency implicitly
	private FavouritesService favouritesService;
	 
	@GetMapping         //GET requests onto specific handler methods.
	public ResponseEntity<?> getAllPlayers(@RequestParam("username") String username) {
		try {
			return new ResponseEntity<List<Favourites>>(favouritesService.getAllData(username),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("no",HttpStatus.OK);
		}
	}
	
	@PostMapping        //POST requests matched with given URL expression
	public ResponseEntity<?> addData(@RequestBody Favourites favs) {
		if(favouritesService.addData(favs)) {
			return new ResponseEntity<String>("ok", HttpStatus.CREATED);
		}
		else return new ResponseEntity<String>("no", HttpStatus.CREATED);
	}
	
	
	@DeleteMapping      //maps  HTTP DELETE requests onto specific handler methods
	public ResponseEntity<String> deleteData(@RequestParam("username") String username){
		favouritesService.removeData(username);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
