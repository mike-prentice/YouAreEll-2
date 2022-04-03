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
    private final HashMap<String, Id> allIds = new HashMap<>();

    Id myId;

    public ArrayList<Id> getIds() throws JsonProcessingException {
        ServerController serverController = ServerController.shared();
        String getIds = String.valueOf(serverController.idGet());
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Id> ids = new ArrayList<>();
        ids = objectMapper.readValue(getIds, new TypeReference<>() {
        });
        for (Id i : ids) {
            allIds.put(i.getUid(), i);
        }
        return ids;
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