package controllers;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
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

    public JSONArray idGet() {
        BufferedReader reader;
        JSONParser jsonParser = new JSONParser();
        JSONArray ids = null;
        try {
            URL url = new URL(rootURL+ "/ids");
             con = (HttpURLConnection) url.openConnection();
            //Request Method
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();
            System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader((new InputStreamReader(con.getErrorStream())));
                Object obj = jsonParser.parse(reader);
                ids = (JSONArray) obj;
                System.out.println(ids);
                reader.close();
            } else {
                reader = new BufferedReader((new InputStreamReader(con.getInputStream())));
                Object obj = jsonParser.parse(reader);
                ids = (JSONArray) obj;
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

        return ids;
    }

    public JSONArray messageGet() {
        BufferedReader reader;
        JSONParser jsonParser = new JSONParser();
        JSONArray messages = null;
        try {
            URL url = new URL(rootURL+"/messages");
            con = (HttpURLConnection) url.openConnection();
            //Request Method
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();
            System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader((new InputStreamReader(con.getErrorStream())));
                Object obj = jsonParser.parse(reader);
                messages = (JSONArray) obj;
                System.out.println(messages);
                reader.close();
            } else {
                reader = new BufferedReader((new InputStreamReader(con.getInputStream())));
                Object obj = jsonParser.parse(reader);
                messages = (JSONArray) obj;
                System.out.println(messages);
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

        return messages;
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
