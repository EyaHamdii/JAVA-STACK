package com.codingdojo.Lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.services.SongService;

@Controller
public class MainController {
	
	@Autowired
	private SongService songService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String renderDashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
}
	
	@GetMapping("/songs/new")
	public String songForm(@ModelAttribute("song") Song song) {
		
		return "/songs/new.jsp";
	}
	
	@PostMapping("/songs/new")
	public String submitSong(@Valid @ModelAttribute("song") Song song, BindingResult result)
	{
		if(result.hasErrors()) {
			return "/songs/new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/songs/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		
		Song oneSong = songService.findSong(id);
		model.addAttribute("oneSong", oneSong);
		
		return "songs/showOne.jsp";
	}
	
	// DELETE METHOD
    @RequestMapping(value="/songs/{id}/delete", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
    
    // Top Songs
    @GetMapping("/search/topTen")
    public String topTenSongs(Model model) {
    	
    	List<Song> topTen = songService.topTen();
    	model.addAttribute("topTen", topTen);
    	return "/topTen.jsp";
    }
    
    // Search by artist name
    
    @GetMapping("/search")
    public String searchArtist(@RequestParam(name ="artist") String artist, Model model) {
    	List <Song> songs = songService.searchArtist(artist);
    	model.addAttribute("songs", songs);
    	return "dashboard.jsp";
    }
}


