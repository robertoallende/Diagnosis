package com.robertoallende.diagnosis.events;

import com.robertoallende.diagnosis.model.DiagnosisPlanModel;

public class GetDiagnosisPlanEvent extends DiagnosisEvent {

    DiagnosisPlanModel diagnosisPlanModel;

    public GetDiagnosisPlanEvent(Boolean success, DiagnosisPlanModel diagnosisPlanModel) {
        super(success);
        this.diagnosisPlanModel = diagnosisPlanModel;
    }

    public DiagnosisPlanModel getDiagnosisPlanModel() {
        return diagnosisPlanModel;
    }


}
