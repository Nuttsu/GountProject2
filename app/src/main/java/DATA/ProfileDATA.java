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
public class ProfileDATA {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private final Context context;

    public ProfileDATA (Context c) {
        context = c;
    }

    public ProfileDATA open() {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public void profile_insert(String name, String surname, String sex) {
        ContentValues cv = new ContentValues();
        cv.put(Table.Profile.PROFILE_NAME, name);
        cv.put(Table.Profile.PROFILE_SURNAME, surname);
        cv.put(Table.Profile.PROFILE_SEX, sex);

        db.insert(Table.Profile.PROFILE_TABLE, null, cv);
    }

    public void profile_update(String id, String name, String surname, String sex){
        ContentValues cv = new ContentValues();
        cv.put(Table.Profile.PROFILE_ID, id);
        cv.put(Table.Profile.PROFILE_NAME, name);
        cv.put(Table.Profile.PROFILE_SURNAME, surname);
        cv.put(Table.Profile.PROFILE_SEX, sex);

        db.update(Table.Profile.PROFILE_TABLE, cv, Table.Profile.PROFILE_ID + "=?", new String[]{id});
    }

    public boolean profile_delete (String id){
        db.delete(Table.Profile.PROFILE_TABLE, Table.Profile.PROFILE_ID + "=?",new String[]{id});
        return false;
    }

    public ArrayList<String[]> profile_arrayList_select_all (){
        Cursor c = db.query(Table.Profile.PROFILE_TABLE, Table.Profile.COLUMN_PROFILE, null,null, null, null, null, null);
        String dataTmp[] = null;
        ArrayList<String[]> data = null;
        if(!c.isAfterLast()){
            data = new ArrayList<String[]>();
            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                dataTmp = new String[4];
                dataTmp[Table.Profile.i_ID] = c.getString(Table.Profile.i_ID);
                dataTmp[Table.Profile.i_NAME] = c.getString(Table.Profile.i_NAME);
                dataTmp[Table.Profile.i_SURNAME] = c.getString(Table.Profile.i_SURNAME);
                dataTmp[Table.Profile.i_SEX] = c.getString(Table.Profile.i_SEX);
                data.add(dataTmp);
            }
        }
        return data;
    }

}
