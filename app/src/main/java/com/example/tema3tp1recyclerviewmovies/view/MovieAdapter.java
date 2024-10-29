package com.example.tema3tp1recyclerviewmovies.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tema3tp1recyclerviewmovies.databinding.ItemMovieBinding;
import com.example.tema3tp1recyclerviewmovies.listener.MovieClickedListener;
import com.example.tema3tp1recyclerviewmovies.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movies;
    private MovieClickedListener movieClickedListener;
    private Context context;

    public MovieAdapter(List<Movie> movies, MovieClickedListener movieClickedListener, Context context) {
        this.movies = movies;
        this.movieClickedListener = movieClickedListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemMovieBinding binding;

        public ViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Movie movie) {
            binding.movieTitle.setText(movie.getTitle());
            Glide.with(context)
                    .load(movie.getCover())
                    .into(binding.movieCover);
            binding.movieRating.setRating(movie.getEstrellas());
            binding.movieCover.setOnClickListener(v -> movieClickedListener.onMovieClicked(movie));
        }
    }
}
