package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "pets.db";
    public static final int DATABASE_VERSION = 1;

    public static final String DROP_PET_TABLE = "DROP TABLE " + PetsContract.TABLE_NAME + ";";

    public static final String CREATE_TABLE_PET = "CREATE TABLE " + PetsContract.TABLE_NAME +
            "(" + PetsContract.COLUMN_PET_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT" +
            "," + PetsContract.COLUMN_PET_NAME + " TEXT" +
            "," + PetsContract.COLUMN_PET_BREED + " TEXT " +
            "," + PetsContract.COLUMN_PET_GENDER + " INTEGER" +
            "," + PetsContract.COLUMN_PET_WEIGHT + " INTEGER);";


    public PetDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_PET);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_PET_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE_PET);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
