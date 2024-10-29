package com.example.tema3tp1recyclerviewmovies.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.tema3tp1recyclerviewmovies.listener.MovieClickedListener;
import com.example.tema3tp1recyclerviewmovies.model.Movie;
import com.example.tema3tp1recyclerviewmovies.viewModel.MoviesViewModel;
import com.example.tema3tp1recyclerviewmovies.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MoviesViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        movieViewModel = new ViewModelProvider(this).get(MoviesViewModel.class);
        binding.recycler.setLayoutManager(new GridLayoutManager(this, 2));
        movieViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                if (movies != null && !movies.isEmpty()) {
                    Log.d("MoviesList", "Movies: " + movies.size());
                    // adapter
                    MovieAdapter adapter = new MovieAdapter(movies , new MovieClickedListener() {
                        @Override
                        public void onMovieClicked(Movie movie) {
                            Toast.makeText(MainActivity.this, "Eliges " + movie.getTitle(), Toast.LENGTH_SHORT).show();
                        }
                    },
                    MainActivity.this);
                    binding.recycler.setAdapter(adapter);
                } else {
                    Log.d("MainActivity", "Lista vacía");
                }
            }
        });
    }
}