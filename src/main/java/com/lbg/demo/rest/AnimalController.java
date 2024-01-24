package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Animal;

@RestController

public class AnimalController {

	private List<Animal> animals = new ArrayList<>();

	@PostMapping("/create")
	public ResponseEntity<Animal> createAnimal(@RequestBody Animal newAnimal) {

		this.animals.add(newAnimal);
		Animal body = this.animals.get(this.animals.size() - 1);

		return new ResponseEntity<Animal>(body, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public List<Animal> getAnimals() {
		return animals;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Animal> getAnimal(@PathVariable int id) {
		if (id < 0 || id >= this.animals.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Animal found = this.animals.get(id);

		return ResponseEntity.ok(found);
	}

	@DeleteMapping("/delete/{id}")
	public Animal removeAnimal(@PathVariable int id) {
		return this.animals.remove(id);
	}

	@PutMapping("/update/{id}")

	public Animal updateAnimal(@PathVariable int id, @RequestBody Animal newAnimal) {
		return this.animals.set(id, newAnimal);

	}

}
