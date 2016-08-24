package com.robertoallende;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToddsDiagnosis implements Serializable {

    /* ToddsDiagnosis represents a set of questions and answers.
       This class allows:
         Define a diagnosis plan through a set of questions to be answered.
         Set the answers to those questions.
         Calculate the result of the diagnosis.
     */

    private List<Answer> plan;

    public ToddsDiagnosis() {
            plan = new ArrayList<Answer>();
    }

    public void addQuestion(Question question) {
        Answer answer = new Answer(question);
        plan.add(answer);
    }

    public Question getQuestion(int i) {
        if (i < plan.size()) {
            return plan.get(i).getQuestion();
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Trying to get a non existing question.");
        }
    }

    public void setAnswer(int i, Answer answer) {
        if (i < plan.size() && answer != null) {
            plan.set(i, answer);
        } else {
            throw new ArrayIndexOutOfBoundsException("Trying to set a non existing answer.");
        }
    }

    public int getProbability(){

        int total = 0;

        for (Answer answer: plan) {
            total += answer.getAnswerValue();
        }

        if (plan.size() == 0) {
            return 0;
        }

        return (total / plan.size()) * 100;
    }

}