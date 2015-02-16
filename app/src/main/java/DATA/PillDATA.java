package DATA;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import DATABASE.DatabaseHelper;
import DATABASE.Table;

/**
 * Created by Maii on 1/16/15.
 */
public class PillDATA {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private final Context context;
    private Cursor mCursor;

    public PillDATA (Context c) {
        context = c;
    }

    public PillDATA open() {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public String pill_select_all_string(){
        Cursor c = db.query(Table.Std_pill.STD_PILL_TABLE, Table.Std_pill.COLMN_STD_PILL, null, null, null, null, null, null);
        String data = new String();
        if(!c.isAfterLast()){
            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                data = data + c.getString(Table.Std_pill.i_NAME);
                data = data + "     " + c.getString(Table.Std_pill.i_REGISTRATION) + "\n";
            }
        }
        return data;
    }

    public ArrayList<String[]> std_pill_arrayList_select_all(){
        Cursor c = db.query(Table.Std_pill.STD_PILL_TABLE, Table.Std_pill.COLMN_STD_PILL, null, null, null, null, null, null);
        String dataTmp[] = null;
        ArrayList<String[]> data=null;
        if(!c.isAfterLast()){
            data = new ArrayList<String[]>();
            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                dataTmp = new String[8];
                dataTmp[Table.Std_pill.i_ID] = c.getString(Table.Std_pill.i_ID);
                dataTmp[Table.Std_pill.i_NAME] = c.getString(Table.Std_pill.i_NAME);
                dataTmp[Table.Std_pill.i_PRICE] = c.getString(Table.Std_pill.i_PRICE);
                dataTmp[Table.Std_pill.i_USEFOR] = c.getString(Table.Std_pill.i_USEFOR);
                dataTmp[Table.Std_pill.i_HOWTIUSE] = c.getString(Table.Std_pill.i_HOWTIUSE);
                dataTmp[Table.Std_pill.i_SERIOUSADVERSE] = c.getString(Table.Std_pill.i_SERIOUSADVERSE);
                dataTmp[Table.Std_pill.i_COMMONADVERSE] = c.getString(Table.Std_pill.i_COMMONADVERSE);
                dataTmp[Table.Std_pill.i_REGISTRATION] = c.getString(Table.Std_pill.i_REGISTRATION);
                data.add(dataTmp);
            }
        }
        return data;
    }


}
