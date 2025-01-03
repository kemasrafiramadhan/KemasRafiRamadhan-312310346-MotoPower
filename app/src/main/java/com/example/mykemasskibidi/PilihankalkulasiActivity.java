package com.example.mykemasskibidi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PilihankalkulasiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pilihankalkulasi);

        LinearLayout iconupdates = findViewById(R.id.hitungcc);
        iconupdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihankalkulasiActivity.this, KalkulasiActivity.class);
                startActivity(intent);
            }
        });
        ImageView icontohitung = findViewById(R.id.tohitungcc);
        icontohitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihankalkulasiActivity.this, KalkulasiActivity.class);
                startActivity(intent);
            }
        });
        ImageView toinformasi = findViewById(R.id.toinformasi);
        toinformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihankalkulasiActivity.this, InformasiActivity.class);
                startActivity(intent);
            }
        });
    }
}