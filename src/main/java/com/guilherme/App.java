package com.guilherme;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        JsonParser jsonParser = new JsonParser();
        ApiConsumer apiConsumer = new ApiConsumer(url, jsonParser);
        try {
            List<Map<String, String>> response = apiConsumer.getResponseAsList();
            MovieListGenerate movieListGenerate = new MovieListGenerate(response);
            movieListGenerate.generate();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
