package com.robertoallende.diagnosis.events;

import com.robertoallende.diagnosis.model.DiagnosisPlan;

public class GetDiagnosisPlanEvent {

    Boolean success;
    DiagnosisPlan diagnosisPlan;

    public GetDiagnosisPlanEvent(Boolean success, DiagnosisPlan diagnosisPlan) {
        this.success = success;
        this.diagnosisPlan = diagnosisPlan;
    }

    public DiagnosisPlan getDiagnosisPlan() {
        return diagnosisPlan;
    }

    public Boolean isSuccess(){
        return success;
    }

}
