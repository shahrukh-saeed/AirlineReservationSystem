package com.shah.AirlineReservationSystem;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "passengers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @Id
    private String objectID;
    private String flightNum;
    private String name;
    private int row;
    private int col;

    public Passenger(String flightNum, String name, int row, int col) {
        this.flightNum = flightNum;
        this.name = name;
        this.row = row;
        this.col = col;
    }
}
