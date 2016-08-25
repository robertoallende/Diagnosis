package com.robertoallende.diagnosis.events;

public class SaveDiagnosisEvent {

    Boolean success;

    public SaveDiagnosisEvent(Boolean success) {
        this.success = success;
    }

    public Boolean isSuccess(){
        return success;
    }
}
