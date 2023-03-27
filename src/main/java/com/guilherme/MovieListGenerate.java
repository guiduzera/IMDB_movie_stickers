package com.guilherme;

import java.util.List;
import java.util.Map;

public class MovieListGenerate {
    private List<Map<String, String>> movies;

    public MovieListGenerate(List<Map<String, String>> movies) {
        this.movies = movies;
    }

    public List<Map<String, String>> getMovies() {
        return movies;
    }

    public void setMovies(List<Map<String, String>> movies) {
        this.movies = movies;
    }

    public void generate() {
        String moviesFormated = "";
        String stars = "";
        for (Map<String, String> movie : movies) {
            Float rating = Float.parseFloat(movie.get("imDbRating"));
            stars = "";
            for (int i = 0; i < Math.round(rating); i++) {
                stars += " \u001b[1m\u001b[33m*\u001b[m";
            }
            moviesFormated += "\u001b[1mClassificação:\u001b[m " + movie.get("imDbRating") + stars
                    + "\n\u001b[1mTítulo:\u001b[m "
                    + movie.get("title") + "\n\u001b[1mAno:\u001b[m " + movie.get("year")
                    + "\n\u001b[1mPoster:\u001b[m " + movie.get("image") + "\n\n";
        }
        System.out.println(moviesFormated);
    }
}
