package com.example.chat.presenter;

import com.example.chat.MainController;
import com.example.chat.model.Message;
import com.example.chat.model.MessageRepository;

import java.util.ArrayList;
import java.util.List;

public class MessagePresenter implements MainController.Presenter {


    private MainController.Model messageRepository;
    private MainController.View view;

   public MessagePresenter(MainController.View view)
    {
        this.view = view;
        messageRepository = new MessageRepository();
        createListener();
    }

    private void createListener()
    {
        messageRepository.createListenerMessage(view);
    }

    @Override
    public void onSend(String message) {
        messageRepository.pushMessage(message);
    }

    @Override
    public List<Message> getListMessage() {
        return messageRepository.getListMessage();
    }


}
