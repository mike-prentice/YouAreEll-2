package models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.ServerController;
import junit.framework.TestCase;
import org.json.simple.JSONArray;

public class MessageTest extends TestCase {
    ServerController serverController = ServerController.shared();
    JSONArray messages = ServerController.shared().messageGet();
    String messageStr = messages.toString();
    ObjectMapper objectMapper = new ObjectMapper();
    Message[] message = objectMapper.readValue(messageStr, Message[].class);
    Message messageget = new Message();

    public MessageTest() throws JsonProcessingException {
    }

    public void testTestToString() {


    }

    public void testCompareTo() {
    }

    public void testGetMessage() {

        String actual = messageget.getMessage();
        System.out.println(actual);
    }

    public void testSetMessage() {
    }

    public void testGetToId() {
    }

    public void testSetToId() {
    }

    public void testGetFromId() {
    }

    public void testSetFromId() {
    }

    public void testGetTimestamp() {
    }

    public void testGetSeqId() {
    }
}