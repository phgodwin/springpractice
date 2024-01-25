package com.lbg.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Animal;

@Service
public class AnimalServiceOld {

	private List<Animal> animals = new ArrayList<>();

	public ResponseEntity<Animal> createAnimal(Animal newAnimal) {

		this.animals.add(newAnimal);
		Animal body = this.animals.get(this.animals.size() - 1);

		return new ResponseEntity<Animal>(body, HttpStatus.CREATED);
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public ResponseEntity<Animal> getAnimal(int id) {
		if (id < 0 || id >= this.animals.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Animal found = this.animals.get(id);

		return ResponseEntity.ok(found);
	}

	public Animal removeAnimal(int id) {
		return this.animals.remove(id);
	}

	public Animal updateAnimal(int id, Animal newAnimal) {
		return this.animals.set(id, newAnimal);

	}

}
