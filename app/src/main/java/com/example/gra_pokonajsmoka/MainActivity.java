package com.example.gra_pokonajsmoka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int difficultyLevel = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userNumber = findViewById(R.id.userNumber);
        Button submitButton = findViewById(R.id.submitButton);
        MediaPlayer DragonSound = MediaPlayer.create(this, R.raw.dragon_sound);
        CheckBox difficultyCheckbox = findViewById(R.id.difficultyCheckbox);

        difficultyCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                difficultyLevel = 2;
                userNumber.setHint("Podaj liczbę od 0 do " + getMaxRange());
            } else {
                difficultyLevel = 1;
                userNumber.setHint("Podaj liczbę od 0 do 100");
            }
        });

        submitButton.setOnClickListener(view -> {
            int minRange = 0;
            int maxRange = getMaxRange();

            Random rand = new Random();
            int randomNumber = rand.nextInt(maxRange - minRange + 1) + minRange;

            String number = userNumber.getText().toString().trim();
            String outcome = "";

            if (number.isEmpty()) {
                outcome = "Proszę podać wartość!";
            } else {
                float userNumber2 = Integer.parseInt(userNumber.getText().toString().trim());
                if (userNumber2 >= 0 && userNumber2 <= maxRange) {
                    int difference = Math.abs((int) userNumber2 - randomNumber);
                    if (difference == 0) {
                        outcome = "Gratulacje! Pokonano smoka.";
                        DragonSound.start();
                    } else if (difference <= 15) {
                        if (difference < userNumber2) {
                            outcome = "Byłeś/aś blisko! Twoja liczba była większa o " + difference + " od wylosowanej przez smoka";
                        } else {
                            outcome = "Byłeś/aś blisko! Twoja liczba była mniejsza o " + difference + " od wylosowanej przez smoka";
                        }
                    } else {
                        outcome = "Byłeś/aś daleko!";
                    }
                } else {
                    outcome = "Podaj liczbę z zakresu od 0 do " + maxRange;
                }
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(outcome)
                    .setTitle("Gra Smok")
                    .setPositiveButton("Graj dalej", (dialog, id) -> {
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    private int getMaxRange() {
        switch (difficultyLevel) {
            case 1:
                return 100;
            case 2:
                return 200;
            default:
                return 100;
        }
    }
}