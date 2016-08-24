package com.robertoallende;

public class BinaryQuestion extends Question {

    private String postiveText;
    private String negativeText;

    public BinaryQuestion(
            String questionText, String postiveText, String negativeText , int weight) {
        super(questionText, weight);
        this.postiveText = postiveText;
        this.negativeText = negativeText;
    }

    public String getPostiveText() {
        return postiveText;
    }

    public void setPostiveText(String postiveText) {
        this.postiveText = postiveText;
    }

    public String getNegativeText() {
        return negativeText;
    }

    public void setNegativeText(String negativeText) {
        this.negativeText = negativeText;
    }
}
