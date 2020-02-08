package com.example.chat.model;

import android.util.Log;

import com.example.chat.MainController;
import com.example.chat.listener.SendAndRecevMessage;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MessageRepository implements MainController.Model {

    final String TAG = "Repository";

  private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
  private DatabaseReference databaseReference = firebaseDatabase.getReference("messages");
  private List<Message> messages;

  public MessageRepository()
  {
      messages = new ArrayList<>();
      firebaseDatabase = FirebaseDatabase.getInstance();
      databaseReference = firebaseDatabase.getReference("messages");
  }

    @Override
    public void createListenerMessage(MainController.View view) {
        databaseReference.addChildEventListener(new SendAndRecevMessage(databaseReference,messages,view));
    }

    @Override
  public void pushMessage(String message)
  {
      databaseReference.push().setValue(message);
      Log.d(TAG,"pushMessage - " + message);
  }

    @Override
    public List<Message> getListMessage() {
        return messages;
    }
}
