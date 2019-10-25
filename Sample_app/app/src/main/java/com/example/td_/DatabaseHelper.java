package com.example.td_;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyStudent1.db";
    public static final String TABLE_NAME = "mystudent_table";
    public static final String COL_1 = "NUMBER";
    public static final String COL_2 = "NAME";

    public DatabaseHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (NUMBER TEXT," + "NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    boolean insertdata(String NUMBER1, String NAME1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, NUMBER1);
        contentValues.put(COL_2, NAME1);
        long k = db.insert(TABLE_NAME, null, contentValues);
        if (k == -1)
            return false;
        else
            return true;
    }

    public Cursor getData(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE NUMBER= ?", new String[]{id}, null);
        return cursor;

    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        return cursor;
    }
}
