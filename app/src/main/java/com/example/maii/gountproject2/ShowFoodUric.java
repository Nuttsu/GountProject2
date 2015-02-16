package com.example.maii.gountproject2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import DATA.FoodDATA;

/**
 * Created by Maii on 1/16/15.
 */
public class ShowFoodUric extends ActionBarActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_food_uric);


        FoodDATA db = new FoodDATA(this);
        db.open();

        Button btnFoodBackToMain = (Button) findViewById(R.id.btnFoodBackToMainView);
        btnFoodBackToMain.setOnClickListener(this);
        TextView tvFoodName = (TextView) findViewById(R.id.tvFoodName);

        String data = db.food_all_string();
        tvFoodName.setText(data);



    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFoodBackToMainView:
                finish();
                break;
        }
    }

}
