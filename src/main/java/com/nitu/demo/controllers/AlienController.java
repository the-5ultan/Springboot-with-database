package com.nitu.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nitu.demo.AlienRepo;
import com.nitu.demo.models.Alien;


@Controller
public class AlienController {
	@Autowired
	AlienRepo repo;
	@GetMapping("/aliens")
	@ResponseBody
    public List<Alien> getAliens() {
    	List<Alien> aliens = repo.findAll();
    	return aliens;
    }
}
