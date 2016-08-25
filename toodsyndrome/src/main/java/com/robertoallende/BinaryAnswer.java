package com.robertoallende;

import java.io.Serializable;

public class BinaryAnswer implements Serializable {

    private BinaryQuestion question;
    private int answerValue;

    public BinaryAnswer(BinaryQuestion question) {
        this.question = question;
        this.answerValue = -1;
    }

    public BinaryQuestion getQuestion() {
        return question;
    }

    public void setQuestion(BinaryQuestion question) {
        this.question = question;
    }

    public int getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(int answer) {
        this.answerValue = answer;
    }

    public void setNegativeResult() {
        this.answerValue = 0;
    }

    public void setPositiveResult() {
        this.answerValue = 1;
    }

}
