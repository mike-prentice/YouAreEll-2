package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import models.Message;
import org.json.simple.JSONArray;

import java.io.DataInput;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MessageControllerTest extends TestCase {
    ServerController serverController = ServerController.shared();

    public void testGetMessages() throws IOException {
        JSONArray messages = ServerController.shared().messageGet();
        String messageStr = messages.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        Message[] message;
        message = objectMapper.readValue(messageStr, Message[].class);
        System.out.println(Arrays.toString(message));
//        MessageController messageController = MessageController.shared();
//        messageController.getMessages();

        }

    public void testGetMessagesForId() {

    }

    public void testGetMessageForSequence() {
    }

    public void testGetMessagesFromFriend() {
    }

    public void testPostMessage() {
    }
}