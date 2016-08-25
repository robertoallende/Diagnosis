package com.robertoallende.diagnosis.view.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.robertoallende.DiagnosisResult;
import com.robertoallende.diagnosis.R;
import com.robertoallende.diagnosis.common.RecyclerViewActivity;

import java.util.ArrayList;
import java.util.List;

public class DiagnosisResultAdapter extends RecyclerView.Adapter<DiagnosisResultRowHolder> {

    RecyclerViewActivity mContext;
    List<DiagnosisResult> mDiagnosisResult = new ArrayList<>();

    public DiagnosisResultAdapter(RecyclerViewActivity context) {
        mContext = context;
    }

    public void replaceList(final List<DiagnosisResult> diagnosisList) {
        try {
            mDiagnosisResult.clear();
            mContext.getRecyclerView().getRecycledViewPool().clear();
            mDiagnosisResult.addAll(diagnosisList);
            notifyDataSetChanged();
        } catch (Exception e) {
            Log.v("Diagnosis", e.getMessage());
        }
    }

    @Override
    public DiagnosisResultRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return(new DiagnosisResultRowHolder(li.inflate(R.layout.content_layout_list_row, parent, false)));
    }

    @Override
    public void onBindViewHolder(DiagnosisResultRowHolder holder, int position) {
        holder.bindModel(mDiagnosisResult.get(position));
    }

    @Override
    public int getItemCount() {
        if (mDiagnosisResult == null) {
            return 0;
        }
        return(mDiagnosisResult.size());
    }
}
