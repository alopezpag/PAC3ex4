package edu.uoc.pac3;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;

public class Flight {

    private final Passenger[] passengers;
    private int numPassengers;

    public Flight(File file) throws Exception {
        passengers = new Passenger[50];
        populate(file);
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    private void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    private void populate(File file) throws Exception {
        CSVReader reader = new CSVReaderBuilder(new FileReader(file)).build();
        int passengerIndex = 0;
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            Passenger passenger = new Passenger(
                    nextLine[0], // name
                    nextLine[1], // passport
                    Integer.parseInt(nextLine[2]), // age
                    Boolean.parseBoolean(nextLine[3]) // specialNeeds
            );
            // add passenger to array and increment index
            passengers[passengerIndex++] = passenger;
        }
        setNumPassengers(passengerIndex);
    }

    public Passenger[] getPassengers() {
        return passengers;
    }
}