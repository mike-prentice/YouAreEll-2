package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.Assert;
import junit.framework.TestCase;
import models.Id;
import models.Message;
import org.json.simple.JSONArray;

import java.io.DataInput;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MessageControllerTest extends TestCase {
    MessageController messages = new MessageController();

    public MessageControllerTest() throws JsonProcessingException {
    }

    public void testGetMessages()  {
        ArrayList<Message> actual = messages.getMessages();
        Assert.assertTrue(actual.size() != 0);
        }

    public void testGetMessagesForId() {
        Id id = new Id ("newId", "idonthaveone");
        ArrayList<Message> actual = messages.getMessagesForId(id);
        assertTrue(actual.size() == 0);
    }

    public void testGetMessageForSequence() {
        Message actual = messages.getMessageForSequence("f4fc966f06e3d8c626738c76cc5228b51f67c666");
        Assert.assertTrue(actual == null);
    }

    public void testGetMessagesFromFriend() {
        Id id = new Id ("newId", "idonthaveone");
        Id friend = new Id("blank", "blank");
        ArrayList<Message> actual = messages.getMessagesFromFriend(id, friend);
        assertTrue(actual.size() == 0);
    }

    public void testPostMessage() {
    }
}