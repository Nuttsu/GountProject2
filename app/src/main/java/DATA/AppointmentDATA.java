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
public class AppointmentDATA {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private final Context context;

    public AppointmentDATA (Context c) {
        context = c;
    }

    public AppointmentDATA open() {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }


    public void insert_appointment (String reportdate, String date, String address) {
        ContentValues cv = new ContentValues();
        cv.put(Table.Appointment.APPOINTMENT_REPORTDATE, reportdate);
        cv.put(Table.Appointment.APPOINTMENT_DATE, date);
        cv.put(Table.Appointment.APPOINTMENT_PLACE, address);

        db.insert(Table.Appointment.APPOINTMENT_TABLE, null, cv);
    }

    public void update_(String reportdate, String date, String address){
        ContentValues cv = new ContentValues();
        cv.put(Table.Appointment.APPOINTMENT_REPORTDATE, reportdate);
        cv.put(Table.Appointment.APPOINTMENT_DATE, date);
        cv.put(Table.Appointment.APPOINTMENT_PLACE, address);

        db.update(Table.Appointment.APPOINTMENT_TABLE, cv, Table.Appointment.APPOINTMENT_REPORTDATE + "=?", new String[]{reportdate});
    }

    public boolean delete_appointment (String reportdate){
        db.delete(Table.Appointment.APPOINTMENT_TABLE, Table.Appointment.APPOINTMENT_REPORTDATE + "=?",new String[]{reportdate});
        return false;
    }

    public ArrayList<String[]> appointment_arrayList_select_all (){
        Cursor c = db.query(Table.Appointment.APPOINTMENT_TABLE, Table.Appointment.COLMN_SYMPTOM, null,null, null, null, null, null);
        String dataTmp[] = null;
        ArrayList<String[]> data = null;
        if(!c.isAfterLast()){
            data = new ArrayList<String[]>();
            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                dataTmp = new String[3];
                dataTmp[Table.Appointment.i_REPORTDATE] = c.getString(Table.Appointment.i_REPORTDATE);
                dataTmp[Table.Appointment.i_DATE] = c.getString(Table.Appointment.i_DATE);
                dataTmp[Table.Appointment.i_PLACE] = c.getString(Table.Appointment.i_PLACE);
                data.add(dataTmp);
            }
        }
        return data;
    }
}
