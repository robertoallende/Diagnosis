package com.robertoallende.diagnosis.controller;

import android.content.Context;

import com.robertoallende.DiagnosisResult;
import com.robertoallende.diagnosis.jobs.GetDiagnosisPlanJob;
import com.robertoallende.diagnosis.jobs.SaveDiagnosisJob;
import com.robertoallende.diagnosis.model.DiagnosisPlan;

import java.util.Date;

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

    public void saveDiagnosis(DiagnosisPlan mPlan){
        long millis = System.currentTimeMillis();
        DiagnosisResult diagnosis = new DiagnosisResult(millis, mPlan.getProbability());
        mJobManager.addJobInBackground(new SaveDiagnosisJob(diagnosis));
    }

}
