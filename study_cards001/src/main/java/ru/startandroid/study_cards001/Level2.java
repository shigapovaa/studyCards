package ru.startandroid.study_cards001;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import ru.startandroid.study_cards001.database.DbAdapter;

public class Level2 extends AppCompatActivity implements View.OnClickListener {
    private DbAdapter dbHelper;
    private Cursor cursor;

    private final int level = 2;
    //кол-во карточек (кнопок / строк)
    public static int qt;
    //вводим массив  из  n строк
    public static String[] question;
    public static String[] avswer;
    public static int number;
    LinearLayout llMain, llMainDel;
    //масив кнопок/карточек
    Button[] btnNew;
    //массив кнопок для удаления
    Button[] btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_1);
        llMain = (LinearLayout) findViewById(R.id.llMain);
        llMainDel = (LinearLayout) findViewById(R.id.llMainDelete);

        getInfoDataBase();

        reloot();
    }


    @Override
    public void onClick(View v) {
        int i = 0;
        while (i < qt) {
            if (v == btnNew[i]) {
                number = i;
                break;
            } else i++;
        }
        i = 0;
        while (i < qt) {
            if (v == btnDelete[i]) {
                number = i;
                break;
            } else i++;
        }
        switch (v.getId()) {
            case R.id.card:
                Intent intent = new Intent(this, CheckQuesten.class);
                startActivity(intent);
                finish();
                break;
            case R.id.deleteCard:

                dbHelper.open();
                cursor = dbHelper.fetchAllLevelCards(level);
                cursor.moveToPosition(number);
                dbHelper.deleteCard(cursor.getInt(cursor.getColumnIndex(DbAdapter.KEY_ROWID)));
                getInfoDataBase();

                clean();
                reloot();
                break;
        }
    }

    protected void clean() {
        llMain.removeAllViews();
        llMainDel.removeAllViews();
    }

    protected void reloot() {
        for (int i = 0; i < qt; i++) {
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

    //получение информации из базы данных
    @SuppressWarnings("deprecation")
    protected void getInfoDataBase() {
        dbHelper = new DbAdapter(this);
        dbHelper.open();
        cursor = dbHelper.fetchAllLevelCards(level);
        startManagingCursor(cursor);
        qt = cursor.getCount();
        btnNew = new Button[qt];
        btnDelete = new Button[qt];
        question = new String[qt];
        avswer = new String[qt];
        for (int i = 0; i < qt; i++) {
            cursor.moveToPosition(i);
            question[i] = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_QUESTION));
            avswer[i] = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_ANSWER));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}
