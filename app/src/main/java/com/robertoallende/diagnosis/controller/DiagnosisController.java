package com.robertoallende.diagnosis.controller;

import android.content.Context;

import com.robertoallende.diagnosis.jobs.GetDiagnosisPlanJob;

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

}
