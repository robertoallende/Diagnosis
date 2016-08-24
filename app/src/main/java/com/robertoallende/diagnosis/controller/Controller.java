package com.robertoallende.diagnosis.controller;

import android.content.Context;

import com.birbit.android.jobqueue.JobManager;
import com.robertoallende.diagnosis.DiagnosisApplication;

public class Controller {

    protected JobManager mJobManager;

    public Controller(Context context) {
        // Backendless.initApp(context, PartyPlannerConfig.BACKENDLESS_APP_ID,
        //        PartyPlannerConfig.BACKENDLESS_SECRET_KEY,
        //        context.getResources().getString(R.string.backendless_app_version));

        mJobManager = DiagnosisApplication.getInstance().getJobManager();
    }

}
