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

public class BinaryQuestionActivity extends AppCompatActivity {

    public static final String ANSWER = "answer";
    private BinaryAnswer mBinaryAnswer;

    public static Intent makeIntent(Context context, BinaryAnswer binaryAnswer) {
        Intent intent = new Intent(context, BinaryQuestionActivity.class);
        intent.putExtra(ANSWER, binaryAnswer);
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
                mBinaryAnswer.setPositiveResult();
                Intent intent = new Intent();
                intent.putExtra(ANSWER, mBinaryAnswer);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button button2 = (Button) findViewById(R.id.choice_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinaryAnswer.setNegativeResult();
                Intent intent = new Intent();
                intent.putExtra(ANSWER, mBinaryAnswer);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        TextView question_label = (TextView) findViewById(R.id.question_label);
        Button choice_1 = (Button) findViewById(R.id.choice_1);
        Button choice_2 = (Button) findViewById(R.id.choice_2);

        Intent intent = getIntent();
        mBinaryAnswer = (BinaryAnswer) intent.getExtras().get(ANSWER);
        question_label.setText(mBinaryAnswer.getQuestion().getQuestionText());
        choice_1.setText(mBinaryAnswer.getQuestion().getPostiveText());
        choice_2.setText(mBinaryAnswer.getQuestion().getNegativeText());

    }
}