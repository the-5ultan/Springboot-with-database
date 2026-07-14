package com.nitu.demo.controllers;


import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitu.demo.AlienRepo;
import com.nitu.demo.Springboot1stApplication;
import com.nitu.demo.models.Alien;


@RestController
public class AlienController {

    private final Springboot1stApplication springboot1stApplication;
	@Autowired
	AlienRepo repo;

    AlienController(Springboot1stApplication springboot1stApplication) {
        this.springboot1stApplication = springboot1stApplication;
    }
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
	
	@PostMapping(path ="alien", consumes = {"application/json"}) // now it is only gonna accept json input none other is gonna work !
	public Alien addAlien(@RequestBody Alien alien) {      //If the data is coming in any other format except java object format the @RequestBody is required to convert it to the java object format
		repo.save(alien);
		return alien;
	}
}
