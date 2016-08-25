package com.robertoallende.diagnosis.jobs;

import android.content.Context;

import com.robertoallende.DiagnosisResult;
import com.robertoallende.diagnosis.events.GetDiagnosisResultEvent;
import com.robertoallende.diagnosis.model.DiagnosisResultModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class GetDiagnosisResultJob extends DiagnosisApplicationJob {

    private Context mContext;

    public GetDiagnosisResultJob(Context context) {
        mContext = context;
    }

    @Override
    public void onRun() throws Throwable {
        DiagnosisResultModel resultModel = new DiagnosisResultModel(mContext);
        List<DiagnosisResult> diagnosisResult = resultModel.recover();
        GetDiagnosisResultEvent resultEvent = new GetDiagnosisResultEvent(true, diagnosisResult);
        EventBus.getDefault().post(resultEvent);
    }
}
