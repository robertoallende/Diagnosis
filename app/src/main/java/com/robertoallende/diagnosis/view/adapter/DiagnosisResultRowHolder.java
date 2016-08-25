package com.robertoallende.diagnosis.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.robertoallende.DiagnosisResult;
import com.robertoallende.diagnosis.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DiagnosisResultRowHolder extends RecyclerView.ViewHolder{

    private DiagnosisResult mDiagnosisResult;
    private TextView mTitle;
    private TextView mDate;

    public DiagnosisResultRowHolder(View itemView) {
        super(itemView);
        mDate = (TextView) itemView.findViewById(R.id.left_text);
        mTitle = (TextView) itemView.findViewById(R.id.right_text);
    }

    void bindModel(DiagnosisResult diagnosisResult) {
        mDiagnosisResult = diagnosisResult;

        mDate.setText(longToDate(mDiagnosisResult.getDiagnosisDate()));
        mTitle.setText(String.valueOf(mDiagnosisResult.getValue()) + "%");

    }

    private String longToDate(long dateLong) {
        DateFormat df = new SimpleDateFormat("MMMM d, yyyy h:mm a");
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(dateLong);
        return df.format(c.getTime());
    }



}
