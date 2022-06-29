package com.github.raonigabriel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.raonigabriel.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, String>{

}
