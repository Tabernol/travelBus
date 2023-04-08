package com.example.travelbus.repo;

import com.example.travelbus.data.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends CrudRepository<City, Long> {
}
