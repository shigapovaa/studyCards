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
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_questen);
        switch (MainActivity.n){
            case 1:
                s = Level1.question[Level1.number];
                break;
            case 2:
                s = Level2.question[Level2.number];
                break;
            case 3:
                s = Level3.question[Level3.number];
                break;
            case 4:
                s = Level4.question[Level4.number];
                break;
            case 5:
                s = Level5.question[Level5.number];
                break;
            case 6:
                s = Level6.question[Level6.number];
                break;
            case 7:
                s = Level7.question[Level7.number];
                break;
        }
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
