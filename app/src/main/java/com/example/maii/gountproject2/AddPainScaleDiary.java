package com.example.maii.gountproject2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class AddPainScaleDiary extends ActionBarActivity {

    static final String[] pains = new String[]{"kkk", "rrr", "UUU", "LLL"};
    static final String[] levels = new String[]{"1", "2", "3", "4", "5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain_scale_diary);

        final Spinner spnPainPosition = (Spinner) findViewById(R.id.spnPainPosition);
        final Spinner spnPainLevel = (Spinner) findViewById(R.id.spnPainLevel);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pains);
        spnPainPosition.setAdapter(adapter);


        spnPainPosition.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String msg = "Selected : " + ((TextView) v).getText();
                msg += " at position " + String.valueOf(position);

                Log.i("Log Add pain ", msg);
            }

            public void onNothingSelected(AdapterView<?> av) {
                return;
            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, levels);
        spnPainLevel.setAdapter(adapter2);

        spnPainLevel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String msg = "Selected : " + ((TextView) v).getText();
                msg += " at position " + String.valueOf(position);

                Log.i("Log Add pain level ", msg);
            }

            public void onNothingSelected(AdapterView<?> av) {
                return;
            }
        });

        Button btnSavePainScaleToDB = (Button) findViewById(R.id.btnSavePainScaleToDB);
        btnSavePainScaleToDB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String msg = "Select item: ";
                msg += (String) spnPainPosition.getSelectedItem();
                msg += (String) spnPainLevel.getSelectedItem();

                Log.i("Log PAIN POSITION : ", msg);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pain_scale_diary, menu);
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
}
