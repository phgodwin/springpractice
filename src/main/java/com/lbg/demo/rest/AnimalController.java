package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Animal;
import com.lbg.demo.service.AnimalService;

@RestController

public class AnimalController {

	private AnimalService service;

	public AnimalController(AnimalService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Animal> createAnimal(@RequestBody Animal newAnimal) {

		return this.service.createAnimal(newAnimal);
	}

	@GetMapping("/get")
	public List<Animal> getAnimals() {
		return this.service.getAnimals();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Animal> getAnimal(@PathVariable int id) {

		return this.service.getAnimal(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean removeAnimal(@PathVariable int id) {
		return this.service.removeAnimal(id);
	}

	@PatchMapping("/update/{id}")

	public ResponseEntity<Animal> updateAnimal(@PathVariable int id, @RequestBody Animal newAnimal) {
		return this.service.updateAnimal(id, newAnimal);

	}

}
