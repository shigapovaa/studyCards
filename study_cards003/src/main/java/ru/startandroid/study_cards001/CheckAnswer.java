package ru.startandroid.study_cards001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CheckAnswer extends AppCompatActivity implements View.OnClickListener{

    Button backtolevel;
    TextView ansver;
    String s = Level1.avswer[Level1.number];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_answer);
        switch (MainActivity.n){
            case 1:
                s = Level1.avswer[Level1.number];
                break;
            case 2:
                s = Level2.avswer[Level2.number];
                break;
            case 3:
                s = Level3.avswer[Level3.number];
                break;
            case 4:
                s = Level4.avswer[Level4.number];
                break;
            case 5:
                s = Level5.avswer[Level5.number];
                break;
            case 6:
                s = Level6.avswer[Level6.number];
                break;
            case 7:
                s = Level7.avswer[Level7.number];
                break;
        }
        backtolevel = (Button) findViewById(R.id.backtolevel);
        backtolevel.setOnClickListener(this);
        ansver = (TextView) findViewById(R.id.ansver);
        ansver.setText(s);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backtolevel:
                startActivity(MainActivity.intent[MainActivity.n]);
                finish();
                break;
        }
    }


}