package com.codingdojo.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

	// this method retrieves all the books from the database
	// Change the type from Iterable to List
	
	List <Song> findAll();
	
	List <Song> findAllByOrderByRatingDesc();
	
	List <Song> findByArtistIgnoreCase(String artist);
	
}
