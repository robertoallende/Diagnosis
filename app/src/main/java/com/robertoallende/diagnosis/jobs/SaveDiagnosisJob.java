package com.robertoallende.diagnosis.jobs;

import com.robertoallende.DiagnosisResult;
import com.robertoallende.diagnosis.events.SaveDiagnosisEvent;
import com.robertoallende.diagnosis.model.DiagnosisPlanModel;

import org.greenrobot.eventbus.EventBus;

public class SaveDiagnosisJob extends DiagnosisApplicationJob {

    DiagnosisResult mResult;

    public SaveDiagnosisJob(DiagnosisResult result) {
        super();
        this.mResult = result;
    }

    @Override
    public void onRun() throws Throwable {
        DiagnosisPlanModel plan = new DiagnosisPlanModel();
        EventBus.getDefault().post(new SaveDiagnosisEvent(true));
    }
}