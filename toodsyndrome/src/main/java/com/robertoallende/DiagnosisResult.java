package com.robertoallende;

public class DiagnosisResult {

    private long diagnosisDate;
    private float value;

    public DiagnosisResult() {

    }

    public DiagnosisResult(long diagnosisDate, float value) {
        this.diagnosisDate = diagnosisDate;
        this.value = value;
    }

    public long getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(long diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public float getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}