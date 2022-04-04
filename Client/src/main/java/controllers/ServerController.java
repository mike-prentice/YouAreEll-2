package controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ServerController<JsonString> {
    HttpURLConnection con;

    private final String rootURL = "http://zipcode.rocks:8085";

    private static final ServerController svr = new ServerController();

    private ServerController() {
    }

    public static ServerController shared() {
        return svr;
    }

    public JSONArray idGet() {
        BufferedReader reader;
        JSONParser jsonParser = new JSONParser();
        JSONArray ids = null;
        try {
            URL url = new URL(rootURL + "/ids");
            con = (HttpURLConnection) url.openConnection();
            //Request Method
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader((new InputStreamReader(con.getErrorStream())));
                Object obj = jsonParser.parse(reader);
                ids = (JSONArray) obj;
                reader.close();
            } else {
                reader = new BufferedReader((new InputStreamReader(con.getInputStream())));
                Object obj = jsonParser.parse(reader);
                ids = (JSONArray) obj;
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
            URL url = new URL(rootURL + "/messages");
            con = (HttpURLConnection) url.openConnection();
            //Request Method
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader((new InputStreamReader(con.getErrorStream())));
                Object obj = jsonParser.parse(reader);
                messages = (JSONArray) obj;
                reader.close();
            } else {
                reader = new BufferedReader((new InputStreamReader(con.getInputStream())));
                Object obj = jsonParser.parse(reader);
                messages = (JSONArray) obj;
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
    public JsonString idPost(Id id) throws JsonProcessingException {
        StringBuilder response = null;
        try {
            URL url = new URL(rootURL + "/ids");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setRequestProperty("Id", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            ObjectMapper objectMapper = new ObjectMapper();
            String out = objectMapper.writeValueAsString(id);
            OutputStream os = con.getOutputStream();
            byte[] input = out.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
            int code = con.getResponseCode();
            System.out.println(code);


            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                    response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response);
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        return (JsonString) response;
//        // url -> /ids/
//        // create json from Id
//        // request
//        // reply
//        // return json
    }

    public JsonString messagePost(Message msg) throws JsonProcessingException {
        StringBuilder response = null;
        try {
            URL url = new URL(rootURL + "/ids");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setRequestProperty("Id", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            ObjectMapper objectMapper = new ObjectMapper();
            String out = objectMapper.writeValueAsString(msg);
            OutputStream os = con.getOutputStream();
            byte[] input = out.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
            int code = con.getResponseCode();
            System.out.println(code);


            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response);
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        return (JsonString) response;
//    public JsonString idPut(Id) {
//        // url -> /ids/
//    }
    }
}


// ServerController.shared.doGet()
