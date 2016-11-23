package ru.startandroid.study_cards001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ru.startandroid.study_cards001.database.DbAdapter;


public class CreatorCardQuesten extends AppCompatActivity implements View.OnClickListener {

    Button next;
    EditText questen;
    String s;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatorcardquesten);
        next = (Button) findViewById(R.id.transferToAnswer);
        next.setOnClickListener(this);
        questen = (EditText) findViewById(R.id.questen);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.transferToAnswer:
                s = questen.getText() + "";  //cчитывание введённого
                Intent intent = new Intent(this, CreatorCardAnswer.class);

                intent.putExtra(DbAdapter.KEY_QUESTION, s);

                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }

}
