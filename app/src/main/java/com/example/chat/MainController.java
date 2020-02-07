package com.example.chat;

import com.example.chat.model.Message;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public interface MainController {
    interface View
    {
        void updateMessages();
    }

    interface Presenter
    {
       void onSend(String message);
        List<Message> getListMessage();
    }

    interface Model
    {
        void createListenerMessage(MainController.View view);
        void pushMessage(String message);
        List<Message> getListMessage();
    }
}
