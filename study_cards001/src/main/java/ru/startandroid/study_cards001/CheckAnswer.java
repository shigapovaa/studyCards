package ru.startandroid.study_cards001;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.startandroid.study_cards001.database.DbAdapter;


public class CheckAnswer extends AppCompatActivity implements View.OnClickListener {
    private DbAdapter dbHelper;

    Button trueB, falseB;
    TextView ansver;
    String s;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_answer);
        switch (MainActivity.n) {
            case 1:
                s = Level1.avswer[Level1.number];
                number = Level1.number;
                break;
            case 2:
                s = Level2.avswer[Level2.number];
                number = Level2.number;
                break;
            case 3:
                s = Level3.avswer[Level3.number];
                number = Level3.number;
                break;
            case 4:
                s = Level4.avswer[Level4.number];
                number = Level4.number;
                break;
            case 5:
                s = Level5.avswer[Level5.number];
                number = Level5.number;
                break;
            case 6:
                s = Level6.avswer[Level6.number];
                number = Level6.number;
                break;
            case 7:
                s = Level7.avswer[Level7.number];
                number = Level7.number;
                break;
        }
        trueB = (Button) findViewById(R.id.backtolevel);
        trueB.setOnClickListener(this);
        falseB = (Button) findViewById(R.id.falseB);
        falseB.setOnClickListener(this);
        ansver = (TextView) findViewById(R.id.ansver);
        ansver.setText(s);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onClick(View v) {
        dbHelper = new DbAdapter(this);
        dbHelper.open();
        Cursor cursor = dbHelper.fetchAllLevelCards(MainActivity.n);
        startManagingCursor(cursor);
        cursor.moveToPosition(number);

        switch (v.getId()) {
            case R.id.backtolevel:

                if (MainActivity.n < 7) {
                    dbHelper.updateLevel(cursor.getInt(cursor.getColumnIndex(DbAdapter.KEY_ROWID)), MainActivity.n + 1);
                }

                startActivity(MainActivity.intent[MainActivity.n]);
                finish();
                break;
            case R.id.falseB:

                dbHelper.updateLevel(cursor.getInt(cursor.getColumnIndex(DbAdapter.KEY_ROWID)), 1);

                startActivity(MainActivity.intent[MainActivity.n]);
                finish();
                break;
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