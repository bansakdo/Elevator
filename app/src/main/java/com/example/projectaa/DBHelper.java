package com.example.projectaa;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MONEYBOOK(_id INTEGER PRIMARY KEY AUTOINCREMENT, itme TEXT, " + " price INTERGER, create_at TEXT, amounts INTEGER, total INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert (String create_at, String item, int price, int amounts) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO MONEYBOOK VALUES(null, '"+item+"', "+price+", '"+create_at+"', "+amounts+", "+price*amounts+")");
        db.close();
    }

    public void update(String item, int price, int amounts) {
        SQLiteDatabase db = getWritableDatabase();
       // int total = price*amounts;
        db.execSQL("UPDATE MOENYBOOK SET price="+price+", amounts="+amounts+", total="+price*amounts+" WHERE item='"+item+"';");
        db.close();
    }
    public void delete(String item) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM MONEYBOOK WHERE item='"+item+"';");
        db.close();
    }
    public String getResult(){
        SQLiteDatabase db = getWritableDatabase();
        String result = "";
        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOK", null);
        while(cursor.moveToNext()) {
            result += cursor.getString(0) + ":" + cursor.getString(1) + "| 단가 " + cursor.getInt(2) + "원"+ cursor.getInt(4) + "개, 총액 "+ cursor.getInt(5) + "원" + cursor.getString(3)+"\n";
        }
        return result;
    }
}
