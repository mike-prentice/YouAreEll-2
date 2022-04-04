package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.Assert;
import junit.framework.TestCase;
import models.Id;
import models.Message;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IdControllerTest extends TestCase {


    public void testGetIds() throws JsonProcessingException {
        IdController idcont = new IdController();
        ArrayList<Id> ids = idcont.getIds();
        Assert.assertTrue(ids.size() != 0);
    }

    public void testPostId() {
    }

    public void testPutId() {
    }
}