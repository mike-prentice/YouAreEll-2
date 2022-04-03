package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.Id;
import models.Message;

import java.util.List;

public class TransactionController {
    private final String rootURL = "http://zipcode.rocks:8085";
    private final MessageController msgCtrl;
    private final IdController idCtrl;

    public TransactionController(MessageController m, IdController j) {
        idCtrl = j;
        msgCtrl = m;
    }

    public List<Id> getIds() throws JsonProcessingException {
        List<Id> ids = idCtrl.getIds();
        return ids;
    }

    public List<Message> getMessages() throws JsonProcessingException {
        List<Message> messages = msgCtrl.getMessages();
        return messages;
    }

    public String postId(String idtoRegister, String githubName) throws JsonProcessingException {
        Id tid = new Id(idtoRegister, githubName);
        tid = idCtrl.postId(tid);
        return ("Id registered.");
    }
}
