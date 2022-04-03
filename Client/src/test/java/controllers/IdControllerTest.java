package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import models.Id;
import models.Message;
import org.json.simple.JSONArray;

import java.util.Arrays;
import java.util.List;

public class IdControllerTest extends TestCase {
    ServerController serverController = ServerController.shared();
    JSONArray id = ServerController.shared().idGet();
    String idStr = id.toJSONString();

    public void testGetIds() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Id[] ids = objectMapper.readValue(idStr, Id[].class);
        System.out.println(Arrays.toString(ids));
        Message messageOB = new Message();
        MessageController messageController = MessageController.shared();
        messageController.getMessages();
    }

    public void testPostId() {
    }

    public void testPutId() {
    }
}