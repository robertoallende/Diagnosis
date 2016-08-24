package com.robertoallende;

import java.io.Serializable;

public class Answer implements Serializable {

    private Question question;
    private int answerValue;

    public Answer(Question question) {
        this.question = question;
        this.answerValue = 0;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(int answer) {
        this.answerValue = answer;
    }
}
