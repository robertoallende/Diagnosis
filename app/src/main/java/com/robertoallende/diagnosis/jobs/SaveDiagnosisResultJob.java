package com.robertoallende.diagnosis.jobs;

import android.content.Context;

import com.robertoallende.DiagnosisResult;
import com.robertoallende.diagnosis.events.GetDiagnosisResultEvent;
import com.robertoallende.diagnosis.events.SaveDiagnosisResultEvent;
import com.robertoallende.diagnosis.model.DiagnosisResultModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class SaveDiagnosisResultJob extends DiagnosisApplicationJob {

    private Context mContext;
    private List<DiagnosisResult>  mDiagnosisResult;

    public SaveDiagnosisResultJob(Context context, List<DiagnosisResult> result) {
        mContext = context;
        mDiagnosisResult = result;
    }

    @Override
    public void onRun() throws Throwable {

        DiagnosisResultModel resultModel = new DiagnosisResultModel(mContext);
        resultModel.save(mDiagnosisResult);
        SaveDiagnosisResultEvent resultEvent = new SaveDiagnosisResultEvent(true);
        EventBus.getDefault().post(resultEvent);

    }
}