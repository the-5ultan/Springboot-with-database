package com.nitu.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nitu.demo.AlienRepo;
import com.nitu.demo.models.Alien;

import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;

    @RequestMapping("/")
    public String home() {
        return "index2";
    }
    
    @PostMapping("/add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap m) {
    	long num3 = i + j;
    	m.addAttribute("num3",num3);
    	return "result";
    }
    
    @PostMapping("/addAlien")
    public String addAlien(Alien alien, ModelMap m) {

        m.addAttribute("alien", alien);
        repo.save(alien);

        return "result2";
    }
    
    @PostMapping("/removeAlien")
    public String removeAlien(Alien alien, ModelMap m) {

        m.addAttribute("alien", alien);
        repo.delete(alien);

        return "result2";
    }
    
    @GetMapping("/getAliens")
    public String getAliens(ModelMap m) {
    	m.addAttribute("result",repo.findAll());
    	return "showAliens";
    }
    
  
	@GetMapping("/getAlien")
    public String getAlien(@RequestParam("aid") int aid,ModelMap m) {
    	m.addAttribute("alien",repo.getReferenceById(aid));
    	return "showAlien";
    }
	
	@GetMapping("/getAlienByName")
    public String getAlienByName(@RequestParam("name") String name,ModelMap m) {
    	m.addAttribute("alien",repo.findByName(name));
    	return "showAlien";
    }
}