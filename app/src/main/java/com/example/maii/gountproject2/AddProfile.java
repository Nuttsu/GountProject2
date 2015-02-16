package com.example.maii.gountproject2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DATA.MedicineDATA;
import DATA.ProfileDATA;


public class AddProfile extends ActionBarActivity implements View.OnClickListener {

    EditText edtName, edtSurname, edtSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        final ProfileDATA db = new ProfileDATA(this);
        db.open();

        edtName = (EditText) findViewById(R.id.edtProfileName);
        edtSurname = (EditText) findViewById(R.id.edtProfileSurname);
        edtSex = (EditText) findViewById(R.id.edtProfileSex);

        Button btnSaveData = (Button) findViewById(R.id.btnSaveToDatabase);
        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String surname = edtSurname.getText().toString();
                String sex = edtSex.getText().toString();

                db.profile_insert(name, surname, sex);
                Toast toast = Toast.makeText(getApplicationContext(), "Save " + name + " to database!!!", Toast.LENGTH_LONG);
                toast.show();
            }
        });





        ///////////////////////////////ทดสอบ///////////////////////////

        final MedicineDATA dbMed = new MedicineDATA(this);
        dbMed.open();

        Button btnShowMedicineListView = (Button) findViewById(R.id.btnShoMedicineList);
        Button btnAddMedicine = (Button) findViewById(R.id.btnAddMedicine);
        final EditText edtMedicineName = (EditText) findViewById(R.id.edtMedicineName);

        btnAddMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String medicineName = edtMedicineName.getText().toString();

                dbMed.insert_medicine(medicineName);

                edtMedicineName.setText("");
                Toast toast = Toast.makeText(getApplicationContext(), "Save " + medicineName + " to database!!!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        btnShowMedicineListView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShoMedicineList:
                Intent i = new Intent("com.example.maii.gountproject2.MedicineList_userAdd");
                startActivity(i);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_profile, menu);
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
