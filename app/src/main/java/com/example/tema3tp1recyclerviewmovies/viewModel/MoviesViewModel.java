package com.example.tema3tp1recyclerviewmovies.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tema3tp1recyclerviewmovies.model.Movie;

import java.util.*;

public class MoviesViewModel extends ViewModel {

    private MutableLiveData<List<Movie>> movieList;

    public MoviesViewModel() {
        movieList = new MutableLiveData<>();
        loadMovies();
    }
    private void loadMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Vacaciones en familia","https://via.assets.so/movie.png?id=1&q=95&w=360&h=360&fit=fill"));
        movies.add(new Movie("He's all that","https://via.assets.so/movie.png?id=2&q=95&w=360&h=360&fit=fill"));
        movies.add(new Movie("Venom","https://via.assets.so/movie.png?id=3&q=95&w=360&h=360&fit=fill"));
        movies.add(new Movie("Encanto","https://via.assets.so/movie.png?id=4&q=95&w=360&h=360&fit=fill"));
        movies.add(new Movie("Los locos Adams","https://via.assets.so/movie.png?id=5&q=95&w=360&h=360&fit=fill"));
        movies.add(new Movie("LAMB","https://via.assets.so/movie.png?id=6&q=95&w=360&h=360&fit=fill"));
        movieList.setValue(movies);
    }
    public LiveData<List<Movie>> getMovies() {
        return movieList;
    }
}
