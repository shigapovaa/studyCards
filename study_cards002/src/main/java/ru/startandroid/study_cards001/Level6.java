package ru.startandroid.study_cards001;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Level6 extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llMain;
    String [] etName = new String[]{"lol","kek", "bleat"}; //вводим массив  из  n строк
    int n = 3; //кол-во карточек (кнопок / строк)
    Button [] tocard = new Button[n];//масив кнопок


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_6);
        llMain = (LinearLayout) findViewById(R.id.llMain);
        for (int i = 0; i < tocard.length; i++) {
            tocard[i] = (Button) findViewById(R.id.card);
            tocard[i].setOnClickListener(this);
        }
        for (int i = 0; i < n; i++) {
            Button btnNew = new Button(this);
            btnNew.setText(etName[i]);
            btnNew.setId(R.id.card);
            llMain.addView(btnNew);
            btnNew.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card:
                Intent intent = new Intent(this, CheckQuesten.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}

