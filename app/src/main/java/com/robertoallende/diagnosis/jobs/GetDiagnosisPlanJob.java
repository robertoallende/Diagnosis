package com.robertoallende.diagnosis.jobs;

import com.robertoallende.diagnosis.events.GetDiagnosisPlanEvent;
import com.robertoallende.diagnosis.model.DiagnosisPlanModel;

import org.greenrobot.eventbus.EventBus;

public class GetDiagnosisPlanJob extends DiagnosisApplicationJob {

    public GetDiagnosisPlanJob() {
        super();
    }

    @Override
    public void onRun() throws Throwable {
        DiagnosisPlanModel plan =  new DiagnosisPlanModel();
        EventBus.getDefault().post(new GetDiagnosisPlanEvent(true, plan));
    }

}
