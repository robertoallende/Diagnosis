package com.robertoallende;

public class PreviousDiagnosis {

    private long diagnosisDate;
    private int value;

    public PreviousDiagnosis() {

    }

    public PreviousDiagnosis(long diagnosisDate, int value) {
        this.diagnosisDate = diagnosisDate;
        this.value = value;
    }

    public long getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(long diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}