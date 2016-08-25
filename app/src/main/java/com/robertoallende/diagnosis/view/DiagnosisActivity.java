package com.robertoallende.diagnosis.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.robertoallende.BinaryAnswer;
import com.robertoallende.diagnosis.R;
import com.robertoallende.diagnosis.controller.DiagnosisController;
import com.robertoallende.diagnosis.events.GetDiagnosisPlanEvent;
import com.robertoallende.diagnosis.events.SaveDiagnosisEvent;
import com.robertoallende.diagnosis.model.DiagnosisPlan;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class DiagnosisActivity extends AppCompatActivity {

    private static final int BINARY_QUESTION = 1;

    private DiagnosisPlan mPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);
        setViewItems();
        EventBus.getDefault().register(this);
    }

    public void setViewItems() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuestionActivity();

            }
        });

        getDiagnosisPlan();
    }

    public void getDiagnosisPlan() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (mPlan == null) {
            DiagnosisController controller = DiagnosisController.getInstance(this);
            controller.getDiagnosisPlan();
        } else {
            fab.setEnabled(true);
        }
    }

    public void cleanDiagnosis() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setEnabled(false);
        mPlan = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_diagnosis, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BINARY_QUESTION) {
            if (resultCode == RESULT_OK) {

                BinaryAnswer binaryAnswer =
                        (BinaryAnswer) data.getExtras().get(BinaryQuestionActivity.ANSWER);
                mPlan.saveAnswer(binaryAnswer);

                startQuestionActivity();

            }
        }
    }

    public void startResultActivity() {
        float diagnosis = mPlan.getProbability();
        Intent intent = ResultActivity.makeIntent(this, diagnosis);
        cleanDiagnosis();
        startActivity(intent);
    }

    public void startQuestionActivity() {

        BinaryAnswer nextbinaryAnswer = mPlan.getNextUnanswered();

        if (nextbinaryAnswer == null) {
            DiagnosisController controller = DiagnosisController.getInstance(this);
            controller.saveDiagnosis(mPlan);
            startResultActivity();
        } else {
            Intent intent = BinaryQuestionActivity.makeIntent(this, nextbinaryAnswer);
            startActivityForResult(intent, BINARY_QUESTION);
        }
    }

    public void showSnackBar(View view, String text){
        Snackbar.make(view, text, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Subscribe
    public void onEvent(GetDiagnosisPlanEvent planEvent) {
        if (planEvent.isSuccess()) {
            mPlan = planEvent.getDiagnosisPlan();

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setEnabled(true);
        }
    }

    @Subscribe
    public void onEvent(SaveDiagnosisEvent saveEvent) {
        if (saveEvent.isSuccess() && mPlan == null) {
            getDiagnosisPlan();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (! EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        getDiagnosisPlan();
    }


}
