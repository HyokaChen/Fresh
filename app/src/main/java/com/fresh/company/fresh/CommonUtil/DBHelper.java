package com.fresh.company.fresh.CommonUtil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CJH on 2016/8/26.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "data.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        //CursorFactory设置为null,使用默认值
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //数据库第一次被创建时onCreate会被调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS userInfo" +
                "(id VARCHAR PRIMARY KEY, usr VARCHAR, psd VARCHAR)");

        db.execSQL("CREATE TABLE IF NOT EXISTS goodsInfo" +
                "(barcode VARCHAR PRIMARY KEY, goods_name VARCHAR,type INTEGER ,manufacturer VARCHAR, production_date VARCHAR,price DOUBLE" +
                ",picture_path VARCHAR, durability_period VARCHAR, manual_period VARCHAR)");
        db.execSQL("CREATE TABLE IF NOT EXISTS dietPlanInfo" +
                "(date VARCHAR PRIMARY KEY, morning VARCHAR, afternoon VARCHAR,evening VARCHAR)");

    }

    //如果DATABASE_VERSION值被改为2,系统发现现有数据库版本不同,即会调用onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("ALTER TABLE person ADD COLUMN other STRING");
        if (newVersion==2) {
            db.execSQL("CREATE TABLE IF NOT EXISTS dietPlanInfo" +
                    "(date VARCHAR PRIMARY KEY, morning VARCHAR, afternoon VARCHAR,evening VARCHAR)");
        }
    }
}
