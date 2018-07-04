package com.example.nadhiravirly.tubesaplikasijajan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Kafe extends AppCompatActivity {
    String[] daftar; //
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    SQLHelper dbHelper;
    public static Kafe ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ma = this;

        dbHelper = new SQLHelper(this);

        RefreshList();
    }


    public void RefreshList()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM tempat_makan",null);

        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++)
        {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1);
        }

        ListView01 = (ListView)findViewById(R.id.ListView01);
        ListView01.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Edit", "Delete"};
                AlertDialog.Builder builder = new AlertDialog.Builder(Kafe.this);
                builder.setTitle("Pilih ?");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), viewKafe1.class);
                                i.putExtra("nama", selection);
                                startActivity(i);

                                break;
                            case 1 :
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                db.execSQL("delete from tempat_makan where nama = '"+selection+"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});


        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}
