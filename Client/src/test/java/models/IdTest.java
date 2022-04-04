package models;

import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.IdController;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;

public class IdTest extends TestCase {
    IdController idcont = new IdController();
    ArrayList<Id> ids = idcont.getIds();
    Id id = new Id();

    public IdTest() throws JsonProcessingException {
    }


    public void testGetUid() {
        String uuid = "092032584c622f19eb4d7d4d0eadc8b25a84daad";
        boolean actual = false;
        for (Id i: ids
             ) {i.getUid().equals(uuid);
                actual = true;
        }
        Assert.assertTrue(actual);
    }

    public void testTestGetName() {
        String name = "Gunjan";
        boolean actual = false;
        for (Id i: ids
        ) {i.getName().equals(name);
            actual = true;
        }
        Assert.assertTrue(actual);
    }

    public void testTestSetName() {
        String name = "mike-prentice";
        id.setName(name);
        String actual = id.getName();
        junit.framework.Assert.assertEquals(name, actual);
    }

    public void testGetGithub() {
        String gitHub = "HubHub";
        boolean actual = false;
        for (Id i: ids
        ) {i.getGithub().equals(gitHub);
            actual = true;
        }
        Assert.assertTrue(actual);
    }

    public void testSetGithub() {
        String git = "mike-prentice";
        id.setGithub(git);
        String actual = id.getGithub();
        junit.framework.Assert.assertEquals(git, actual);
    }

    public void testTestToString() {
    }
}