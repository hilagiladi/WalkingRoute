package org.googleMaps;

import java.util.Scanner;

public class Location {

    private String origin;
    private String destination;

    public Location() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter origin:");
        this.origin = scanner.nextLine();

        System.out.println("Enter destination:");
        this.destination = scanner.nextLine();

        scanner.close();

    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Location{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
