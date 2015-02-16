package DATA;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import DATABASE.DatabaseHelper;
import DATABASE.Table;

/**
 * Created by Maii on 2/2/15.
 */
public class PainDiaryDATA {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private final Context context;

    public PainDiaryDATA (Context c) {
        context = c;
    }

    public PainDiaryDATA open() {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public void painDiary_insert(String position, String leve) {
        ContentValues cv = new ContentValues();
        cv.put(Table.Pain_diary.PAIN_POSITION, position);
        cv.put(Table.Pain_diary.PAIN_LEVEL, leve);

        db.insert(Table.Pain_diary.PAIN_DIARY_TABLE, null, cv);
    }

    public void painDiary_update(String id, String position, String leve){
        ContentValues cv = new ContentValues();
        cv.put(Table.Pain_diary.PAIN_ID, id);
        cv.put(Table.Pain_diary.PAIN_POSITION, position);
        cv.put(Table.Pain_diary.PAIN_LEVEL, leve);

        db.update(Table.Pain_diary.PAIN_DIARY_TABLE, cv, Table.Pain_diary.PAIN_ID + "=?", new String[]{id});
    }

}
