package DATA;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import DATABASE.DatabaseHelper;

/**
 * Created by Maii on 1/16/15.
 */
public class SymptomDATA {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private final Context context;

    public SymptomDATA (Context c) {
        context = c;
    }

    public SymptomDATA open() {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

//    public String symptom_select_all_string(){
//        Cursor c = db.query(Table.Std_symptom.STD_SYMPTOM_TABLE, Table.Std_symptom.COLMN_STD_SYMPTOM, null,null, null, null, null, null);
//        String data = new String();
//        if(!c.isAfterLast()){
//            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
//                data = data + c.getString(Table.Std_symptom.i_NAME) + "\n";
//            }
//        }
//        return data;
//    }
}
