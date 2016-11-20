package ru.startandroid.study_cards001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class CheckQuesten extends AppCompatActivity implements View.OnClickListener {

    Button toanswer;
    TextView questen;
    String s = Level1.question[Level1.number];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_questen);
        toanswer = (Button) findViewById(R.id.toanswer);
        toanswer.setOnClickListener(this);
        questen = (TextView) findViewById(R.id.textquesten);
        questen.setText(s);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toanswer:
                Intent intent = new Intent(this, CheckAnswer.class);
                startActivity(intent);
                finish();
                break;
        }
    }


}
