package com.travelbus.repo;

import com.travelbus.entity.City;
import com.travelbus.entity.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends CrudRepository<Route, Long> {

    Route getRouteByStartPointAndFinishPoint(City startPoint, City finishPoint);

    Route getRouteByRouteName(String routeName);
}
