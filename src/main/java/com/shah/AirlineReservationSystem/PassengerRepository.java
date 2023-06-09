package com.shah.AirlineReservationSystem;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends MongoRepository<Passenger, ObjectId> {
}
