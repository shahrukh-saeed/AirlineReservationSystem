package com.shah.AirlineReservationSystem;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return new ResponseEntity<List<Flight>>(flightService.allFlights(), HttpStatus.OK);
    }

    @GetMapping("/{flightNum}")
    public ResponseEntity<Optional<Flight>> getSingleFlight(@PathVariable String flightNum) {
        return new ResponseEntity<Optional<Flight>>(flightService.singleFlight(flightNum), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Flight>(flightService.createFlight(payload.get("flightNum"), payload.get("model"), Integer.parseInt(payload.get("rows")), Integer.parseInt(payload.get("col"))), HttpStatus.CREATED);
    }
}
