package models;

import com.fasterxml.jackson.annotation.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
/* 
 * POJO for an Message object
 *
 *   {
    "sequence": "-",
    "timestamp": "_",
    "fromid": "xt0fer",
    "toid": "kristofer",
    "message": "Hello, Kristofer!"
  },

*
 */
public class Message implements Comparable {
    @JsonProperty("message")
    private String message = "";
    @JsonProperty("toid")
    private String toId = "";
    @JsonProperty("fromid")
    private String fromId = "";
    private String timestamp = "-";
    @JsonProperty("sequence")
    private String seqId = "-";


    public Message(String fromId, String toId, String message){
        this.message = message;
        this.fromId = fromId;
        this.toId = toId;
    }
//    public Message(String message, String fromId, String toId, String timestamp, String sequence) {
//        this.message = message;
//        this.fromId = fromId;
//        this.toId = toId;
//        this.timestamp = timestamp;
//        this.seqId = sequence;
//    }

//    public Message(String message, String fromId, String toId) {
//        this.message = message;
//        this.fromId = fromId;
//        this.toId = toId;
//    }

    public Message() {
    }


    @Override
    public String toString() {
        return seqId + "\n" + timestamp + "\n" + "to: " + this.toId + "\nfrom: " + this.fromId + "\n" + this.message + "\n----\n";
    }

    public int compareTo(Object o) {
        return this.seqId.compareTo(((Message) o).getSeqId());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    @JsonIgnore
    public String getTimestamp() {
        return timestamp;
    }

    public String getSeqId() {
        return seqId;
    }

    @JsonProperty
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}