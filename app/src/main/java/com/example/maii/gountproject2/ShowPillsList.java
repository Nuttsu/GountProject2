package com.example.maii.gountproject2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import DATA.PillDATA;
import DATABASE.Table;


public class ShowPillsList extends ListActivity {

    String id, name, price, usefor, howtouse, seriousAdverse, commonAdverse, registration;
    int i;

    String[] mydata = new String[0];
    ArrayList<String> arrName = new ArrayList<String>();
    ArrayList<String> arrPrice = new ArrayList<String>();
    ArrayList<String> arrUsefor = new ArrayList<String>();
    ArrayList<String> arrHowtouse = new ArrayList<String>();
    ArrayList<String> arrSeriousAdverse = new ArrayList<String>();
    ArrayList<String> arrCommonAdverse = new ArrayList<String>();
    ArrayList<String> arrRegis = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_show_pills_list);

        PillDATA db = new PillDATA(this);
        db.open();

        ArrayList<String[]> myArray = db.std_pill_arrayList_select_all();
        int count = myArray.size();

        for (i = 0; i < count; ++i) {
            mydata = myArray.get(i);

            id = mydata[Table.Std_pill.i_ID];
            name = mydata[Table.Std_pill.i_NAME];
            price = mydata[Table.Std_pill.i_PRICE];
            usefor = mydata[Table.Std_pill.i_USEFOR];
            howtouse = mydata[Table.Std_pill.i_HOWTIUSE];
            seriousAdverse = mydata[Table.Std_pill.i_SERIOUSADVERSE];
            commonAdverse = mydata[Table.Std_pill.i_COMMONADVERSE];
            registration = mydata[Table.Std_pill.i_REGISTRATION];

            arrName.add(name);
            arrPrice.add(price);
            arrUsefor.add(usefor);
            arrHowtouse.add(howtouse);
            arrSeriousAdverse.add(seriousAdverse);
            arrCommonAdverse.add(commonAdverse);
            arrRegis.add(registration);

        }

        setListAdapter(new ArrayAdapter<String>(ShowPillsList.this, android.R.layout.simple_list_item_1, arrName));

//        ListAdapter adapter = new SimpleCursorAdapter(
//                this,
//                android.R.layout.simple_list_item_2,
//                mCursor,     // Pass in the cursor to bind to.
//                new String[] {String.valueOf(arrName), String.valueOf(arrRegis)}, // Array of cursor columns to bind to.
//                new int[] {android.R.id.text1, android.R.id.text2});  // Parallel array of which template objects to bind to those columns.
//
//        // Bind to our new adapter.
//        setListAdapter(adapter);

    }


    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
//        super.onListItemClick(l, v, position, id);
        String pName = arrName.get(position);
        String pPrice = arrPrice.get(position);
        String pUsefor = arrUsefor.get(position);
        String pHowtouse = arrHowtouse.get(position);
        String pSeriousAdverse = arrSeriousAdverse.get(position);
        String pCommonAdverse = arrCommonAdverse.get(position);
        String pRegis = arrRegis.get(position);

//        Class ourClass = null;
        Intent pillDetailIntent = new Intent(this, PillDetail.class);
        pillDetailIntent.putExtra("pName", pName);
        pillDetailIntent.putExtra("pPrice", pPrice);
        pillDetailIntent.putExtra("pUsefor", pUsefor);
        pillDetailIntent.putExtra("pHowtouse", pHowtouse);
        pillDetailIntent.putExtra("pSeriousAdverse", pSeriousAdverse);
        pillDetailIntent.putExtra("pCommonAdverse", pCommonAdverse);
        pillDetailIntent.putExtra("pRegis", pRegis);
        startActivity(pillDetailIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_pills_list, menu);
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
