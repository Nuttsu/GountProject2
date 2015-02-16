package com.example.maii.gountproject2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDisplayFoodListView = (Button) findViewById(R.id.btnDisplayFoodUricListView);
        btnDisplayFoodListView.setOnClickListener(this);

        Button btnDisplayPillListView = (Button) findViewById(R.id.btnDisplayPillListView);
        btnDisplayPillListView.setOnClickListener(this);

        Button btnTest = (Button) findViewById(R.id.test);
        btnTest.setOnClickListener(this);

        Button btnDisplayAddProfileView = (Button) findViewById(R.id.btnDisplayAddProfileView);
        btnDisplayAddProfileView.setOnClickListener(this);

        Button btnDisplayAddFoodUricView = (Button) findViewById(R.id.btnDiaplayAddFoodUricView);
        btnDisplayAddFoodUricView.setOnClickListener(this);

        Button btnDisplayAddPainScaleView = (Button) findViewById(R.id.btnDisplayAddPainScaleView);
        btnDisplayAddPainScaleView.setOnClickListener(this);

        Button btnDisplayLabView = (Button) findViewById(R.id.btnDisplayLabView);
        btnDisplayLabView.setOnClickListener(this);

        Typeface ThaiFont = Typeface.createFromAsset(getAssets(), "fonts/thaisanslite_r1.ttf");
        btnDisplayFoodListView.setTypeface(ThaiFont);
        btnDisplayPillListView.setTypeface(ThaiFont);
        btnDisplayAddProfileView.setTypeface(ThaiFont);
        btnDisplayAddFoodUricView.setTypeface(ThaiFont);
        btnDisplayAddPainScaleView.setTypeface(ThaiFont);

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDisplayFoodUricListView:
                Intent i = new Intent("com.example.maii.gountproject2.activity_show_food_uric");
                startActivity(i);
                break;

            case R.id.btnDisplayPillListView:
                Intent j = new Intent("com.example.maii.gountproject2.ShowPillsList");
                startActivity(j);
                break;

            case R.id.btnDisplayAddProfileView:
                Intent l = new Intent("com.example.maii.gountproject2.AddProfile");
                startActivity(l);
                break;

            case R.id.btnDiaplayAddFoodUricView:
                Intent m = new Intent("com.example.maii.gountproject2.AddFoodUricDiary");
                startActivity(m);
                break;

            case R.id.btnDisplayAddPainScaleView:
                Intent n = new Intent("com.example.maii.gountproject2.AddPainScaleDiary");
                startActivity(n);
                break;

            case R.id.btnDisplayLabView:
                Intent a = new Intent("com.example.maii.gountproject2.LabCalculate");
                startActivity(a);
                break;
        }
    }
}
