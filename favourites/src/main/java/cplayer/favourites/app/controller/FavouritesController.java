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
	public ResponseEntity<List<Favourites>> getAllPlayers() {
		return new ResponseEntity<List<Favourites>>(favouritesService.getAllData(),HttpStatus.OK);
	}
	
	@PostMapping        //POST requests matched with given URL expression
	public ResponseEntity<Favourites> addData(@RequestBody Favourites favs) {
		favouritesService.addData(favs);
		return new ResponseEntity<Favourites>(HttpStatus.CREATED);
	}
	
	
	@DeleteMapping      //maps  HTTP DELETE requests onto specific handler methods
	public ResponseEntity<String> deleteData(@RequestParam("id") int id){
		favouritesService.removeData(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
