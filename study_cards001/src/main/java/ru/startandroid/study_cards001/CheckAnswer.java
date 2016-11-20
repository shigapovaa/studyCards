package ru.startandroid.study_cards001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.logging.Level;


public class CheckAnswer extends AppCompatActivity implements View.OnClickListener{

    Button backtolevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_answer);
        backtolevel = (Button) findViewById(R.id.backtolevel);
        backtolevel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backtolevel:
                startActivity(MainActivity.intent[1]);
                break;
        }
    }
}
