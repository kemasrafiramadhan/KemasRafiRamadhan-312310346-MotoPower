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

public class LubangventurimotorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lubangventurimotor);

        // Deklarasi komponen
        EditText konstantaInput = findViewById(R.id.konsta);
        EditText ccMesinInput = findViewById(R.id.CCmesin);
        EditText rpmInput = findViewById(R.id.RPM);
        Button calculateButton = findViewById(R.id.calculateButton);
        TextView outputResult = findViewById(R.id.output);

        // Event listener untuk tombol kalkulasi
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Ambil nilai dari input
                    String konstantaText = konstantaInput.getText().toString();
                    String ccText = ccMesinInput.getText().toString();
                    String rpmText = rpmInput.getText().toString();

                    if (konstantaText.isEmpty() || ccText.isEmpty() || rpmText.isEmpty()) {
                        Toast.makeText(LubangventurimotorActivity.this, "Harap isi semua kolom!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Parsing input menjadi double
                    double konstanta = Double.parseDouble(konstantaText);
                    double ccMesin = Double.parseDouble(ccText);
                    int rpm = Integer.parseInt(rpmText);

                    // Validasi nilai konstanta
                    if (konstanta < 0.6 || konstanta > 0.9) {
                        Toast.makeText(LubangventurimotorActivity.this, "Konstanta harus antara 0.6 dan 0.9!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Validasi nilai lainnya
                    if (ccMesin <= 0 || rpm <= 0) {
                        Toast.makeText(LubangventurimotorActivity.this, "CC Mesin dan RPM harus lebih besar dari 0!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Kalkulasi diameter venturi
                    double diameter = Math.sqrt((konstanta * ccMesin * rpm) / 1000);

                    // Tampilkan hasil
                    outputResult.setText(String.format("Diameter Venturi: %.2f mm", diameter));

                } catch (NumberFormatException e) {
                    Toast.makeText(LubangventurimotorActivity.this, "Masukkan nilai numerik yang valid!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(LubangventurimotorActivity.this, "Terjadi kesalahan!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}