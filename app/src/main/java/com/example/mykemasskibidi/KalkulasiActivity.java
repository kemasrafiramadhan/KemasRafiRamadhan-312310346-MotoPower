package com.example.mykemasskibidi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KalkulasiActivity extends AppCompatActivity {

    private EditText diameterInput, strokeInput, cylindersInput;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulasi);
        diameterInput = findViewById(R.id.diameter);
        strokeInput = findViewById(R.id.stroke);
        cylindersInput = findViewById(R.id.cylinders);
        outputText = findViewById(R.id.output);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        try {
            double diameter = Double.parseDouble(diameterInput.getText().toString());
            double stroke = Double.parseDouble(strokeInput.getText().toString());
            int cylinders = Integer.parseInt(cylindersInput.getText().toString());

            double radius = diameter / 2;
            double volume = Math.PI * Math.pow(radius, 2) * stroke * cylinders;

            outputText.setText("Volume Mesin: " + String.format("%.2f", volume) + " cc");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan nilai yang valid", Toast.LENGTH_SHORT).show();
        }
    }
}
