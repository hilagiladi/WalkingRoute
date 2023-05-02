import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GeolocationApi {
    public static void main(String[] args) throws Exception {
        String apiKey = "AIzaSyBUOnqW1b1gyAvpNoYMLetD0emlXvL8d_Y";
        String urlString = "https://www.googleapis.com/geolocation/v1/geolocate?key=" + apiKey;

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String jsonPayload = "{data.json}";
        byte[] inputBytes = jsonPayload.getBytes(StandardCharsets.UTF_8);
        connection.getOutputStream().write(inputBytes);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
    }
}
