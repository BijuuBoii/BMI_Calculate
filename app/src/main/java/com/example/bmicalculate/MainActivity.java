package com.example.bmicalculate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

     Button btnCalculate;
     EditText txtBMI, txtHeight, txtWeight, txtDiagnose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btnCalculate);
        txtBMI = findViewById(R.id.txtBMI);
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight  =findViewById(R.id.txtWeight);
        txtDiagnose = findViewById(R.id.txtDiagnose);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double H, W , BMI = 0;
                String diagnose = "";
                try {
                    H = Double.parseDouble(txtHeight.getText().toString());
                    W = Double.parseDouble(txtWeight.getText().toString());
                    BMI = W/Math.pow(H, 2);
                    diagnose = "";
                    if(BMI < 18)
                        diagnose = "You're thin";
                    else if(BMI <= 24.9)
                        diagnose = "You're normal";
                    else if(BMI <= 29.9)
                        diagnose = "You have level 1 obesity";
                    else if(BMI <= 34.9)
                        diagnose = "You have level 2 obesity";
                    else
                        diagnose = "You have level 3 obesity";
                }
                catch(Exception e)
                {
                    H = W = 0;
                    diagnose = "Please write all info !!!";
                }

                txtBMI.setText(BMI+"");
                txtDiagnose.setText(diagnose);
            }
        });

    }
}