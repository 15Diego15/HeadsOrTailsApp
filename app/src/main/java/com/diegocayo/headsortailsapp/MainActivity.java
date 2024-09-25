package com.diegocayo.headsortailsapp;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private Random random = new Random();
private ImageView imageView;
private Button headButton, tailsButton;
private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.interrogantImage);
        tvResult = findViewById(R.id.resultText);
        headButton = findViewById(R.id.headsButton);
        tailsButton = findViewById(R.id.tailsButton);

        headButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = generateRandomNumber();
                showImageWinner(randomNumber, "heads");
            }
        });

        tailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = generateRandomNumber();
                showImageWinner(randomNumber, "tails");
            }
        });
    }

    private int generateRandomNumber () {
        int result = random.nextInt(2-1+1)+1;
        return result;
    }

    private void showImageWinner(int result, String userChoice) {
        if (result == 1) {  // Heads
            imageView.setImageResource(R.drawable.euro_cara);
            if (userChoice.equalsIgnoreCase("heads")) {
                tvResult.setText(getString(R.string.winText));
            } else {
                tvResult.setText(getString(R.string.defeatText));
            }
        } else if (result == 2) {  // Tails
            imageView.setImageResource(R.drawable.euro_cruz);
            if (userChoice.equalsIgnoreCase("tails")) {
                tvResult.setText(getString(R.string.winText));
            } else {
                tvResult.setText(getString(R.string.defeatText));
            }
        }
    }
}