package com.robertoallende.diagnosis.events;


import com.robertoallende.DiagnosisResult;

import java.util.List;

public class GetDiagnosisResultEvent extends DiagnosisEvent {

    List<DiagnosisResult> mDiagnosisResult;

    public GetDiagnosisResultEvent(Boolean success, List<DiagnosisResult>  diagnosisResult) {
        super(success);
        this.mDiagnosisResult = diagnosisResult;
    }

    public List<DiagnosisResult>  getDiagnosisResult() {
        return mDiagnosisResult;
    }

}
