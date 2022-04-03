package youareell;

import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.*;
import models.Id;
import models.Message;
import views.IdTextView;
import views.MessageTextView;

import java.util.List;

public class YouAreEll {

    TransactionController tt;

    public YouAreEll(TransactionController t) {
        this.tt = t;
    }

    public static void main(String[] args) throws JsonProcessingException {

        //hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(
                new TransactionController(
                        new MessageController(), new IdController()
                ));
        System.out.println(urlhandler.MakeURLCall("/ids"));//, "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages"));//, "GET", ""));
    }

    public String MakeURLCall(String info) throws JsonProcessingException {
        if(info.equals("/ids")) {
            return get_ids();
        }else {
            return get_messages();
        }
    }


    public String get_ids() throws JsonProcessingException {
        List<Id> ids = tt.getIds();
        String show = "";
        for (Id i : ids) {
            IdTextView view = new IdTextView(i);
            show += view + "\n";
        }
        return show;
        //return tt.makecall("/ids", "GET", "");
    }

    public String get_messages() throws JsonProcessingException {
        List<Message> message = tt.getMessages();
        String show = "";
        for (Message i : message) {
            MessageTextView view = new MessageTextView();
            show += view.toString(i) + "\n";
        }
        return show;
        //return MakeURLCall("/messages", "GET", "");
    }


}
