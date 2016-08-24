package com.robertoallende.diagnosis.jobs;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

public abstract class DiagnosisApplicationJob extends Job {

    public static int LOW = 0;
    public static int MID = 500;
    public static int HIGH = 1000;

    // final protected BackendlessDataQuery dataQuery = new BackendlessDataQuery();

    public DiagnosisApplicationJob() {
        super(new Params(HIGH).requireNetwork().groupBy("DiagnosisApplicationJob").singleInstanceBy("DiagnosisApplicationJob"));
        //dataQuery.setPageSize(100);
    }

    @Override
    public void onAdded() {

    }

    @Override
    protected void onCancel(int cancelReason) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }

}
