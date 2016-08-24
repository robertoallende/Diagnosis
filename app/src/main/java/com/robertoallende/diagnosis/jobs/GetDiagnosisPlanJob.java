package com.robertoallende.diagnosis.jobs;

import com.robertoallende.diagnosis.events.GetDiagnosisPlanEvent;
import com.robertoallende.diagnosis.model.DiagnosisPlan;

import org.greenrobot.eventbus.EventBus;

public class GetDiagnosisPlanJob extends DiagnosisApplicationJob {

    public GetDiagnosisPlanJob() {
        super();
    }

    @Override
    public void onRun() throws Throwable {
        DiagnosisPlan plan =  new DiagnosisPlan();
        EventBus.getDefault().post(new GetDiagnosisPlanEvent(true, plan));
    }

}
