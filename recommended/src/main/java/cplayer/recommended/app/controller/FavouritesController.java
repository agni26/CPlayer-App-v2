package cplayer.recommended.app.controller;

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

import cplayer.recommended.app.model.Favourites;
import cplayer.recommended.app.service.FavouritesService;

@RestController
@RequestMapping("/api/fav")
@CrossOrigin(value = "*")
public class FavouritesController {
	
	@Autowired
	private FavouritesService favouritesService;
	
	@GetMapping
	public ResponseEntity<List<Favourites>> getAllPlayers() {
		return new ResponseEntity<List<Favourites>>(favouritesService.getAllData(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Favourites> addData(@RequestBody Favourites favs) {
		favouritesService.addData(favs);
		return new ResponseEntity<Favourites>(HttpStatus.CREATED);
	}
	
	
	@DeleteMapping
	public ResponseEntity<String> deleteData(@RequestParam("id") int id){
		favouritesService.removeData(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
