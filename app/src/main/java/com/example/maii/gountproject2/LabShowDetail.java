package com.example.maii.gountproject2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import DATA.LabDATA;
import DATABASE.Table;


public class LabShowDetail extends ActionBarActivity {

    int i, count;
    String id, name, sex, minValue, maxValue, lessMin, overMax;
    float floatMinValue_a1, floatMinValue_m2, floatMinValue_f3, floatMinValue_a4, floatMinValue_a5, floatMinValue_a6, floatMinValue_a7, floatMinValue_a8, floatMinValue_m9, floatMinValue_f10;
    float floatMaxValue_a1, floatMaxValue_m2, floatMaxValue_f3, floatMaxValue_a4, floatMaxValue_a5, floatMaxValue_a6, floatMaxValue_a7, floatMaxValue_a8, floatMaxValue_m9, floatMaxValue_f10;
    float edtValue1, edtValue2, edtValue3, edtValue4, edtValue5, edtValue6, edtValue7, edtValue8;
    TextView b1, b2, b3, b4, b5, b6, b7, b8;


    String bun, creatinine, cholesterol, trigliceride, hdl, ldl, sugar, uric;

    String[] mydata = new String[0];
    ArrayList<String> arrName = new ArrayList<String>();
    ArrayList<String> arrSex = new ArrayList<String>();
    ArrayList<String> arrMinValue = new ArrayList<String>();
    ArrayList<String> arrMaxValue = new ArrayList<String>();
    ArrayList<String> arrLessmin = new ArrayList<String>();
    ArrayList<String> arrOvermax = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_show_detail);

        Button btnCalculate = (Button) findViewById(R.id.btnCalulate);
        Button btnLabBackToMain = (Button) findViewById(R.id.btnLabBackToMain);

        openLabData();

        TextView b1 = (TextView) findViewById(R.id.textView);
        TextView b2 = (TextView) findViewById(R.id.textView2);
        TextView b3 = (TextView) findViewById(R.id.textView4);
        TextView b4 = (TextView) findViewById(R.id.textView5);
        TextView b5 = (TextView) findViewById(R.id.textView6);
        TextView b6 = (TextView) findViewById(R.id.textView7);
        TextView b7 = (TextView) findViewById(R.id.textView8);
        TextView b8 = (TextView) findViewById(R.id.textView9);


        Bundle recdData = getIntent().getExtras();
        bun = recdData.getString("pBun");
        creatinine = recdData.getString("pCreatinine");
        cholesterol = recdData.getString("pCholesterol");
        trigliceride = recdData.getString("pTriglyceride");
        hdl = recdData.getString("pHDL");
        ldl = recdData.getString("pLDL");
        sugar = recdData.getString("pSugar");
        uric = recdData.getString("pUric");

            convertStringToFloat();
            calculate();

        btnLabBackToMain.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


//        b1.setText(String.valueOf(bun));
//        b2.setText(String.valueOf(creatinine));
//        b3.setText(String.valueOf(cholesterol));
//        b4.setText(String.valueOf(trigliceride));
//        b5.setText(String.valueOf(hdl));
//        b6.setText(String.valueOf(ldl));
//        b7.setText(String.valueOf(sugar));
//        b8.setText(String.valueOf(uric));
    }


    public void openLabData() {
        LabDATA db = new LabDATA(this);
        db.open();

        ArrayList<String[]> myArray = db.std_lab_arrayList_all();
        count = myArray.size();

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
            arrMinValue.add(minValue);
            arrMaxValue.add(maxValue);
            arrLessmin.add(lessMin);
            arrOvermax.add(overMax);



//            openProfileData();
        }
    }

    public void convertStringToFloat() {
        for (i = 0; i < count; ++i) {
            floatMinValue_a1 = Float.valueOf(arrMinValue.get(0));
            floatMinValue_m2 = Float.valueOf(arrMinValue.get(1));
            floatMinValue_f3 = Float.valueOf(arrMinValue.get(2));
            floatMinValue_a4 = Float.valueOf(arrMinValue.get(3));
            floatMinValue_a5 = Float.valueOf(arrMinValue.get(4));
            floatMinValue_a6 = Float.valueOf(arrMinValue.get(5));
            floatMinValue_a7 = Float.valueOf(arrMinValue.get(6));
            floatMinValue_a8 = Float.valueOf(arrMinValue.get(7));
            floatMinValue_m9 = Float.valueOf(arrMinValue.get(8));
            floatMinValue_f10 = Float.valueOf(arrMinValue.get(9));

            floatMaxValue_a1 = Float.valueOf(arrMaxValue.get(0));
            floatMaxValue_m2 = Float.valueOf(arrMaxValue.get(1));
            floatMaxValue_f3 = Float.valueOf(arrMaxValue.get(2));
            floatMaxValue_a4 = Float.valueOf(arrMaxValue.get(3));
            floatMaxValue_a5 = Float.valueOf(arrMaxValue.get(4));
            floatMaxValue_a6 = Float.valueOf(arrMaxValue.get(5));
            floatMaxValue_a7 = Float.valueOf(arrMaxValue.get(6));
            floatMaxValue_a8 = Float.valueOf(arrMaxValue.get(7));
            floatMaxValue_m9 = Float.valueOf(arrMaxValue.get(8));
            floatMaxValue_f10 = Float.valueOf(arrMaxValue.get(9));
        }
    }

    public void calculate() {

        //Bun
        try {
            edtValue1 = Float.valueOf(bun);
            if (edtValue1 >= floatMinValue_a1 && edtValue1 <= floatMaxValue_a1) {
                Log.i("Log LAB COMPARE1: ", edtValue1 + "  Normal  ");
//                b1.setText(String.valueOf(edtValue1));
            } else if (edtValue1 < floatMinValue_a1 || edtValue1 > floatMaxValue_a1) {
                Log.i("Log LAB COMPARE1: ", edtValue1 + "  Less than OR Over  ");
//                b1.setText(String.valueOf(edtValue1));
            }
        } catch (NumberFormatException e) {
            edtValue1 = (float) 0.0;
            Log.i("Log catch1 : ", String.valueOf(edtValue1));

        }

//Cretinine

        try {
            edtValue2 = Float.valueOf(creatinine);
            if (edtValue2 >= floatMinValue_m2 && edtValue2 <= floatMaxValue_m2) {
//                b2.setText(String.valueOf(edtValue2));
                Log.i("Log LAB COMPARE2: ", edtValue2 + "  Normal  ");
            }
            else if (edtValue2 < floatMinValue_m2 || edtValue2 > floatMaxValue_m2) {
                Log.i("Log LAB COMPARE2: ", edtValue2 + " Less than OR Over  ");
//                b2.setText(String.valueOf(edtValue2));
            }
        } catch (NumberFormatException e) {
            edtValue2 = (float) 0.0;
            Log.i("Log catch2 : ", String.valueOf(edtValue2));
        }


//        //Cretinine Female
//        if (profileSex.toString().equals('F')) {
//            try {
//                edtValue2 = Float.valueOf(edtLab2.getText().toString());
//                if (edtValue3 >= floatMinValue_f3 && edtValue3 <= floatMaxValue_f3) {
//                    Log.i("Log LAB COMPARE2: ", edtValue3 + " Normal ");
//                } else if (edtValue3 < floatMinValue_f3 || edtValue3 > floatMaxValue_f3)
//                    Log.i("Log LAB COMPARE2: ", edtValue3 + "  Less than OR Over  ");
//            } catch (NumberFormatException e) {
//                edtValue2 = (float) 0.0;
//                Log.i("Log catch2 : ", String.valueOf(edtValue2));
//            }
//        }


        //Cholesterol
        try {
            edtValue3 = Float.valueOf(cholesterol);
            if (edtValue3 >= floatMinValue_a4 && edtValue3 <= floatMaxValue_a4) {
//                b3.setText(String.valueOf(edtValue3));
                Log.i("Log LAB COMPARE3: ", edtValue3 + "  Normal  ");
            }
            else if (edtValue3 < floatMinValue_a4 || edtValue3 > floatMaxValue_a4) {
//                b3.setText(String.valueOf(edtValue3));
                Log.i("Log LAB COMPARE3: ", edtValue3 + "  Less than OR Over  ");
            }
        } catch (NumberFormatException e) {
            edtValue3 = (float) 0.0;
            Log.i("Log catch3 : ", String.valueOf(edtValue3));
        }

        //Triglyceride
        try {
            edtValue4 = Float.valueOf(trigliceride);
            if (edtValue4 >= floatMinValue_a5 && edtValue4 <= floatMaxValue_a5) {
//                b4.setText(String.valueOf(edtValue4));
                Log.i("Log LAB COMPARE4: ", edtValue4 + "  Normal  ");
            } else if (edtValue4 < floatMinValue_a5 || edtValue4 > floatMaxValue_a5) {
//                b4.setText(String.valueOf(edtValue4));
                Log.i("Log LAB COMPARE4: ", edtValue4 + "  Less than OR Over  ");
            }
        } catch (NumberFormatException e) {
            edtValue4 = (float) 0.0;
            Log.i("Log catch4 : ", String.valueOf(edtValue4));
        }

        //HDL
        try {
            edtValue5 = Float.valueOf(hdl);
            if (edtValue5 >= floatMinValue_a6 && edtValue5 <= floatMaxValue_a6) {
//                b5.setText(String.valueOf(edtValue5));
                Log.i("Log LAB COMPARE5: ", edtValue3 + "  Normal  ");
            } else if (edtValue5 < floatMinValue_a6 || edtValue5 > floatMaxValue_a6) {
//                b6.setText(String.valueOf(edtValue6));
                Log.i("Log LAB COMPARE5: ", edtValue3 + "  Less than OR Over  ");
            }
        } catch (NumberFormatException e) {
            edtValue5 = (float) 0.0;
            Log.i("Log catch5 : ", String.valueOf(edtValue5));
        }

        //LDL
        try {
            edtValue6 = Float.valueOf(ldl);
            if (edtValue6 >= floatMinValue_a7 && edtValue6 <= floatMaxValue_a7) {
//                b6.setText(String.valueOf(edtValue6));
                Log.i("Log LAB COMPARE6: ", edtValue6 + "  Normal  ");
            } else if (edtValue6 < floatMinValue_a7 || edtValue6 > floatMaxValue_a7) {
//                b6.setText(String.valueOf(edtValue6));
                Log.i("Log LAB COMPARE6: ", edtValue6 + "  Less than OR Over  ");
            }
        } catch (NumberFormatException e) {
            edtValue6 = (float) 0.0;
            Log.i("Log catch6 : ", String.valueOf(edtValue6));
        }


        //Sugar
        try {
            edtValue7 = Float.valueOf(sugar);
            if (edtValue7 >= floatMinValue_a8 && edtValue7 <= floatMaxValue_a8) {
//                b7.setText(String.valueOf(edtValue7));
                Log.i("Log LAB COMPARE7: ", edtValue7 + "  Normal  ");
            } else if (edtValue7 < floatMinValue_a8 || edtValue7 > floatMaxValue_a8) {
//                b7.setText(String.valueOf(edtValue7));
                Log.i("Log LAB COMPARE7: ", edtValue7 + "  Less than OR Over  ");
            }
        } catch (NumberFormatException e) {
            edtValue7 = (float) 0.0;
            Log.i("Log catch7 : ", String.valueOf(edtValue7));
        }


        //Uric
        try {
            edtValue8 = Float.valueOf(uric);
            if (edtValue8 >= floatMinValue_m9 && edtValue8 <= floatMaxValue_m9) {
//                b8.setText(String.valueOf(edtValue8));
                Log.i("Log LAB COMPARE8: ", edtValue8 + "  Normal  ");
            } else if (edtValue8 < floatMinValue_m9 || edtValue8 > floatMaxValue_m9) {
                Log.i("Log LAB COMPARE8: ", edtValue8 + "  Less than OR Over  ");
//                b8.setText(String.valueOf(edtValue8));
            }
        } catch (NumberFormatException e) {
            edtValue8 = (float) 0.0;
            Log.i("Log catch8 : ", String.valueOf(edtValue8));
        }

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

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab_show_detail, menu);
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
