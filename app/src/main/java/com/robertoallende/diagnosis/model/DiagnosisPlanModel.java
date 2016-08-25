package com.robertoallende.diagnosis.model;

import com.robertoallende.BinaryAnswer;
import com.robertoallende.BinaryQuestion;
import com.robertoallende.ToddsDiagnosis;

public class DiagnosisPlanModel {

    ToddsDiagnosis plan;

    public DiagnosisPlanModel() {
        this.plan = new ToddsDiagnosis();

        plan.addQuestion(new BinaryQuestion("Have you migraines ?", "Yes", "No", 1));
        plan.addQuestion(new BinaryQuestion("How old are you ?", "15 years old or younger", "16 years old or older", 1));
        plan.addQuestion(new BinaryQuestion("What is your sex ?", "Male", "Female", 1));
        plan.addQuestion(new BinaryQuestion("Have you used hallucinogenic drugs ?", "Yes", "No", 1));

    }

    public BinaryAnswer getNextUnanswered() {
        return plan.getNextUnanswered();
    }

    public void saveAnswer(BinaryAnswer binaryAnswer) {
        plan.saveUnansweredAnswer(binaryAnswer);
    }

    public float getProbability() {
        return plan.getProbability();
    }
}
