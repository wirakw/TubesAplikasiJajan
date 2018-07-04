package com.example.nadhiravirly.tubesaplikasijajan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Button btKafe, btRestoran, btKedai, btUmum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btKafe = findViewById(R.id.buttonKafe);
        btKafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenKafe(v);
            }
        });

        btRestoran = findViewById(R.id.buttonRestoran);
        btRestoran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRestoran(v);
            }
        });

        btKedai = findViewById(R.id.buttonKedai);
        btKedai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenKedai(v);
            }
        });

        btUmum = findViewById(R.id.buttonUmum);
        btUmum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenUmum(v);
            }
        });
    }
    public void OpenKafe(View view){
        startActivity(new Intent(this,Kafe.class));
    }
    public void OpenRestoran(View view){
        startActivity(new Intent(this,Restoran.class));
    }
    public void OpenKedai(View view){
        startActivity(new Intent(this,Kedai.class));
    }
    public void OpenUmum(View view){
        startActivity(new Intent(this,Umum.class));
    }
}
