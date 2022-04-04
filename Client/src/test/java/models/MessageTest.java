package models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.MessageController;
import controllers.ServerController;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.json.simple.JSONArray;

import java.util.ArrayList;

public class MessageTest extends TestCase {
    MessageController msgCont = new MessageController();
    ArrayList<Message> message = msgCont.getMessages();
    Message message1 = new Message();

    public MessageTest() throws JsonProcessingException {
    }

    public void testTestToString() {
    }

    public void testCompareTo() {
    }

    public void testGetMessage() {
        boolean actual = false;
        String expected = "apple";
        for (Message m : message
             ) { if(m.equals(expected));
            actual = true;
        }
        assertTrue(actual);
    }

    public void testSetMessage() {
        String expectedMsg = "AmandaJ-Huang";
        message1.setMessage(expectedMsg);
        String actual = message1.getMessage();
        Assert.assertEquals(expectedMsg, actual);
    }

    public void testGetToId() {
        boolean actual = false;
        String expected = "AmandaJ-Huang";
        for (Message m : message
        ) { if(m.getToId().equals(expected));
            actual = true;
        }
        assertTrue(actual);
    }

    public void testSetToId() {
        String expectedId = "AmandaJ-Huang";
        message1.setToId(expectedId);
        String actual = message1.getToId();
        Assert.assertEquals(expectedId, actual);
    }

    public void testGetFromId() {
        boolean actual = false;
        String expected = "AmandaJ-Huang";
        for (Message m : message
        ) { if(m.getFromId().equals(expected));
            actual = true;
        }
        assertTrue(actual);
    }

    public void testSetFromId() {
        String expectedId = "AmandaJ-Huang";
        message1.setFromId(expectedId);
        String actual = message1.getFromId();
        Assert.assertEquals(expectedId, actual);
    }

}