package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddMovieActivity extends AppCompatActivity {
    private EditText titleEditText, yearEditText, imdbIdEditText, typeEditText, posterUrlEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        titleEditText = findViewById(R.id.titleEditText);
        yearEditText = findViewById(R.id.yearEditText);
        imdbIdEditText = findViewById(R.id.imdbIdEditText);
        typeEditText = findViewById(R.id.typeEditText);
        posterUrlEditText = findViewById(R.id.posterUrlEditText);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                int year = Integer.parseInt(yearEditText.getText().toString());
                String imdbID = imdbIdEditText.getText().toString();
                String type = typeEditText.getText().toString();
                String posterUrl = posterUrlEditText.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("title", title);
                resultIntent.putExtra("year", year);
                resultIntent.putExtra("imdbID", imdbID);
                resultIntent.putExtra("type", type);
                resultIntent.putExtra("posterUrl", posterUrl);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
