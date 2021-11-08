package bsu.comp152;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
        var dataGrabber = HttpClient.newHttpClient();
        var requestMake = HttpRequest.newBuilder();
        var webAddress = URI.create("http://universities.hipolabs.com/search?name=Young");
        var dataRequest = requestMake.uri(webAddress).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException exception){
            System.out.println("Error connecting to networked resource");
        }
        catch (InterruptedException e){
            System.out.println("An error occurred getting a response from the server");

        }
        if (response == null){
            System.out.println("Something went terribly wrong - we have to close now");
            System.exit(-1);
        }
        var usefulData = response.body();
        System.out.println(usefulData);
        var dataParser = new Gson();
        //http response codes
        //200 - level response code means all works
        //400 - level errors on client side
        //500 - level errors on server side
    }
}
