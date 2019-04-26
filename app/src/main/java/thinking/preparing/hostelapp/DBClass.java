package thinking.preparing.hostelapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBClass extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Emplyees.db";
    public static final String CONTACTS_TABLE_NAME = "employees";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_STREET = "street";
    public static final String CONTACTS_COLUMN_CITY = "place";
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    public static DBClass dbClass;

    public DBClass(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table employees (id integer primary key, name text,phone text,email text, street text,place text);");
        db.execSQL("create table " + CONTACTS_TABLE_NAME+" (id integer,name text,street text, phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long insetDataIntoDatabase(String name, String street,String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CONTACTS_COLUMN_NAME,name);
        values.put(CONTACTS_COLUMN_STREET,street);
        values.put(CONTACTS_COLUMN_PHONE,phone);
        long isInserted = db.insert(CONTACTS_TABLE_NAME,null,values);
        db.close();
        return isInserted;
//        values.put(CONTACTS_COLUMN_NAME,name);
    }

    public synchronized static DBClass dataBaseInstance(Context context){
        if(dbClass == null)
        {
            dbClass = new DBClass(context);
        }
        return dbClass;
    }

    public Cursor getDataLines(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + CONTACTS_TABLE_NAME,null);
        return cursor;
    }

}
