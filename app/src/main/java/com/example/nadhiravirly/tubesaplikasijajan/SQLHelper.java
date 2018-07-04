package com.example.nadhiravirly.tubesaplikasijajan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//http://cariprogram.blogspot.com
//nuramijaya@gmail.com

public class SQLHelper extends SQLiteOpenHelper{

	private static final String DATABASE_NAME = "jajan.db";
	private static final int DATABASE_VERSION = 2;

	public SQLHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table tempat_makan( id integer primary key autoincrement, nama text null, " + "alamat text null, deskripsi text null);";
		Log.d("Data", "onCreate: " + sql);
		db.execSQL(sql);
		sql = "INSERT INTO tempat_makan (id, nama, alamat, deskripsi) VALUES (1, 'wadoel', 'jalan geger kalong girang', 'tempat nongkrong dan makan');";
		db.execSQL(sql);
		sql = "INSERT INTO tempat_makan (id, nama, alamat, deskripsi) VALUES (2, 'north wood', 'gegerkalong no.24', 'tempat makan dan nongkrong');";
		db.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		
	}

}
