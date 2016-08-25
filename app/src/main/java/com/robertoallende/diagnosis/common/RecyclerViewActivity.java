package com.robertoallende.diagnosis.common;

/**
 * Following:
 * https://github.com/commonsguy/cw-omnibus/blob/v7.3/RecyclerView/SimpleList/app/src/main/java/com/commonsware/android/recyclerview/simplelist/RecyclerViewActivity.java
 */

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewUtils;
import android.widget.TextView;

public abstract class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView = null;

    public abstract RecyclerView getRecyclerView();

    public void setAdapter(RecyclerView.Adapter adapter) {
        getRecyclerView().setAdapter(adapter);
    }

    public RecyclerView.Adapter getAdapter() {
        return(getRecyclerView().getAdapter());
    }

    public void setLayoutManager(RecyclerView.LayoutManager mgr) {
        getRecyclerView().setLayoutManager(mgr);
    }

}