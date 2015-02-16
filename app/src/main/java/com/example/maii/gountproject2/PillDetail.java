package com.example.maii.gountproject2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import DATA.PillDATA;


public class PillDetail extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_detail);

        PillDATA db = new PillDATA(this);
        db.open();

        TextView tvTitlePillName = (TextView) findViewById(R.id.tvTitlePillName);
        TextView tvTitlePillPrice = (TextView) findViewById(R.id.tvTitlePillPrice);
        TextView tvPillName = (TextView) findViewById(R.id.tvPillName);
        TextView tvPillPrice = (TextView) findViewById(R.id.tvPillPrice);
        TextView tvPillUsefor = (TextView) findViewById(R.id.tvUsefor);
        TextView tvPillHowtouse = (TextView) findViewById(R.id.tvHowtouse);
        TextView tvPillSeriousAdverse = (TextView) findViewById(R.id.tvSeriousAdverse);
        TextView tvPillCommonAdverse = (TextView) findViewById(R.id.tvCommonAdverse);
        TextView tvPillRegister = (TextView) findViewById(R.id.tvRegister);

//        ArrayList<String[]> myArray = db.pill_arrayList_select_all();


        Bundle recdData = getIntent().getExtras();
        String pName = recdData.getString("pName");
        String pPrice = recdData.getString("pPrice");
        String pUsefor = recdData.getString("pUsefor");
        String pHowtouse = recdData.getString("pHowtouse");
        String pSeriousAdverse = recdData.getString("pSeriousAdverse");
        String pCommonAdverse = recdData.getString("pCommonAdverse");
        String pRegis = recdData.getString("pRegis");

//        String name = getIntent().getStringExtra("inname");
//        String price = getIntent().getStringExtra("inprice");

        tvPillName.setText(pName);
        tvPillPrice.setText(pPrice);
        tvPillUsefor.setText(pUsefor);
        tvPillHowtouse.setText(pHowtouse);
        tvPillSeriousAdverse.setText(pSeriousAdverse);
        tvPillCommonAdverse.setText(pCommonAdverse);
        tvPillRegister.setText(pRegis);

        Typeface ThaiFont = Typeface.createFromAsset(getAssets(), "fonts/thaisanslite_r1.ttf");
        tvTitlePillName.setTypeface(ThaiFont);
        tvTitlePillPrice.setTypeface(ThaiFont);
        tvPillName.setTypeface(ThaiFont);
        tvPillPrice.setTypeface(ThaiFont);
        tvPillUsefor.setTypeface(ThaiFont);
        tvPillHowtouse.setTypeface(ThaiFont);
        tvPillSeriousAdverse.setTypeface(ThaiFont);
        tvPillCommonAdverse.setTypeface(ThaiFont);
        tvPillRegister.setTypeface(ThaiFont);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pill_detail, menu);
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
