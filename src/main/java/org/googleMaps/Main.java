package org.googleMaps;

import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Set up the API key
        String apiKey = "AIzaSyBUOnqW1b1gyAvpNoYMLetD0emlXvL8d_Y";
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        // Set up the directions request
        DirectionsApiRequest request = DirectionsApi.newRequest(context)
                .origin("Leshem 48 Even Sapir, Israel")
                .destination("Golomb Jerusalem, Israel");

        // Call the API and get the response
        try {
            DirectionsResult directionsResult = request.await();
            System.out.println(directionsResult);

            // Print a human-readable version of the directions
            System.out.println("Directions:");
            for (DirectionsRoute route : directionsResult.routes) {
                for (DirectionsLeg leg : route.legs) {
                    System.out.println(leg.startAddress + " to " + leg.endAddress + ":");
                    for (DirectionsStep step : leg.steps) {
                        System.out.println("- " + step.htmlInstructions);
                    }
                }
            }
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
