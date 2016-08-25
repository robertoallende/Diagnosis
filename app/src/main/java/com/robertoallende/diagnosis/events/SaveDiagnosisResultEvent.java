package com.robertoallende.diagnosis.events;

public class SaveDiagnosisResultEvent extends DiagnosisEvent{

    public SaveDiagnosisResultEvent(Boolean success) {
        super(success);
        this.success = success;
    }

}
