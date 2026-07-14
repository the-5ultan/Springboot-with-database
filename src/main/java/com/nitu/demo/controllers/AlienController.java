package com.nitu.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitu.demo.AlienRepo;
import com.nitu.demo.models.Alien;


@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	@GetMapping(path="aliens",produces = {"application/xml"}) // limited the return to XML type only
	//@ResponseBody                       we can instead change the class controller to RestController
    public List<Alien> getAliens() {
    	List<Alien> aliens = repo.findAll();
    	return aliens;
    }
	
	@GetMapping("alien/{id}")
	//@ResponseBody
	public Alien getAlien(@PathVariable("id") int id) {
		Alien alien = repo.findById(id).orElse(new Alien(0,""));
		return alien;
	}
	
	@PostMapping("alien")
	public Alien addAlien(Alien alien) {
		repo.save(alien);
		return alien;
	}
}
