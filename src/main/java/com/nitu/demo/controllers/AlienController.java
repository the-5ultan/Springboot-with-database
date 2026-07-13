package com.nitu.demo.controllers;


import java.util.List;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.nitu.demo.AlienRepo;
import com.nitu.demo.models.Alien;


@Controller
public class AlienController {
	AlienRepo repo;
	@GetMapping("/aliens")
    public String getAliens() {
    	List<Alien> aliens = repo.findAll();
    	return aliens.toString();
    }
}
