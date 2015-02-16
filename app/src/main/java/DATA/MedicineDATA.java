package DATA;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import DATABASE.DatabaseHelper;
import DATABASE.Table;

/**
 * Created by Maii on 1/28/15.
 */
public class MedicineDATA {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private final Context context;

    public MedicineDATA (Context c) {
        context = c;
    }

    public MedicineDATA open() {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }


    public String medicine_all_string(){
        Cursor c = db.query(Table.Medicine.MEDICINE_TABLE, Table.Medicine.COLUMN_MEDICINE, null,null, null, null, null, null);
        String data = new String();
        if(!c.isAfterLast()){
            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                data = data + c.getString(Table.Medicine.i_NAME) + "\n";
            }
        }
        return data;
    }

    //**************************************************************************************//


    public void insert_medicine (String name) {
        ContentValues cv = new ContentValues();
        cv.put(Table.Medicine.MEDICINE_NAME, name);

        db.insert(Table.Medicine.MEDICINE_TABLE, null, cv);
    }

    public void update_medicine (String id, String name) {
        ContentValues cv = new ContentValues();
        cv.put(Table.Medicine.MEDICINE_ID, id);
        cv.put(Table.Medicine.MEDICINE_NAME, name);

        db.update(Table.Medicine.MEDICINE_TABLE, cv, Table.Medicine.MEDICINE_ID + "=?", new String[]{id});
    }

    public boolean delete_medicine (String id){
        db.delete(Table.Medicine.MEDICINE_TABLE, Table.Medicine.MEDICINE_ID + "=?",new String[]{id});
        return false;
    }

    public ArrayList<String[]> medicine_arrayList_all (){
        Cursor c = db.query(Table.Medicine.MEDICINE_TABLE, Table.Medicine.COLUMN_MEDICINE, null,null, null, null, null, null);
        String dataTmp[] = null;
        ArrayList<String[]> data = null;
        if(!c.isAfterLast()){
            data = new ArrayList<String[]>();
            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                dataTmp = new String[2];
                dataTmp[Table.Medicine.i_ID] = c.getString(Table.Medicine.i_ID);
                dataTmp[Table.Medicine.i_NAME] = c.getString(Table.Medicine.i_NAME);
                data.add(dataTmp);
            }
        }
        return data;
    }

}
