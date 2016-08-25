package com.robertoallende.diagnosis.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.robertoallende.DiagnosisResult;

import java.util.List;

public class DiagnosisResultModel {

    private static String APP_KEY = "TODDSDIAGNOSIS";
    private SharedPreferences mPrefs;

    public DiagnosisResultModel(Context context) {
        mPrefs = context.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
    }

    public void save(List<DiagnosisResult> results) {
        String resultAsJSON = new Gson().toJson(results);
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(APP_KEY, resultAsJSON);
        editor.apply();
        Log.v("Diagnosis Saving Result", resultAsJSON);
    }

    public List<DiagnosisResult> recover() {
        String resultAsJSON = mPrefs.getString(APP_KEY, "");
        List<DiagnosisResult>  result =
                new Gson().fromJson(resultAsJSON, new TypeToken<List<DiagnosisResult>>() {
                }.getType());
        Log.v("Diagnosis Getting It", resultAsJSON);
        return result;
    }

}
