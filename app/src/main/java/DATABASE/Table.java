package DATABASE;

/**
 * Created by Maii on 1/15/15.
 */
public class Table {

    public static class Profile {
        public static String PROFILE_TABLE = "Profile";
        public static String PROFILE_ID = "_id";
        public static String PROFILE_NAME = "profile_name";
        public static String PROFILE_SURNAME = "profile_surname";
        public static String PROFILE_SEX = "sex";
        public static int i_ID = 0;
        public static int i_NAME = 1;
        public static int i_SURNAME = 2;
        public static int i_SEX = 3;
        public static String[] COLUMN_PROFILE = { PROFILE_ID, PROFILE_NAME, PROFILE_SURNAME, PROFILE_SEX };
        public static String CREATE_PROFILE = "CREATE TABLE " + PROFILE_TABLE + " (" +
                PROFILE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PROFILE_NAME + " TEXT NOT NULL, " +
                PROFILE_SURNAME + " TEXT, " +
                PROFILE_SEX + " TEXT NOT NULL);";
    }

    public static class Medicine {
        public static String MEDICINE_TABLE = "Medicine";
        public static String MEDICINE_ID = "id";
        public static String MEDICINE_NAME = "medicine_name";
        public static int i_ID = 0;
        public static int i_NAME = 1;
        public static String[] COLUMN_MEDICINE = { MEDICINE_ID, MEDICINE_NAME };
        public static String CREATE_MEDICINE = "CREATE TABLE " + MEDICINE_TABLE + " (" +
                MEDICINE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MEDICINE_NAME + " TEXT NOT NULL);";
    }


    public static class Report {
        public static String REPORT_TABLE = "Report";
        public static String REPORTDATE = "report_date";
        public static String REPORT_PROFILE = Profile.PROFILE_ID;

        public static int i_REPORTDATE = 0;
        public static String[] COLUMN_REPORT = {REPORTDATE};
        public static String CREATE_REPORT = "CREATE TABLE " + REPORT_TABLE + " (" +
                REPORTDATE + " DATE NOT NULL);";
    }


    public static class Std_food {
        public static String STD_FOOD_TABLE = "Std_food";
        public static String FOOD_ID = "food_id";
        public static String FOOD_NAME = "food_name";
        public static String FOOD_URIC = ("food_uric");
        public static String FOOD_TYPE = "food_type";
        public static int i_ID = 0;
        public static int i_NAME = 1;
        public static int i_URIC = 2;
        public static int i_TYPE = 3;
        public static String[] COLUMN_STD_FOOD = {FOOD_ID, FOOD_NAME, FOOD_URIC, FOOD_TYPE};
        public static String CREATE_STD_FOOD = "CREATE TABLE " + STD_FOOD_TABLE + " (" +
                FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FOOD_NAME + " TEXT NOT NULL, " +
                FOOD_URIC + " REAL NOT NULL, " +
                FOOD_TYPE + " TEXT NOT NULL);";
    }

    public static class Food_diary {
        public static String FOOD_DIARY_TABLE = "Food_diary";
        public static String FOOD_REPORTDATE = Report.REPORTDATE;
        public static String FOOD_DIARY_ID = Std_food.FOOD_ID;
        public static String FOOD_DIARY_MEAL = "meal";
        public static int i_REPORTDATE = 0;
        public static int i_ID = 1;
        public static int i_MEAL = 2;
        public static String[] COLMN_FOOD_DIARY = {FOOD_REPORTDATE, FOOD_DIARY_ID, FOOD_DIARY_MEAL};
        public static String CREATE_FOOD_DIARY = "CREATE TABLE " + FOOD_DIARY_TABLE + " (" +
                FOOD_REPORTDATE + " DATE NOT NULL, " +
                FOOD_DIARY_ID + " INTEGER, " +
                FOOD_DIARY_MEAL + " TEXT NOT NULL);";
    }

    public static class Std_pill {
        public static String STD_PILL_TABLE = "Std_pill";
        public static String PILL_ID = "pill_id";
        public static String PILL_NAME = "pill_name";
        public static String PILL_PRICE = "pill_price";
        public static String PILL_USEFOR = "pill_usefor";
        public static String PILL_HOWTOUSE = "pill_howtouse";
        public static String PILL_SERIOUSADVERSE = "pill_seriousAdverse";
        public static String PILL_COMMONADVERSE = "pill_commonAdverse";
        public static String PILL_REGISTRATION = "pill_registration";
        public static int i_ID = 0;
        public static int i_NAME = 1;
        public static int i_PRICE = 2;
        public static int i_USEFOR = 3;
        public static int i_HOWTIUSE = 4;
        public static int i_SERIOUSADVERSE = 5;
        public static int i_COMMONADVERSE = 6;
        public static int i_REGISTRATION = 7;
        public static String[] COLMN_STD_PILL = {PILL_ID, PILL_NAME, PILL_PRICE, PILL_USEFOR, PILL_HOWTOUSE, PILL_SERIOUSADVERSE, PILL_COMMONADVERSE, PILL_REGISTRATION,};
        public static String CREATE_STD_PILL = "CREATE TABLE " + STD_PILL_TABLE + " (" +
                PILL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PILL_NAME + " TEXT NOT NULL, " +
                PILL_PRICE + " REAL NOT NULL, " +
                PILL_USEFOR + " TEXT NOT NULL, " +
                PILL_HOWTOUSE + " TEXT NOT NULL, " +
                PILL_SERIOUSADVERSE + " TEXT NOT NULL, " +
                PILL_COMMONADVERSE + " TEXT NOT NULL, " +
                PILL_REGISTRATION + " TEXT NOT NULL);";
    }

    public static class Pain_diary {
        public static String PAIN_DIARY_TABLE = "Pain_diary";
        public static String PAIN_REPORTDATE = Report.REPORTDATE;
        public static String PAIN_ID = "pain_id";
        public static String PAIN_POSITION = "pain_position";
        public static String PAIN_LEVEL = "pain_level";
        public static int i_REPORTDATE = 0;
        public static int i_ID = 1;
        public static int i_POSITION = 2;
        public static int i_LEVEL = 3;
        public static String[] COLMN_PAIN_DIARY = { PAIN_REPORTDATE, PAIN_ID, PAIN_POSITION, PAIN_LEVEL };
        public static String CREATE_PAIN_DIARY = "CREATE TABLE " + PAIN_DIARY_TABLE + " (" +
                PAIN_REPORTDATE + " DATE NOT NULL, " +
                PAIN_ID + " INTEGER, " +
                PAIN_POSITION + " TEXT NOT NULL, " +
                PAIN_LEVEL + " INTEGER NOT NULL);";
    }


    public static class Std_lab {
        public static String STD_LAB_TABLE = "Std_lab";
        public static String LAB_ID = "lab_id";
        public static String LAB_NAME = "lab_name";
        public static String LAB_SEX = "lab_sex";
        public static String LAB_MAXVALUE = "lab_maxvalue";
        public static String LAB_MINVALUE = "lab_minvalue";
        public static String Lab_LESSMIN = "lab_lessmin";
        public static String LAB_OVERMAX = "lab_overmax";
        public static int i_ID = 0;
        public static int i_NAME = 1;
        public static int i_SEX = 2;
        public static int i_MAXVALUE = 3;
        public static int i_MINVALUE = 4;
        public static int i_LESSMIN = 5;
        public static int i_OVERMAX = 6;
        public static String[] COLMN_STD_LAB = {LAB_ID, LAB_NAME, LAB_SEX, LAB_MAXVALUE, LAB_MINVALUE, Lab_LESSMIN, LAB_OVERMAX};
        public static String CREATE_STD_LAB = "CREATE TABLE " + STD_LAB_TABLE + " (" +
                LAB_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LAB_NAME + " TEXT NOT NULL, " +
                LAB_SEX + " TEXT NOT NULL, " +
                LAB_MINVALUE + " REAL NOT NULL, " +
                LAB_MAXVALUE + " REAL NOT NULL, " +
                Lab_LESSMIN + " TEXT, " +
                LAB_OVERMAX + " TEXT);";
    }

    public static class Lab_diary {
        public static String LAB_DIARY_TABLE = "Lab_diary";
        public static String LAB_REPORTDATE = Report.REPORTDATE;
        public static String LAB_DIARY_ID = Std_lab.LAB_ID;
        public static String LAB_DIARY_VALUE = "lab_value";
        public static int i_REPORTDATE = 0;
        public static int i_ID = 1;
        public static int i_VALUE = 2;
        public static String[] COLMN_STD_LAB = {LAB_REPORTDATE, LAB_DIARY_ID, LAB_DIARY_VALUE};
        public static String CREATE_LAB_DIARY = "CREATE TABLE " + LAB_DIARY_TABLE + " (" +
                LAB_REPORTDATE + " DATE NOT NULL, " +
                LAB_DIARY_ID + " INTEGER, " +
                LAB_DIARY_VALUE + " REAL NOT NULL);";
    }

    public static class Appointment {
        public static String APPOINTMENT_TABLE = "Appointment";
        public static String APPOINTMENT_REPORTDATE = Report.REPORTDATE;
        public static String APPOINTMENT_DATE = "appointment_date";
        public static String APPOINTMENT_PLACE = "appointment_place";
        public static int i_REPORTDATE = 0;
        public static int i_DATE = 1;
        public static int i_PLACE = 2;
        public static String[] COLMN_SYMPTOM = {APPOINTMENT_REPORTDATE, APPOINTMENT_DATE, APPOINTMENT_PLACE};
        public static String CREATE_APPOINTMENT = "CREATE TABLE " + APPOINTMENT_TABLE + " (" +
                APPOINTMENT_REPORTDATE + " DATE NOT NULL, " +
                APPOINTMENT_DATE + " DATE NOT NULL, " +
                APPOINTMENT_PLACE + " TEXT NOT NULL);";
    }

}
