package controllers;

import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;
import org.json.simple.JSONArray;

public class MessageController {

    private HashSet<Message> messagesSeen = new HashSet<>();
    private final ServerController serverController = ServerController.shared();
    // why a HashSet??


//    private static MessageController mesCon;
//
//    static {
//        try {
//            mesCon = new MessageController();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }

    //public static MessageController shared() {
     //   return mesCon;
    //}

    public MessageController() throws JsonProcessingException {
        String messageString = String.valueOf(serverController.messageGet());
        ObjectMapper objectMapper = new ObjectMapper();
        messagesSeen = objectMapper.readValue(messageString, new TypeReference<>() {
        });
    }


    public ArrayList<Message> getMessages(){
        ArrayList<Message> messages = new ArrayList<>();
        for (Message i : messagesSeen) {
            messages.add(i);
        }
        return messages;
    }


    public ArrayList<Message> getMessagesForId(Id Id) {
        ArrayList<Message> messages = new ArrayList<>();
        for (Message m : messagesSeen) {
            if (m.getFromId().equals(Id.getGithub())) {
                messages.add(m);
            }
        }
        return messages;
    }


    public Message getMessageForSequence(String seq) {
        for (Message m : messagesSeen) {
            if (m.getSeqId().equals(seq)) {
                return m;
            }
        }
        return null;
    }


    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        ArrayList<Message> msgFromFriend = new ArrayList<>();
        for (Message m : messagesSeen) {
            if (m.getFromId().equals(friendId.getGithub()) && m.getToId().equals(myId.getGithub())) {
                msgFromFriend.add(m);
            }
        }
        return msgFromFriend;
    }


//    public Message postMessage(Id myId, Id toId, Message msg) throws JsonProcessingException {
//        return null;
//    }


    public void postMessage(Message message, String sourceId) throws JsonProcessingException {
         //message = new Message("It worked!", "mrising", "-");
        //sourceId = "mrising";
        ServerController.shared().messagePost(message, sourceId);

    }
}
