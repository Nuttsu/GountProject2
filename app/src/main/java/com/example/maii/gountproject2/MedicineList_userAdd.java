package com.example.maii.gountproject2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import DATA.MedicineDATA;
import DATABASE.Table;


public class MedicineList_userAdd extends Activity {

    String id, medName;
    int i;

    String[] mydata = new String[0];
    ArrayList<String> arrMedName = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_list_user_add);


        ListView medListview = (ListView) findViewById(R.id.medListview);

        MedicineDATA db = new MedicineDATA(this);
        db.open();

        ArrayList<String[]> myArray = db.medicine_arrayList_all();
        int count = myArray.size();

        for (i = 0; i < count; ++i) {
            mydata = myArray.get(i);

            id = mydata[Table.Std_pill.i_ID];
            medName = mydata[Table.Std_pill.i_NAME];

            arrMedName.add(medName);
        }
        medListview.setAdapter(new ArrayAdapter<String>(MedicineList_userAdd.this, android.R.layout.simple_list_item_1, arrMedName));


        Button btnBackToAddProfileView = (Button) findViewById(R.id.btnMedListBackToAddProfile);
        btnBackToAddProfileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_medicine_list_user_add, menu);
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
