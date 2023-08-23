package com.codingdojo.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.repositories.SongRepository;

@Service
public class SongService {

	// adding the song repository as a dependency
	private final SongRepository songRepository;

	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	// return all the songs
	public List<Song> allSongs(){
		return songRepository.findAll();
		}
	
	// create a song
	public Song createSong(Song s) {
		return songRepository.save(s);
	}
	
	// retrieves a song by ID
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	// delete a song
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	
	// retrieve top 10 songs
	
	public List<Song> topTen(){
		return songRepository.findAllByOrderByRatingDesc();
	}
	
	// Search for songs of particular artist
	
	public List<Song> searchArtist(String title) {
		
		return songRepository.findByArtistIgnoreCase(title);
	
	}
	
}
