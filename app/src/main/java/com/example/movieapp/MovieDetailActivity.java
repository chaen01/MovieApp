package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {
    private TextView titleTextView, yearTextView, imdbIdTextView, typeTextView;
    private ImageView posterImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        titleTextView = findViewById(R.id.titleTextView);
        yearTextView = findViewById(R.id.yearTextView);
        imdbIdTextView = findViewById(R.id.imdbIdTextView);
        typeTextView = findViewById(R.id.typeTextView);
        posterImageView = findViewById(R.id.posterImageView);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            int year = intent.getIntExtra("year", 0);
            String imdbID = intent.getStringExtra("imdbID");
            String type = intent.getStringExtra("type");
            String posterUrl = intent.getStringExtra("posterUrl");

            titleTextView.setText(title);
            yearTextView.setText(String.valueOf(year));
            imdbIdTextView.setText(imdbID);
            typeTextView.setText(type);
            Picasso.get().load(posterUrl).into(posterImageView);
        }
    }
}
