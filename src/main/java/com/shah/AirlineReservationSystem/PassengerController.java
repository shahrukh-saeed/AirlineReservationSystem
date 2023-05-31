package com.shah.AirlineReservationSystem;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/passengers")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        return new ResponseEntity<List<Passenger>>(passengerService.allPassengers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Passenger>(passengerService.createPassenger(payload.get("flightNum"), payload.get("name"), Integer.parseInt(payload.get("row")), Integer.parseInt(payload.get("col"))), HttpStatus.CREATED);
    }
}
