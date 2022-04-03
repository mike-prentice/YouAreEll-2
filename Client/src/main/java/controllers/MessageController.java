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
    // why a HashSet??
    public List<Message> messages;

    private static MessageController mesCon;

    static {
        try {
            mesCon = new MessageController();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static MessageController shared() {
        return mesCon;
    }

    private MessageController() throws JsonProcessingException {

    }


        public ArrayList<Message> getMessages() throws JsonProcessingException {
            ServerController serverController = ServerController.shared();
            JSONArray messagesJSON = serverController.messageGet();
            String messageString = messagesJSON.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            messagesSeen = objectMapper.readValue(messageString, new TypeReference<HashSet<Message>>(){});
            for (int i = 0; i < messagesSeen.size()-1; i++) {
                System.out.println(messagesSeen);
            }



            System.out.println(messages);
            return (ArrayList<Message>) messages;
        }


        public ArrayList<Message> getMessagesForId (Id Id){
            for (int i = 0; i < messages.size(); i++) {
                String stringId = Id.getGithub();
                if (messages.get(i).getToId().equals(stringId)){
                    System.out.println(stringId);
                }
            }
            return null;
        }


        public Message getMessageForSequence (String seq){
            return null;
        }


        public ArrayList<Message> getMessagesFromFriend (Id myId, Id friendId){
            return null;
        }


        public Message postMessage (Id myId, Id toId, Message msg){
            return null;
        }


}

//

//        JSONArray messages = ServerController.shared().messageGet();
//        String messageStr = messages.toString();
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<Map<String, Object>> map = objectMapper.readValue(messageStr, new TypeReference<List<Map<String, Object>>>() {
//        });
//        for (int i = 0; i < map.size(); i++) {
//            System.out.println(map.get(i));
//
//        }

//        for (int i = 0; i < messagesJSON.size(); i++) {
//            Object object = messagesJSON.get(i);
//            String string = object.toString();
//            String[] messageList = string.split("");
//            String toid = messageList[0].substring(8);
//            String sequence = messageList[1].substring(11);
//            String message = messageList[2].substring(10);
//            String fromid = messageList[3].substring(9);
//            String timestamp = messageList[4].substring(12);
//            Message messageObject = new Message(message, fromid, toid, timestamp, sequence);
//            messagesSeen.add(messageObject);
//            System.out.println(messagesSeen);
//        }


//            ObjectMapper objectMapper = new ObjectMapper();
//            List map = objectMapper.readValue(messagesSeen);
//            ArrayList<Message> mostRecent = (ArrayList<Message>) map.stream().sorted(Comparator.comparing(Message::getTimestamp));
//            mostRecent.forEach(System.out::println);
//            return mostRecent;
//        }
// Message[] array = messagesSeen.toArray(new Message[0]);
//ArrayList<Message> messages = new ArrayList<>();
//            for (int i = 0; i < 21; i++) {
//                messages.add(array[i]);
//           }

//            ArrayList<Message> copy = (ArrayList<Message>) messages.stream()
//                    .sorted(Comparator.comparing(Message::getTimestamp));
//            ArrayList<Message> mostRecent = new ArrayList<>();
//            for (int i = 20; i > 0; i++) {
//                mostRecent.add(copy.get(i));
//                mostRecent.forEach(System.out::println);
//
//            }