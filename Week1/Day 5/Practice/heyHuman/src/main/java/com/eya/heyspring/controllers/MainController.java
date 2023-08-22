package com.eya.heyspring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {
     @RequestMapping("/")
public String heyworld() {
	return "Hello Java";
}
     @RequestMapping("/coolelfoul")
     public String cool() {
     return "W khali lbeb mahloul";
     }
     @RequestMapping("/search")
     public String search(@RequestParam(value="q") String searchQuery) {
     return "You searched for "+ searchQuery;
     }
      @RequestMapping("/hello/{name}/{count}/{var}")
      public String findtwo(@PathVariable("name")String name,
    		  @PathVariable("count") int count,
    		  @PathVariable("var") String var) {
    	  if(count >10) {
    		  return name + "has too many"+ var;
    	  }
    	  return "you found " +name +" and they have"+ count + " "+var;
      }
}
