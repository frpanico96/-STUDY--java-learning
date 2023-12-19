package APIntroduction;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpLearning {
  public static void main(String[] args) throws IOException, InterruptedException {
    // HttpURLConnection is an older version of request making in java
    URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    connection.setRequestProperty("accept", "application/json");

    // This line make the request
    InputStream responseStream = connection.getInputStream();

    connection.disconnect();

    var client = HttpClient.newHttpClient();

    var request = HttpRequest.newBuilder(
        URI.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"))
        .header("accept", "application/json")
        .build();
    var response = client.send(request, BodyHandlers.ofString());
    System.out.println(response.body());

  }
}
