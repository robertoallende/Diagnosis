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

    private List<BinaryAnswer> plan;

    public ToddsDiagnosis() {
            plan = new ArrayList<BinaryAnswer>();
    }

    public void addQuestion(BinaryQuestion question) {
        BinaryAnswer binaryAnswer = new BinaryAnswer(question);
        plan.add(binaryAnswer);
    }

    public Question getQuestion(int i) {
        if (i < plan.size()) {
            return plan.get(i).getQuestion();
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Trying to get a non existing question.");
        }
    }

    public void setAnswer(int i, BinaryAnswer binaryAnswer) {
        if (i < plan.size() && binaryAnswer != null) {
            plan.set(i, binaryAnswer);
        } else {
            throw new ArrayIndexOutOfBoundsException("Trying to set a non existing answer.");
        }
    }

    public float getProbability(){

        int total = 0;

        for (BinaryAnswer binaryAnswer : plan) {
            total += binaryAnswer.getAnswerValue();
        }

        if (plan.size() == 0) {
            return 0;
        }

        return (total / (float) plan.size() )  * 100;
    }

    public BinaryAnswer getNextUnanswered(){
        BinaryAnswer result = null;

        for (BinaryAnswer a: plan) {
            if (a.getAnswerValue() == -1){
                result = a;
                break;
            }
        }

        return result;
    }


    public void saveUnansweredAnswer(BinaryAnswer binaryAnswer) {

        for (int i = 0; i < plan.size() ; i++) {
            if (plan.get(i).getAnswerValue() == -1){
                // TODO: check the answer is the same
                plan.get(i).setAnswerValue(binaryAnswer.getAnswerValue());
                break;
            }
        }
        return;
    }
}