package com.example.chat.listener;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.chat.MainController;
import com.example.chat.model.Message;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class SendAndRecevMessage implements ChildEventListener {

    private List<Message> messages;
    private DatabaseReference databaseReference;
    private MainController.View view;

    public SendAndRecevMessage(DatabaseReference databaseReference,List<Message> messages,MainController.View view)
    {
        this.databaseReference = databaseReference;
        this.messages = messages;
        this.view = view;
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        String msg = dataSnapshot.getValue(String.class);
        messages.add(new Message(msg,false));
        view.updateMessages();
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
