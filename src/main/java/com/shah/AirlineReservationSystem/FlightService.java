package com.shah.AirlineReservationSystem;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> allFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> singleFlight(String flightNum) {
        return flightRepository.findFlightByFlightNum(flightNum);
    }

    public Flight createFlight(String flightNum, String model, int rows, int col) {
        Flight flight = flightRepository.insert(new Flight(flightNum, model, rows, col));

        return flight;
    }
}
