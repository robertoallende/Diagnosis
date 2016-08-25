package com.robertoallende.diagnosis.controller;

import android.content.Context;

import com.robertoallende.DiagnosisResult;
import com.robertoallende.diagnosis.jobs.GetDiagnosisPlanJob;
import com.robertoallende.diagnosis.jobs.GetDiagnosisResultJob;
import com.robertoallende.diagnosis.jobs.SaveDiagnosisJob;
import com.robertoallende.diagnosis.jobs.SaveDiagnosisResultJob;
import com.robertoallende.diagnosis.model.DiagnosisPlanModel;

import java.util.List;

public class DiagnosisController extends Controller {

    private static DiagnosisController instance;

    public DiagnosisController(Context context) {
        super(context);
    }

    public synchronized static DiagnosisController getInstance(Context context) {
        if(instance == null) {
            instance = new DiagnosisController(context);
        }
        return instance;
    }

    public void getDiagnosisPlan(){
        mJobManager.addJobInBackground(new GetDiagnosisPlanJob());
    }

    public void saveDiagnosis(DiagnosisPlanModel mPlan){
        long millis = System.currentTimeMillis();
        DiagnosisResult diagnosis = new DiagnosisResult(millis, mPlan.getProbability());
        mJobManager.addJobInBackground(new SaveDiagnosisJob(diagnosis));
    }

    public void getDiagnosisResult() {
        mJobManager.addJobInBackground(new GetDiagnosisResultJob(getContext()));
    }

    public void saveDiagnosisResult(List<DiagnosisResult> diagnosisResult) {
        mJobManager.addJobInBackground(new SaveDiagnosisResultJob(getContext(), diagnosisResult));
    }


}
