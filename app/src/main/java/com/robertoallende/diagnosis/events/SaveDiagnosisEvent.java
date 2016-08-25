package com.robertoallende.diagnosis.events;

public class SaveDiagnosisEvent extends DiagnosisEvent{

    public SaveDiagnosisEvent(Boolean success) {
        super(success);
        this.success = success;
    }

}
