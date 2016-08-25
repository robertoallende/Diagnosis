package com.robertoallende.diagnosis.events;

public abstract class DiagnosisEvent {

    Boolean success;

    public DiagnosisEvent(Boolean success) {
        this.success = success;
    }

    public Boolean isSuccess(){
        return success;
    }

}
