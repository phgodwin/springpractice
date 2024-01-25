package com.lbg.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Animal;
import com.lbg.demo.repos.AnimalRepo;

@Service
public class AnimalService {

	private AnimalRepo repo;

	public AnimalService(AnimalRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Animal> createAnimal(Animal newAnimal) {
		Animal created = this.repo.save(newAnimal);
		return new ResponseEntity<Animal>(created, HttpStatus.CREATED);
	}

	public List<Animal> getAnimals() {
		return this.repo.findAll();

	}

	public ResponseEntity<Animal> getAnimal(int id) {
		Optional<Animal> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
		}

		Animal body = found.get();

		return ResponseEntity.ok(body);

	}

	public boolean removeAnimal(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);

	}

	public ResponseEntity<Animal> updateAnimal(int id, Animal newAnimal) {

		Optional<Animal> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
		}

		Animal existing = found.get();

		if (newAnimal.getType() != null) {
			existing.setType(newAnimal.getType());
		}

		if (newAnimal.getColour() != null) {
			existing.setColour(newAnimal.getColour());
		}

		Animal updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

}
