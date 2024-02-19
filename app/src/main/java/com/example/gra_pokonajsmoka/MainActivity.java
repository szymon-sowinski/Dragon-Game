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
import android.media.MediaPlayer;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userNumber = findViewById(R.id.userNumber);
        Button submitButton = findViewById(R.id.submitButton);
        MediaPlayer DragonSound = MediaPlayer.create(this,R.raw.dragon_sound);



        submitButton.setOnClickListener(view -> {
//            Random rand = new Random();
//            int randomNumber = rand.nextInt(100);
            int randomNumber = 5;
            String number = userNumber.getText().toString().trim();
            String outcome = "";

            if(number.isEmpty()) {
                outcome = "Proszę podać wartość!";
            }
            else {
                float userNumber2 =Integer.parseInt(userNumber.getText().toString().trim());
                if(userNumber2 >= 0 && userNumber2 <= 100){
                    int difference = Math.abs((int) userNumber2 - randomNumber);
                    if(difference == 0){
                        outcome = "Gratulacje! Pokonano smoka.";
                        DragonSound.start();
                    }
                    else if(difference <= 10){
                        if(difference < userNumber2) {
                            outcome = "Byłeś/aś blisko! Twoja liczba była większa o " + difference + " od wylosowanej przez smoka";
                        }
                        else {
                            outcome = "Byłeś/aś blisko! Twoja liczba była mniejsza o " + difference + " od wylosowanej przez smoka";
                        }
                    }
                    else {
                        outcome = "Byłeś/aś daleko!";
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