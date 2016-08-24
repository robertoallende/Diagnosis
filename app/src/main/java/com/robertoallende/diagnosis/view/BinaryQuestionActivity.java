package com.robertoallende.diagnosis.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.robertoallende.Answer;
import com.robertoallende.diagnosis.R;

public class BinaryQuestionActivity extends AppCompatActivity {

    public static final String CHOICE = "choice";
    public static final String ANSWER = "answer";

    public static Intent makeIntent(Context context, Answer answer) {
        Intent intent = new Intent(context, BinaryQuestionActivity.class);
        intent.putExtra(ANSWER, answer);
        return intent;
    }

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

        TextView question_label = (TextView) findViewById(R.id.question_label);
        Button choice_1 = (Button) findViewById(R.id.choice_1);
        Button choice_2 = (Button) findViewById(R.id.choice_2);

        Intent intent = getIntent();
        Answer answer = (Answer) intent.getExtras().get(ANSWER);
        question_label.setText(answer.getQuestion().getQuestionText());
        choice_1.setText(answer.getQuestion().getPostiveText());
        choice_2.setText(answer.getQuestion().getNegativeText());

    }

}