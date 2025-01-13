package com.example.mykemasskibidi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HitungkompresimotorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hitungkompresimotor);

        // Deklarasi View
        EditText volumeSilinderInput = findViewById(R.id.volumesilinder);
        EditText volumeRuangBakarInput = findViewById(R.id.ruangbakar);
        Button calculateButton = findViewById(R.id.calculateButton);
        TextView outputResult = findViewById(R.id.output);

        // Set Listener untuk Tombol Kalkulasi
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Ambil nilai dari input
                    String volumeSilinderText = volumeSilinderInput.getText().toString();
                    String volumeRuangBakarText = volumeRuangBakarInput.getText().toString();

                    if (volumeSilinderText.isEmpty() || volumeRuangBakarText.isEmpty()) {
                        Toast.makeText(HitungkompresimotorActivity.this, "Harap masukkan semua data!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Parsing input menjadi double
                    double volumeSilinder = Double.parseDouble(volumeSilinderText);
                    double volumeRuangBakar = Double.parseDouble(volumeRuangBakarText);

                    if (volumeRuangBakar <= 0) {
                        Toast.makeText(HitungkompresimotorActivity.this, "Volume ruang bakar harus lebih besar dari 0!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Hitung Rasio Kompresi
                    double compressionRatio = (volumeSilinder + volumeRuangBakar) / volumeRuangBakar;

                    // Konversi ke format perbandingan
                    int ratioInt = (int) Math.round(compressionRatio);

                    // Tampilkan hasil dalam format perbandingan
                    outputResult.setText(String.format("Rasio Kompresi: %d:1", ratioInt));

                } catch (NumberFormatException e) {
                    Toast.makeText(HitungkompresimotorActivity.this, "Masukkan nilai numerik yang valid!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(HitungkompresimotorActivity.this, "Terjadi kesalahan! Periksa input Anda.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}