package ru.startandroid.study_cards001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class CreatorCardQuesten extends AppCompatActivity implements View.OnClickListener {

    Button next;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatorcardquesten);
        next = (Button) findViewById(R.id.transferToAnswer);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.transferToAnswer:
                Intent intent = new Intent(this, CreatorCardAnswer.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
