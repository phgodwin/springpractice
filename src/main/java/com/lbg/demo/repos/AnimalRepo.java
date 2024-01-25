package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Animal;

public interface AnimalRepo extends JpaRepository<Animal, Integer> {

}
