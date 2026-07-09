package com.nitu.demo;

//import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nitu.demo.models.Alien;
import java.util.List;


public interface AlienRepo extends JpaRepository<Alien, Integer>{


	List<Alien> findByNameOrderById(String name); // Querry DSL
	
}
