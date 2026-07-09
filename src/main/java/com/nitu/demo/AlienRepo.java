package com.nitu.demo;

//import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.web.bind.annotation.RequestParam;

import com.nitu.demo.models.Alien;
import java.util.List;


public interface AlienRepo extends JpaRepository<Alien, Integer>{


	List<Alien> findByNameOrderByIdDesc(String name); // Querry DSL
	
	@Query("SELECT a FROM Alien a WHERE a.name = :name")
	List<Alien> find(@Param("name") String name);
	
}
