package DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maii on 1/15/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DBASE";
    public static final int DATABASE_VERSION = 4;


//    public static final String lab1 = "insert into Std_lab VALUES (null, "Bun", "M", "10", "20", "")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Table.Profile.CREATE_PROFILE);
        db.execSQL(Table.Medicine.CREATE_MEDICINE);
        db.execSQL(Table.Std_food.CREATE_STD_FOOD);
        db.execSQL(Table.Food_diary.CREATE_FOOD_DIARY);
        db.execSQL(Table.Std_pill.CREATE_STD_PILL);
        db.execSQL(Table.Pain_diary.CREATE_PAIN_DIARY);
        db.execSQL(Table.Std_lab.CREATE_STD_LAB);
        db.execSQL(Table.Lab_diary.CREATE_LAB_DIARY);
        db.execSQL(Table.Appointment.CREATE_APPOINTMENT);
        db.execSQL(Table.Report.CREATE_REPORT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table.Profile.PROFILE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Table.Medicine.MEDICINE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Table.Pain_diary.PAIN_DIARY_TABLE );
        db.execSQL("DROP TABLE IF EXISTS " + Table.Std_pill.STD_PILL_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Table.Food_diary.FOOD_DIARY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Table.Std_food.STD_FOOD_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Table.Lab_diary.LAB_DIARY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Table.Std_lab.STD_LAB_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Table.Appointment.APPOINTMENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Table.Report.REPORT_TABLE);
        onCreate(db);
    }


}
