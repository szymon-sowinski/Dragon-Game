package com.example.gra_pokonajsmoka;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EdgeEffect;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userNumber = findViewById(R.id.userNumber);
        Button submitButton = findViewById(R.id.submitButton);


        submitButton.setOnClickListener(view -> {
            Random rand = new Random();
            int randomNumber = rand.nextInt(10);
            String number = userNumber.getText().toString().trim();
            String outcome;

            if(number.isEmpty()) {
                outcome = "Proszę podać wartość!";
            }
            else {
                float userNumber2 =Integer.parseInt(userNumber.getText().toString().trim());
                if(userNumber2 >= 0 && userNumber2 <= 100){
                    if(userNumber2 == randomNumber){
                        outcome = "Gratulacje! Pokonano smoka.";
                    }
                    else {
                        outcome = "Spróbuj ponownie! Nie trafiono liczby. Liczba to: ";
                    }
                }
                else {
                    outcome = "Podaj licbzę z zakresu od 0 do 100 ";
                }
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(outcome)
                        .setTitle("Gra Smok")
                        .setPositiveButton("Graj dalej", (dialog, id) ->{});
                AlertDialog dialog = builder.create();
                dialog.show();
        });
    }
}