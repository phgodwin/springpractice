package com.lbg.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Owner;
import com.lbg.demo.repos.OwnerRepo;

@Service
public class OwnerService {

	private OwnerRepo repo;

	public OwnerService(OwnerRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Owner> createOwner(Owner newOwner) {
		Owner created = this.repo.save(newOwner);
		return new ResponseEntity<Owner>(created, HttpStatus.CREATED);
	}

	public List<Owner> getOwners() {

		return this.repo.findAll();
	}

	public ResponseEntity<Owner> getOwner(int id) {

		Optional<Owner> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
		}

		Owner body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean removeOwner(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);

	}

	public ResponseEntity<Owner> updateOwner(int id, Owner newOwner) {

		Optional<Owner> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
		}

		Owner existing = found.get();

		if (newOwner.getFirstName() != null) {
			existing.setFirstName(newOwner.getFirstName());
		}

		if (newOwner.getLastName() != null) {
			existing.setLastName(newOwner.getLastName());
		}

		Owner updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

}
