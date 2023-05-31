package com.shah.AirlineReservationSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private MongoTemplate MongoTemplate;

    public List<Passenger> allPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger createPassenger(String flightNum, String name, int row, int col) {
        Passenger passenger = passengerRepository.insert(new Passenger(flightNum, name, row, col));

        MongoTemplate.update(Flight.class)
        .matching(Criteria.where("flightNum").is(flightNum))
        .apply(new Update().push("passengerIds").value(passenger))
        .first();

        return passenger;
    }
}
