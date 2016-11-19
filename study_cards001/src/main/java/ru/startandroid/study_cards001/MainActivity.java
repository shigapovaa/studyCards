package ru.startandroid.study_cards001;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab;
    Button[]  level = new Button[7];
    public static Intent[]  intent = new Intent[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        level[0] = (Button) findViewById(R.id.level1);
        level[0].setOnClickListener(this);
        level[1] = (Button) findViewById(R.id.level2);
        level[1].setOnClickListener(this);
        level[2] = (Button) findViewById(R.id.level3);
        level[2].setOnClickListener(this);
        level[3] = (Button) findViewById(R.id.level4);
        level[3].setOnClickListener(this);
        level[4] = (Button) findViewById(R.id.level5);
        level[4].setOnClickListener(this);
        level[5] = (Button) findViewById(R.id.level6);
        level[5].setOnClickListener(this);
        level[6] = (Button) findViewById(R.id.level7);
        level[6].setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                intent[0] = new Intent(this, CreatorCardQuesten.class);
                startActivity(intent[0]);
                break;
            case R.id.level1:
                intent[1] = new Intent(this, Level1.class);
                startActivity(intent[1]);
                break;
            case R.id.level2:
                intent[2] = new Intent(this, Level2.class);
                startActivity(intent[2]);
                break;
            case R.id.level3:
                intent[3] = new Intent(this, Level3.class);
                startActivity(intent[3]);
                break;
            case R.id.level4:
                intent[4] = new Intent(this, Level4.class);
                startActivity(intent[4]);
                break;
            case R.id.level5:
                intent[5] = new Intent(this, Level5.class);
                startActivity(intent[5]);
                break;
            case R.id.level6:
                intent[6] = new Intent(this, Level6.class);
                startActivity(intent[6]);
                break;
            case R.id.level7:
                intent[7] = new Intent(this, Level7.class);
                startActivity(intent[7]);
                break;
            default:
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent inf = new Intent(this, Info.class);
            startActivity(inf);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

