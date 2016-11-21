package ru.startandroid.study_cards001;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Level4 extends AppCompatActivity implements View.OnClickListener {


    public static int qt = 3; //кол-во карточек (кнопок / строк)
    public static String [] question = new String[]{"lol","kek","bleat"}; //вводим массив  из  n строк
    public static String [] avswer = new String[]{"lool","keek","bleeat"};
    public static int number;
    LinearLayout llMain,llMainDel;
    Button [] btnNew = new Button[qt];//масив кнопок/карточек
    Button [] btnDelete = new Button[qt];//кнопка для удаления

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_4);
        llMain = (LinearLayout) findViewById(R.id.llMain);
        llMainDel = (LinearLayout) findViewById(R.id.llMainDelete);
        reloot();
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
        i = 0;
        while (i < qt){
            if (v == btnDelete[i]){
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
            case R.id.deleteCard:
                shiftArrays();
                clean();
                reloot();
                break;
        }
    }

    protected static void shiftArrays() {
        for (int i = number; i < qt - 1; i++) {
            question[i] = question[i + 1];
            avswer[i] = avswer[i + 1];
        }
        qt--;
    }

    protected void clean() {
        llMain.removeAllViews();
        llMainDel.removeAllViews();
    }

    protected void reloot(){
        for (int i = 0; i < qt; i++) { //qt заменить на btnNew.length
            btnNew[i] = new Button(this);
            btnNew[i].setText(question[i]);
            btnNew[i].setId(R.id.card);
            llMain.addView(btnNew[i]);
            btnNew[i].setOnClickListener(this);
            btnDelete[i] = new Button(this);
            btnDelete[i].setId(R.id.deleteCard);
            llMainDel.addView(btnDelete[i]);
            btnDelete[i].setOnClickListener(this);
        }
    }
}