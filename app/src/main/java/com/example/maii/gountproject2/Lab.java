package com.example.maii.gountproject2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import DATA.LabDATA;
import DATABASE.Table;


public class Lab extends Activity {

    int i;
    String id, name, sex, minValue, maxValue, lessMin, overMax;

    EditText edtLab1, edtLab2;

    String[] mydata = new String[0];
    ArrayList<String> arrName = new ArrayList<String>();
    ArrayList<String> arrSex = new ArrayList<String>();
    ArrayList<String> arrminValue = new ArrayList<String>();
    ArrayList<String> arrMaxValue = new ArrayList<String>();
    ArrayList<String> arrLessmin = new ArrayList<String>();
    ArrayList<String> arrOvermax = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);

        edtLab1 = (EditText) findViewById(R.id.edtLab1);
        edtLab2 = (EditText) findViewById(R.id.edtLab2);
        Button btnCalculate = (Button) findViewById(R.id.btnCalulate);

        LabDATA db = new LabDATA(this);
        db.open();

        ArrayList<String[]> myArray = db.std_lab_arrayList_all();
        int count = myArray.size();

        for (i = 0; i < count; ++i) {
            mydata = myArray.get(i);

            id = mydata[Table.Std_lab.i_ID];
            name = mydata[Table.Std_lab.i_NAME];
            sex = mydata[Table.Std_lab.i_SEX];
            minValue = mydata[Table.Std_lab.i_MINVALUE];
            maxValue = mydata[Table.Std_lab.i_MAXVALUE];
            lessMin = mydata[Table.Std_lab.i_LESSMIN];
            overMax = mydata[Table.Std_lab.i_OVERMAX];

            arrName.add(name);
            arrSex.add(sex);
            arrminValue.add(minValue);
            arrMaxValue.add(maxValue);
            arrLessmin.add(lessMin);
            arrOvermax.add(overMax);





            btnCalculate.setOnClickListener(new Button.OnClickListener() {
                String edtLab1String = edtLab1.getText().toString();
                String edtLab2String = edtLab2.getText().toString();
                float floatEdtMinValue = (Float.valueOf(edtLab1String)).floatValue();
                float floatEdtMaxValue = (Float.valueOf(edtLab2String)).floatValue();

                float floatMinValue = (Float.valueOf(minValue)).floatValue();
                float floatMaxValue = (Float.valueOf(maxValue)).floatValue();
                @Override
                public void onClick(View v) {
                    if (!(edtLab1.equals(""))) {
                        if ((floatEdtMinValue <= floatMinValue)) {
                            Log.i("Log LAB COMPARE: ", floatEdtMinValue + "Less Than" + floatMinValue);
                        }
                    } else
                        Log.i("Log LAB COMPARE: ", floatEdtMinValue + "More Than" + floatMinValue);

                }
            });

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab, menu);
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
