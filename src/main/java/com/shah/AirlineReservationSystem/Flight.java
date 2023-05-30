package com.shah.AirlineReservationSystem;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    private String objectID;
    private String flightNum;
    private String model;
    private int rows;
    private int col;
    @DocumentReference
    private List<Passenger> passengerIds;

    public Flight(String flightNum, String model, int rows, int col) {
        this.flightNum = flightNum;
        this.model = model;
        this.rows = rows;
        this.col = col;
        this.passengerIds = new ArrayList<>();
    }
}
