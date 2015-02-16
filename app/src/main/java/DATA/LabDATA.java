package DATA;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import DATABASE.DatabaseHelper;
import DATABASE.Table;

/**
 * Created by Maii on 1/16/15.
 */
public class LabDATA {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private final Context context;

    public LabDATA (Context c) {
        context = c;
    }

    public LabDATA open() {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public void insert_lab (String reportdate, Integer lab_id, Float value) {
        ContentValues cv = new ContentValues();
        cv.put(Table.Lab_diary.LAB_REPORTDATE, reportdate);
        cv.put(Table.Lab_diary.LAB_DIARY_ID, lab_id);
        cv.put(Table.Lab_diary.LAB_DIARY_VALUE, value);

        db.insert(Table.Lab_diary.LAB_DIARY_TABLE, null, cv);
    }

    public void lab_update (String reportdate, Integer lab_id, Float value) {
        ContentValues cv = new ContentValues();
        cv.put(Table.Lab_diary.LAB_REPORTDATE, reportdate);
        cv.put(Table.Lab_diary.LAB_DIARY_ID, lab_id);
        cv.put(Table.Lab_diary.LAB_DIARY_VALUE, value);

        db.update(Table.Lab_diary.LAB_DIARY_TABLE, cv, Table.Lab_diary.LAB_REPORTDATE + "=?", new String[]{reportdate});
    }

    public boolean lab_delete (String reportdate){
        db.delete(Table.Lab_diary.LAB_DIARY_TABLE, Table.Lab_diary.LAB_REPORTDATE + "=?",new String[]{reportdate});
        return false;
    }

    public ArrayList<String[]> lab_arrayList_all (){
        Cursor c = db.query(Table.Lab_diary.LAB_DIARY_TABLE, Table.Lab_diary.COLMN_STD_LAB, null,null, null, null, null, null);
        String dataTmp[] = null;
        ArrayList<String[]> data = null;
        if(!c.isAfterLast()){
            data = new ArrayList<String[]>();
            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                dataTmp = new String[3];
                dataTmp[Table.Lab_diary.i_REPORTDATE] = c.getString(Table.Lab_diary.i_REPORTDATE);
                dataTmp[Table.Lab_diary.i_ID] = c.getString(Table.Lab_diary.i_ID);
                dataTmp[Table.Lab_diary.i_VALUE] = c.getString(Table.Lab_diary.i_VALUE);
                data.add(dataTmp);
            }
        }
        return data;
    }


    public ArrayList<String[]> std_lab_arrayList_all (){
        Cursor c = db.query(Table.Std_lab.STD_LAB_TABLE, Table.Std_lab.COLMN_STD_LAB, null,null, null, null, null, null);
        String dataTmp[] = null;
        ArrayList<String[]> data = null;
        if(!c.isAfterLast()){
            data = new ArrayList<String[]>();
            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                dataTmp = new String[7];
                dataTmp[Table.Std_lab.i_ID] = c.getString(Table.Std_lab.i_ID);
                dataTmp[Table.Std_lab.i_NAME] = c.getString(Table.Std_lab.i_NAME);
                dataTmp[Table.Std_lab.i_SEX] = c.getString(Table.Std_lab.i_SEX);
                dataTmp[Table.Std_lab.i_MINVALUE] = c.getString(Table.Std_lab.i_MINVALUE);
                dataTmp[Table.Std_lab.i_MAXVALUE] = c.getString(Table.Std_lab.i_MAXVALUE);
                dataTmp[Table.Std_lab.i_LESSMIN] = c.getString(Table.Std_lab.i_LESSMIN);
                dataTmp[Table.Std_lab.i_OVERMAX] = c.getString(Table.Std_lab.i_OVERMAX);
                data.add(dataTmp);
            }
        }
        return data;
    }

}
