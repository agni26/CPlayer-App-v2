package cplayer.recommended.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cplayer.recommended.app.model.Favourites;

public interface FavouritesRepository extends MongoRepository<Favourites, Integer> {
	
}
