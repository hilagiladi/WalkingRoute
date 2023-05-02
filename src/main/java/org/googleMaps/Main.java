package org.googleMaps;

import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

    public static void main(String[] args) throws IOException {
        // Set up the API key
        String apiKey = "AIzaSyBUOnqW1b1gyAvpNoYMLetD0emlXvL8d_Y";
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        String origin = "Paris, France";
        String destination = "Marseille, France";
        String htmlFile = "C:\\Users\\1\\Documents\\Comuter Science\\projects\\WalkingRoute\\src\\main\\java\\org\\googleMaps\\map.html";

        // Load the HTML file
        File input = new File(htmlFile);
        Document doc = Jsoup.parse(input, "UTF-8", "");

        // Set the origin and destination data attributes in the HTML file
        Elements mapDivs = doc.select("#map");
        Element mapDiv = mapDivs.first();
        mapDiv.attr("data-origin", origin);
        mapDiv.attr("data-destination", destination);

        // Write the updated HTML file
        FileWriter writer = new FileWriter(htmlFile);
        writer.write(doc.outerHtml());
        writer.close();


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
