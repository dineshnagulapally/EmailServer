package com.example.email;

import java.util.List;

public class EmailTo {
    private String from;
    private List<String> to;

    public EmailTo() {
    }

    public EmailTo(String from, List<String> to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }
}
