package com.robertoallende.diagnosis.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.robertoallende.BinaryAnswer;
import com.robertoallende.diagnosis.R;

public class ResultActivity extends AppCompatActivity {

    public static final String RESULT = "result";

    public static Intent makeIntent(Context context, int diagnosis) {
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra(RESULT, diagnosis);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setViewItems();
    }

    public void setViewItems() {
        Button button = (Button) findViewById(R.id.close_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        int diagnosis = (int) intent.getExtras().get(RESULT);
        TextView result_label = (TextView) findViewById(R.id.result_label);
        result_label.setText(String.valueOf(diagnosis) + "%");
    }

}
