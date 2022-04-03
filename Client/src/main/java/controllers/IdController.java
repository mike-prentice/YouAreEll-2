package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import org.json.simple.JSONArray;

public class IdController {
    private HashMap<String, Id> allIds;
    private ArrayList<Id> gatherIds;
    private ServerController serverController;
    Id myId;

    public IdController(ServerController serverController) throws JsonProcessingException {
        this.gatherIds = new ArrayList<Id>();
        this.myId = null;
        this.serverController = serverController;
        getIds();
    }

    public ArrayList<Id> getIds() throws JsonProcessingException {
        String getIds = String.valueOf(serverController.idGet());
        ObjectMapper objectMapper = new ObjectMapper();
        gatherIds = objectMapper.readValue(getIds, new TypeReference<ArrayList<Id>>() {});
        allIds = objectMapper.readValue(getIds, new TypeReference<HashMap<String, Id>>() {});
        System.out.println(gatherIds);

        for (Map.Entry<String, Id> entry : allIds.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        return gatherIds;
    }

    public Id postId(Id id) {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj

        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}