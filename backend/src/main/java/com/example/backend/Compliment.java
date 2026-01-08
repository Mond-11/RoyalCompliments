package com.example.backend;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "compliments")
public class Compliment {
    @Id
    private String id;
    private String text;

    public Compliment() {}

    public Compliment(String text) {
        this.text = text;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}