package com.example.email;

import java.util.List;

public class EmailTo {
    private String from;
    private List<String> to;

    private List<String> name;

    public EmailTo() {
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public EmailTo(String from, List<String> to, List<String> name) {
        this.from = from;
        this.to = to;
        this.name = name;
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
