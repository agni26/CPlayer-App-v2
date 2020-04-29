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

import cplayer.recommended.app.model.Recommended;
import cplayer.recommended.app.service.RecommendedService;

@RestController
@RequestMapping("/api/recom")
@CrossOrigin(value = "*")
public class RecommendedController {

	@Autowired
	private RecommendedService recommendedService;

	@GetMapping
	public ResponseEntity<?> getAllPlayers() {
		try {
			return new ResponseEntity<List<Recommended>>(recommendedService.getAllData(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("no", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<String> addData(@RequestBody Recommended favs) {
		try {
			if (recommendedService.addData(favs)) {
				return new ResponseEntity<String>("ok", HttpStatus.CREATED);
			} else
				return new ResponseEntity<String>("no", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("no", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping
	public ResponseEntity<String> deleteData(@RequestParam("id") int id) {
		try {
			if (recommendedService.removeData(id)) {
				return new ResponseEntity<String>("ok", HttpStatus.OK);
			} else
				return new ResponseEntity<String>("no", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("no", HttpStatus.NOT_FOUND);

		}
	}

}
