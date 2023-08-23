package com.eya.SaveTravels.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.eya.SaveTravels.service.TravelService;
import com.eya.SaveTravels.model.TravelModel;
import jakarta.validation.Valid;

@Controller
public class TravelController {

	@Autowired
	TravelService TravelService;
	
	@GetMapping("/")
	public String home(@ModelAttribute("travel") TravelModel travel, Model model) {
		List<TravelModel> travels = TravelService.allTravel();
		
		model.addAttribute("travels", travels);
		 System.out.println("Number of travels: " + travels.size());
		 System.out.println(travels);
		return "index.jsp";
	}
	
	@PostMapping("/addTravel")
	public String home(@Valid @ModelAttribute("travel") TravelModel travel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<TravelModel> travels = TravelService.allTravel();
			model.addAttribute("travels", travels);
	
			return "index.jsp";
		}
		TravelService.addTravel(travel);
		return "redirect:/";
	}
	
    // other methods removed for brevity
	@GetMapping("/travel/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {

		TravelModel travel = TravelService.findTravel(id);
        model.addAttribute("travel", travel);
        return "edit.jsp";
    }
    
    @PutMapping("/travel/{id}")
    public String update(@Valid @ModelAttribute("travel") TravelModel travel, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	TravelService.updateTravel(travel);
            return "redirect:/";
        }
    }
    
	// DELETE
	
	@DeleteMapping("/travel/{id}")
	public String delete(@PathVariable("id") Long id) {
		TravelService.deleteTravel(id);
		return "redirect:/";
	}
	
	

	
	  @GetMapping("/expenses/{id}")
	    public String showTravel(@PathVariable("id") Long id, Model model) {

		  TravelModel oneTravel = TravelService.findTravel(id);
	        System.out.println(oneTravel);
	        model.addAttribute("oneTravel",oneTravel);
	        System.out.println(oneTravel);

	        return "Show.jsp";

	    }

 
}