package com.robertoallende;

import java.io.Serializable;

public abstract class Question implements Serializable {

    private String questionText;
    private int weight;

    public Question(String questionText, int weight) {
        this.questionText = questionText;
        this.weight = weight;
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
