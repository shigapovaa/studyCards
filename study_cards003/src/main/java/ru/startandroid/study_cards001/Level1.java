package ru.startandroid.study_cards001;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Level1 extends AppCompatActivity implements View.OnClickListener {


    int qt = 3; //кол-во карточек (кнопок / строк)
    public static String [] question = new String[]{"lol","kek", "blead"}; //вводим массив  из  n строк
    public static String [] avswer = new String[]{"lool","keek", "bleead"};
    public static int number;
    LinearLayout llMain;
    Button [] btnNew = new Button[qt];//масив кнопок

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_1);
        llMain = (LinearLayout) findViewById(R.id.llMain);
        for (int i = 0; i < btnNew.length; i++) {
            btnNew[i] = new Button(this);
            btnNew[i].setText(question[i]);
            btnNew[i].setId(R.id.card);
            llMain.addView(btnNew[i]);
            btnNew[i].setOnClickListener(this);
        }
    }



    @Override
    public void onClick(View v) {
        int i = 0;
        while (i < qt){
           if (v == btnNew[i]){
               number = i;
               break;
           }
           else i++;
        }
        switch (v.getId()) {
            case R.id.card:
                Intent intent = new Intent(this, CheckQuesten.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}

