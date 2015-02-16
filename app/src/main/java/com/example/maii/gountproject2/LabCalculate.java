package com.example.maii.gountproject2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class LabCalculate extends ActionBarActivity implements View.OnClickListener {

    int i, count;
    String id, name, sex, minValue, maxValue, lessMin, overMax;
    float floatMinValue_a1, floatMinValue_m2, floatMinValue_f3, floatMinValue_a4, floatMinValue_a5, floatMinValue_a6, floatMinValue_a7, floatMinValue_a8, floatMinValue_m9, floatMinValue_f10;
    float floatMaxValue_a1, floatMaxValue_m2, floatMaxValue_f3, floatMaxValue_a4, floatMaxValue_a5, floatMaxValue_a6, floatMaxValue_a7, floatMaxValue_a8, floatMaxValue_m9, floatMaxValue_f10;
    float edtValue1, edtValue2, edtValue3, edtValue4, edtValue5, edtValue6, edtValue7, edtValue8;
    EditText edtLab1, edtLab2, edtLab3, edtLab4, edtLab5, edtLab6, edtLab7, edtLab8;

    String[] mydata = new String[0];
    ArrayList<String> arrName = new ArrayList<String>();
    ArrayList<String> arrSex = new ArrayList<String>();
    ArrayList<String> arrMinValue = new ArrayList<String>();
    ArrayList<String> arrMaxValue = new ArrayList<String>();
    ArrayList<String> arrLessmin = new ArrayList<String>();
    ArrayList<String> arrOvermax = new ArrayList<String>();

    String profileSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_calculate);


        edtLab1 = (EditText) findViewById(R.id.edtLab1);
        edtLab2 = (EditText) findViewById(R.id.edtLab2);
        edtLab3 = (EditText) findViewById(R.id.edtLab3);
        edtLab4 = (EditText) findViewById(R.id.edtLab4);
        edtLab5 = (EditText) findViewById(R.id.edtLab5);
        edtLab6 = (EditText) findViewById(R.id.edtLab6);
        edtLab7 = (EditText) findViewById(R.id.edtLab7);
        edtLab8 = (EditText) findViewById(R.id.edtLab8);

        Button btnCalculate = (Button) findViewById(R.id.btnCalulate);
        Button btnLabBackToMain = (Button) findViewById(R.id.btnLabBackToMain);

//        LabDATA db = new LabDATA(this);
//        db.open();
//
//        ArrayList<String[]> myArray = db.std_lab_arrayList_all();
//        count = myArray.size();
//
//        for (i = 0; i < count; ++i) {
//            mydata = myArray.get(i);
//
//            id = mydata[Table.Std_lab.i_ID];
//            name = mydata[Table.Std_lab.i_NAME];
//            sex = mydata[Table.Std_lab.i_SEX];
//            minValue = mydata[Table.Std_lab.i_MINVALUE];
//            maxValue = mydata[Table.Std_lab.i_MAXVALUE];
//            lessMin = mydata[Table.Std_lab.i_LESSMIN];
//            overMax = mydata[Table.Std_lab.i_OVERMAX];
//
//            arrName.add(name);
//            arrSex.add(sex);
//            arrMinValue.add(minValue);
//            arrMaxValue.add(maxValue);
//            arrLessmin.add(lessMin);
//            arrOvermax.add(overMax);
//
////            openProfileData();
//        }

        btnCalculate.setOnClickListener(this);
//                .setOnClickListener(new Button.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
////                Intent pillDetailIntent = new Intent(LabCalculate.this, LabShowDetail.class);
//                extraDataToNextView();
////                startActivity(pillDetailIntent);
////                convertStringToFloat();
////                calculate();
//
//            }
//        });

        btnLabBackToMain.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void extraDataToNextView() {
        Intent i = new Intent(LabCalculate.this, LabShowDetail.class);
        i.putExtra("pBun", edtLab1.getText().toString());
        i.putExtra("pCreatinine", edtLab2.getText().toString());
        i.putExtra("pCholesterol", edtLab3.getText().toString());
        i.putExtra("pTriglyceride", edtLab4.getText().toString());
        i.putExtra("pHDL", edtLab5.getText().toString());
        i.putExtra("pLDL", edtLab6.getText().toString());
        i.putExtra("pSugar", edtLab7.getText().toString());
        i.putExtra("pUric", edtLab8.getText().toString());
        startActivity(i);

        Log.i("Log OooooooooooO", edtLab1.getText().toString());
    }


//    public void convertStringToFloat() {
//        for (i = 0; i < count; ++i) {
//            floatMinValue_a1 = Float.valueOf(arrMinValue.get(0));
//            floatMinValue_m2 = Float.valueOf(arrMinValue.get(1));
//            floatMinValue_f3 = Float.valueOf(arrMinValue.get(2));
//            floatMinValue_a4 = Float.valueOf(arrMinValue.get(3));
//            floatMinValue_a5 = Float.valueOf(arrMinValue.get(4));
//            floatMinValue_a6 = Float.valueOf(arrMinValue.get(5));
//            floatMinValue_a7 = Float.valueOf(arrMinValue.get(6));
//            floatMinValue_a8 = Float.valueOf(arrMinValue.get(7));
//            floatMinValue_m9 = Float.valueOf(arrMinValue.get(8));
//            floatMinValue_f10 = Float.valueOf(arrMinValue.get(9));
//
//            floatMaxValue_a1 = Float.valueOf(arrMaxValue.get(0));
//            floatMaxValue_m2 = Float.valueOf(arrMaxValue.get(1));
//            floatMaxValue_f3 = Float.valueOf(arrMaxValue.get(2));
//            floatMaxValue_a4 = Float.valueOf(arrMaxValue.get(3));
//            floatMaxValue_a5 = Float.valueOf(arrMaxValue.get(4));
//            floatMaxValue_a6 = Float.valueOf(arrMaxValue.get(5));
//            floatMaxValue_a7 = Float.valueOf(arrMaxValue.get(6));
//            floatMaxValue_a8 = Float.valueOf(arrMaxValue.get(7));
//            floatMaxValue_m9 = Float.valueOf(arrMaxValue.get(8));
//            floatMaxValue_f10 = Float.valueOf(arrMaxValue.get(9));
//        }
//    }

//    public void calculate() {
//
//        //Bun
//        try {
//            edtValue1 = Float.valueOf(edtLab1.getText().toString());
//            if (edtValue1 >= floatMinValue_a1 && edtValue1 <= floatMaxValue_a1) {
//                Log.i("Log LAB COMPARE1: ", edtValue1 + "  Normal  ");
//            } else if (edtValue1 < floatMinValue_a1 || edtValue1 > floatMaxValue_a1)
//                Log.i("Log LAB COMPARE1: ", edtValue1 + "  Less than OR Over  ");
//        } catch (NumberFormatException e) {
//            edtValue1 = (float) 0.0;
//            Log.i("Log catch1 : ", String.valueOf(edtValue1));
//
//        }
//
////Cretinine
//
//        try {
//            edtValue2 = Float.valueOf(edtLab2.getText().toString());
//            if (edtValue2 >= floatMinValue_m2 && edtValue2 <= floatMaxValue_m2)
//                Log.i("Log LAB COMPARE2: ", edtValue2 + "  Normal  ");
//            else if (edtValue2 < floatMinValue_m2 || edtValue2 > floatMaxValue_m2)
//                Log.i("Log LAB COMPARE2: ", edtValue2 + " Less than OR Over  ");
//        } catch (NumberFormatException e) {
//            edtValue2 = (float) 0.0;
//            Log.i("Log catch2 : ", String.valueOf(edtValue2));
//        }
//
//
////        //Cretinine Female
////        if (profileSex.toString().equals('F')) {
////            try {
////                edtValue2 = Float.valueOf(edtLab2.getText().toString());
////                if (edtValue3 >= floatMinValue_f3 && edtValue3 <= floatMaxValue_f3) {
////                    Log.i("Log LAB COMPARE2: ", edtValue3 + " Normal ");
////                } else if (edtValue3 < floatMinValue_f3 || edtValue3 > floatMaxValue_f3)
////                    Log.i("Log LAB COMPARE2: ", edtValue3 + "  Less than OR Over  ");
////            } catch (NumberFormatException e) {
////                edtValue2 = (float) 0.0;
////                Log.i("Log catch2 : ", String.valueOf(edtValue2));
////            }
////        }
//
//
//        //Cholesterol
//        try {
//            edtValue3 = Float.valueOf(edtLab3.getText().toString());
//            if (edtValue3 >= floatMinValue_a4 && edtValue3 <= floatMaxValue_a4)
//                Log.i("Log LAB COMPARE3: ", edtValue3 + "  Normal  ");
//            else if (edtValue3 < floatMinValue_a4 || edtValue3 > floatMaxValue_a4)
//                Log.i("Log LAB COMPARE3: ", edtValue3 + "  Less than OR Over  ");
//        } catch (NumberFormatException e) {
//            edtValue3 = (float) 0.0;
//            Log.i("Log catch3 : ", String.valueOf(edtValue3));
//        }
//
//        //Triglyceride
//        try {
//            edtValue4 = Float.valueOf(edtLab4.getText().toString());
//            if (edtValue4 >= floatMinValue_a5 && edtValue4 <= floatMaxValue_a5) {
//                Log.i("Log LAB COMPARE4: ", edtValue4 + "  Normal  ");
//            } else if (edtValue4 < floatMinValue_a5 || edtValue4 > floatMaxValue_a5)
//                Log.i("Log LAB COMPARE4: ", edtValue4 + "  Less than OR Over  ");
//        } catch (NumberFormatException e) {
//            edtValue4 = (float) 0.0;
//            Log.i("Log catch4 : ", String.valueOf(edtValue4));
//        }
//
//        //HDL
//        try {
//            edtValue5 = Float.valueOf(edtLab5.getText().toString());
//            if (edtValue5 >= floatMinValue_a6 && edtValue5 <= floatMaxValue_a6) {
//                Log.i("Log LAB COMPARE5: ", edtValue3 + "  Normal  ");
//            } else if (edtValue5 < floatMinValue_a6 || edtValue5 > floatMaxValue_a6)
//                Log.i("Log LAB COMPARE5: ", edtValue3 + "  Less than OR Over  ");
//        } catch (NumberFormatException e) {
//            edtValue5 = (float) 0.0;
//            Log.i("Log catch5 : ", String.valueOf(edtValue5));
//        }
//
//        //LDL
//        try {
//            edtValue6 = Float.valueOf(edtLab6.getText().toString());
//            if (edtValue6 >= floatMinValue_a7 && edtValue6 <= floatMaxValue_a7) {
//                Log.i("Log LAB COMPARE6: ", edtValue6 + "  Normal  ");
//            } else if (edtValue6 < floatMinValue_a7 || edtValue6 > floatMaxValue_a7)
//                Log.i("Log LAB COMPARE6: ", edtValue6 + "  Less than OR Over  ");
//        } catch (NumberFormatException e) {
//            edtValue6 = (float) 0.0;
//            Log.i("Log catch6 : ", String.valueOf(edtValue6));
//        }
//
//
//        //Sugar
//        try {
//            edtValue7 = Float.valueOf(edtLab7.getText().toString());
//            if (edtValue7 >= floatMinValue_a8 && edtValue7 <= floatMaxValue_a8) {
//                Log.i("Log LAB COMPARE7: ", edtValue7 + "  Normal  ");
//            } else if (edtValue7 < floatMinValue_a8 || edtValue7 > floatMaxValue_a8)
//                Log.i("Log LAB COMPARE7: ", edtValue7 + "  Less than OR Over  ");
//        } catch (NumberFormatException e) {
//            edtValue7 = (float) 0.0;
//            Log.i("Log catch7 : ", String.valueOf(edtValue7));
//        }
//
//
//        //Uric
//        try {
//            edtValue8 = Float.valueOf(edtLab8.getText().toString());
//            if (edtValue8 >= floatMinValue_m9 && edtValue8 <= floatMaxValue_m9) {
//                Log.i("Log LAB COMPARE8: ", edtValue8 + "  Normal  ");
//            } else if (edtValue8 < floatMinValue_m9 || edtValue8 > floatMaxValue_m9)
//                Log.i("Log LAB COMPARE8: ", edtValue8 + "  Less than OR Over  ");
//        } catch (NumberFormatException e) {
//            edtValue8 = (float) 0.0;
//            Log.i("Log catch8 : ", String.valueOf(edtValue8));
//        }

//        //Uric Female
//        if (profileSex.toString().equals('F')) {
//            try {
//                edtValue8 = Float.valueOf(edtLab8.getText().toString());
//                if (edtValue8 >= floatMinValue_f10 && edtValue8 <= floatMaxValue_f10) {
//                    Log.i("Log LAB COMPARE8: ", edtValue8 + "  Normal  ");
//                } else if (edtValue8 < floatMinValue_f10 || edtValue8 > floatMaxValue_f10)
//                    Log.i("Log LAB COMPARE8: ", edtValue8 + "  Less than OR Over  ");
//            } catch (NumberFormatException e) {
//                edtValue8 = (float) 0.0;
//                Log.i("Log catch8 : ", String.valueOf(edtValue8));
//            }
//        }
//
//
//    }

//    public void openProfileData() {
//        ProfileDATA db = new ProfileDATA(this);
//        db.open();
//
//        ArrayList<String[]> myArray = db.profile_arrayList_select_all();
//        int count = myArray.size();
//
//        for (i = 0; i < count; ++i) {
//            mydata = myArray.get(i);
//
//            profileSex = mydata[Table.Profile.i_SEX];
//
////            if (foodType.equals("M")) {
////                arrFoodName.add(foodName);
//        }
//    }
//mkbuiobj

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab_calculate, menu);
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
            case R.id.btnCalulate:
//                Intent i = new Intent("com.example.maii.gountproject2.LabShowDetail");
                extraDataToNextView();
//                startActivity(i);
                break;
        }
    }
}
