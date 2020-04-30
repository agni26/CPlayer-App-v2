package cplayer.favourites.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cplayer.favourites.app.model.Favourites;

public interface FavouritesRepository extends MongoRepository<Favourites, Integer> {
	
}      //Player data stored in repository is accessed.
