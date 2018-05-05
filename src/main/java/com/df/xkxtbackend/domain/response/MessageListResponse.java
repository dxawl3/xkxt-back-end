package com.df.xkxtbackend.domain.response;

import com.df.xkxtbackend.domain.Message;

import java.util.List;

public class MessageListResponse {

    private List<Message> messages;

    public MessageListResponse(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
