package com.shah.AirlineReservationSystem;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends MongoRepository<Flight, ObjectId> {
    Optional<Flight> findFlightByFlightNum(String flightNum);
}