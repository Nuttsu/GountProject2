package com.example.maii.gountproject2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import DATA.FoodDATA;
import DATABASE.Table;


public class AddFoodUricDiary extends Activity {

    int i;
    String foodName, foodType;
    String[] mydata = new String[0];
    ArrayList<String> arrFoodName = new ArrayList<String>();
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_uric_diary);


        FoodDATA db = new FoodDATA(this);
        db.open();

        ArrayList<String[]> myArray = db.Std_food_arrayList_all();
        int count = myArray.size();

        for (i = 0; i < count; ++i) {
            mydata = myArray.get(i);

//            if (mydata)
            foodName = mydata[Table.Std_food.i_NAME];
            foodType = mydata[Table.Std_food.i_TYPE];

//M จานหลัก, D เครื่องดื่ม, V ผัก, B เนื้อสัตว์
            if (foodType.equals("M")) {
                arrFoodName.add(foodName);
            }

        }


        list = (ListView) findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(AddFoodUricDiary.this, android.R.layout.simple_list_item_multiple_choice, arrFoodName));
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        Log.i(null, String.valueOf(arrFoodName) + "\n");

        Button btnShowSelectItem = (Button) findViewById(R.id.button);
        btnShowSelectItem.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Selected items:";

                for (int i = 0; i < list.getCount(); i++) {
                    if (list.isItemChecked(i)) {
                        msg += "\n" + list.getItemAtPosition(i);
                    }
                }
                Toast.makeText(AddFoodUricDiary.this, msg, Toast.LENGTH_LONG).show();
            }
        });


    }

//
//        @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
////        super.onListItemClick(l, v, position, id);
//        String msg;
//        Log.i("VIEW", v.toString());
//        CheckedTextView check = (CheckedTextView) v;
//
//        if (check.isChecked()) {
//            msg = "You have selected " + check.getText();
//        } else {
//            msg = "You have deselected " + check.getText();
//        }
//        msg += " at position " + String.valueOf(position);
//
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//    }
}
