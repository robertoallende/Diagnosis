package com.robertoallende;

import java.io.Serializable;

public abstract class Question implements Serializable {

    private int id;
    private String questionText;
    private int weight;

    public Question(int id, String questionText, int weight) {
        this.id = id;
        this.questionText = questionText;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
