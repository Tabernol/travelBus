package com.example.travelbus.repo;

import com.example.travelbus.data.entity.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends CrudRepository<Route, Long> {
}
