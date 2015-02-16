package DATA;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import DATABASE.DatabaseHelper;
import DATABASE.Table;

/**
 * Created by Maii on 1/15/15.
 */
public class FoodDATA {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private final Context context;

    public FoodDATA (Context c) {
        context = c;
    }

    public FoodDATA open() {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }


// Show Food Uric
    public String food_all_string(){
        Cursor c = db.query(Table.Std_food.STD_FOOD_TABLE, Table.Std_food.COLUMN_STD_FOOD, null,null, null, null, null, null);
        String data = new String();
        if(!c.isAfterLast()){
            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
//                data = data + c.getString(Table.Std_food.i_ID);
                data = data + c.getString(Table.Std_food.i_URIC);
                data = data + "    " + c.getString(Table.Std_food.i_NAME) + "\n";
            }
        }
        return data;
    }



    //**************************************************************************************//
//Food Diary

    public void insert_foodDiary (String reportdate, Integer id, String meal) {
        ContentValues cv = new ContentValues();
        cv.put(Table.Food_diary.FOOD_REPORTDATE, reportdate);
        cv.put(Table.Food_diary.FOOD_DIARY_ID, id);
        cv.put(Table.Food_diary.FOOD_DIARY_MEAL, meal);

        db.insert(Table.Food_diary.FOOD_DIARY_TABLE, null, cv);
    }

    public void update_foodDiary (String reportdate, Integer id, String meal) {
        ContentValues cv = new ContentValues();
        cv.put(Table.Food_diary.FOOD_REPORTDATE, reportdate);
        cv.put(Table.Food_diary.FOOD_DIARY_ID, id);
        cv.put(Table.Food_diary.FOOD_DIARY_MEAL, meal);

        db.update(Table.Food_diary.FOOD_DIARY_TABLE, cv, Table.Food_diary.FOOD_REPORTDATE + "=?", new String[]{reportdate});
    }

    public boolean delete_foodDiary (String reportdate){
        db.delete(Table.Food_diary.FOOD_DIARY_TABLE, Table.Food_diary.FOOD_REPORTDATE + "=?",new String[]{reportdate});
        return false;
    }

    public ArrayList<String[]> Std_food_arrayList_all (){
        Cursor c = db.query(Table.Std_food.STD_FOOD_TABLE, Table.Std_food.COLUMN_STD_FOOD, null,null, null, null, null, null);
        String dataTmp[] = null;
        ArrayList<String[]> data = null;
        if(!c.isAfterLast()){
            data = new ArrayList<String[]>();
            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                dataTmp = new String[4];
                dataTmp[Table.Std_food.i_ID] = c.getString(Table.Std_food.i_ID);
                dataTmp[Table.Std_food.i_NAME] = c.getString(Table.Std_food.i_NAME);
                dataTmp[Table.Std_food.i_URIC] = c.getString(Table.Std_food.i_URIC);
                dataTmp[Table.Std_food.i_TYPE] = c.getString(Table.Std_food.i_TYPE);
                data.add(dataTmp);
            }
        }
        return data;
    }

}
