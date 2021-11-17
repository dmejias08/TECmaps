package Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DistancieApis {

    private static final String API_KEY = "AIzaSyANxb5J53h_B2VdCNbci0rNxeCwzs3GTyo";
    public static float[][] distances;
    public static float[][] times;




    //downloading the data
    public static float getData(String source, String destination) throws Exception {
        float distance = -1L;
        var url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + source + "&destinations=" + destination + "&key=" + API_KEY;
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        JSONParser jp = new JSONParser();
        JSONObject jo = (JSONObject) jp.parse(response);
        JSONArray ja = (JSONArray) jo.get("rows");
        jo = (JSONObject) ja.get(0);
        ja = (JSONArray) jo.get("elements");
        jo = (JSONObject) ja.get(0);
        JSONObject je = (JSONObject) jo.get("distance");
        distance = (long) je.get("value");
        float distancia =distance/1000;
        String finalDistance = "La distancia es " + distancia + " km";
        return distancia;

    }



    public static void main(String[] args) throws Exception {
        System.out.println(getData("TejarCartago","OchomogoCartago"));
        System.out.println(getData("CartagoCartago","OchomogoCartago"));
        System.out.println(getData("CartagoCartago","TejarCartago"));
    }

}


