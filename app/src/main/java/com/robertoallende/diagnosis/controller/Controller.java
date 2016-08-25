package com.robertoallende.diagnosis.controller;

import android.content.Context;

import com.birbit.android.jobqueue.JobManager;
import com.robertoallende.diagnosis.DiagnosisApplication;

public class Controller {

    protected JobManager mJobManager;
    private Context mContext;

    public Controller(Context context) {
        mContext = context;
        mJobManager = DiagnosisApplication.getInstance().getJobManager();
    }

    public Context getContext() {
        return mContext;
    }

}
