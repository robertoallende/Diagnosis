package com.robertoallende.diagnosis.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.robertoallende.diagnosis.R;

public class BinaryQuestionActivity extends AppCompatActivity {

    public static final String CHOICE = "choice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binaryquestion);
        setViewItems();
    }

    public void setViewItems() {
        Button button1 = (Button) findViewById(R.id.choice_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(CHOICE, 1);
                setResult(RESULT_OK);
                finish();
            }
        });

        Button button2 = (Button) findViewById(R.id.choice_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(CHOICE, 2);
                setResult(RESULT_OK);
                finish();
            }
        });

    }

}