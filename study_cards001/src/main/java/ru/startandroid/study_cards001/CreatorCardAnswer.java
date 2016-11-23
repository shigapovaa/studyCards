package ru.startandroid.study_cards001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ru.startandroid.study_cards001.database.DbAdapter;


public class CreatorCardAnswer extends AppCompatActivity implements View.OnClickListener {
    private DbAdapter dbHelper;

    private final int level = 1;

    EditText answer;
    Button save;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatorcardanswer);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(this);
        answer = (EditText) findViewById(R.id.answer);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                s = answer.getText() + "";

                dbHelper = new DbAdapter(this);
                dbHelper.open();
                String question = getIntent().getStringExtra(DbAdapter.KEY_QUESTION);
                dbHelper.createTodo(level, question, s);

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
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
