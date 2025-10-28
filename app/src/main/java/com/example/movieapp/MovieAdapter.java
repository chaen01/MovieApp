package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }



    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_movie_item, parent, false);
        return new MovieViewHolder(view);
    }


    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.titleTextView.setText(movie.getTitle());
        holder.yearTextView.setText(String.valueOf(movie.getYear()));
        Picasso.get().load(movie.getPosterUrl()).into(holder.posterImageView);
    }


    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView yearTextView;
        ImageView posterImageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            posterImageView = itemView.findViewById(R.id.posterImageView);

            itemView.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Movie selectedMovie = movieList.get(position);
                        Intent intent = new Intent(context, MovieDetailActivity.class);
                        intent.putExtra("title", selectedMovie.getTitle());
                        intent.putExtra("year", selectedMovie.getYear());
                        intent.putExtra("imdbID", selectedMovie.getImdbID());
                        intent.putExtra("type", selectedMovie.getType());
                        intent.putExtra("posterUrl", selectedMovie.getPosterUrl());
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
