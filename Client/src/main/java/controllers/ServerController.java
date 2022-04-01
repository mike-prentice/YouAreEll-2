package controllers;

import com.fasterxml.jackson.core.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServerController<JsonString> {
    HttpURLConnection con;

    private String rootURL = "http://zipcode.rocks:8085";

    private static ServerController svr = new ServerController();

    private ServerController() {}

    public static ServerController shared() {
        return svr;
    }

    public JsonString idGet() {
        BufferedReader reader;
        String line = "";
        StringBuffer response = new StringBuffer();
        JSONParser jsonParser = new JSONParser();
        try {
            URL url = new URL("http://zipcode.rocks:8085/ids");
             con = (HttpURLConnection) url.openConnection();
            //Request Method
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();
            System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader((new InputStreamReader(con.getErrorStream())));
                line = reader.readLine();
                while (line != null) {
                    response.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader((new InputStreamReader(con.getInputStream())));
                Object obj = jsonParser.parse(reader);
                JSONArray ids = (JSONArray) obj;
                System.out.println(ids);
                reader.close();

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
        System.out.println(response.toString());

        return (JsonString) response;
    }
        // url -> /ids/
        // send the server a get with url
        // return json from server
//    }
//    public JsonString idPost(Id) {
//        // url -> /ids/
//        // create json from Id
//        // request
//        // reply
//        // return json
//    }
//    public JsonString idPut(Id) {
//        // url -> /ids/
//    }

}


// ServerController.shared.doGet()
