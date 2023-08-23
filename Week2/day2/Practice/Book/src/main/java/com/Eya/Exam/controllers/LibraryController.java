package com.Eya.Exam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Eya.Exam.models.Library;
import com.Eya.Exam.services.LibraryService;

import jakarta.validation.Valid;

@Controller
public class LibraryController {
	
	@Autowired
	private LibraryService libServ;

	// DISPLAY ROUTE - FORM
	@GetMapping("/libraries")
	public String libs(@ModelAttribute("library") Library lib, Model model) {
		
		List<Library> allDaLibraries = libServ.alllibs();
		model.addAttribute("libsList",allDaLibraries);
		return "Libraries/libraries.jsp";
	}
	
	// ACTION ROUTE - Create Library
	@PostMapping("/libraries")
	public String createLibs(@Valid @ModelAttribute("library") Library lib,
			BindingResult res,
			Model model) {
		if(res.hasErrors()) {
			List<Library> allDaLibraries = libServ.alllibs();
			model.addAttribute("libsList",allDaLibraries);
			return "Libraries/libraries.jsp";
		}else {
			// if there no errors
			// save
			libServ.createLibrary(lib);
			return "redirect:/libraries";
		}
	}
	
	// DISPLAY ROUTE - Show One Library
	@GetMapping("/libraries/{id}")
	public String showLib(@PathVariable("id") Long libId, Model model) {
		
		Library oneLibrary = libServ.findLibrary(libId);
		model.addAttribute("library",oneLibrary);
		
		return "Libraries/showlib.jsp";
		
	}
}
