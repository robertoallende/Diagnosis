package com.robertoallende.diagnosis.jobs;

import com.robertoallende.DiagnosisResult;
import com.robertoallende.diagnosis.events.GetDiagnosisPlanEvent;
import com.robertoallende.diagnosis.events.SaveDiagnosisEvent;
import com.robertoallende.diagnosis.model.DiagnosisPlan;

import org.greenrobot.eventbus.EventBus;

public class SaveDiagnosisJob extends DiagnosisApplicationJob {

    DiagnosisResult mResult;

    public SaveDiagnosisJob(DiagnosisResult result) {
        super();
        this.mResult = result;
    }

    @Override
    public void onRun() throws Throwable {
        DiagnosisPlan plan = new DiagnosisPlan();
        EventBus.getDefault().post(new SaveDiagnosisEvent(true));
    }
}