package com.robertoallende.diagnosis.model;

import com.robertoallende.Answer;
import com.robertoallende.BinaryQuestion;
import com.robertoallende.ToddsDiagnosis;

public class DiagnosisPlan {

    ToddsDiagnosis plan;

    public DiagnosisPlan() {
        this.plan = new ToddsDiagnosis();

        plan.addQuestion(new BinaryQuestion("Have you migraines ?", "Yes", "No", 1));
        plan.addQuestion(new BinaryQuestion("How old are you ?", "15 years old or younger", "16 years old or older", 1));
        plan.addQuestion(new BinaryQuestion("What is your sex ?", "Male", "Female", 1));
        plan.addQuestion(new BinaryQuestion("Have you used hallucinogenic drugs ?", "Yes", "No", 1));

    }

    public Answer getNextUnanswered() {
        return plan.getNextUnanswered();
    }

}
