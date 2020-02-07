package com.example.chat.model;

public class Message {

    private String test;
    private Boolean isMyMassage;

    public Message(String text, Boolean isMyMassage)
    {
        this.test = text;
        this.isMyMassage = isMyMassage;
    }

    public String getText() {
        return test;
    }

    public void setText(String text) {
        this.test = test;
    }

    public Boolean getMyMassage() {
        return isMyMassage;
    }

    public void setMyMassage(Boolean myMassage) {
        isMyMassage = myMassage;
    }
}
