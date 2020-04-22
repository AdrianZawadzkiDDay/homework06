package pl.bykowski.email_sender.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.bykowski.email_sender.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private List<Movie> movies = new ArrayList<>();


    @EventListener(ApplicationReadyEvent.class)
    private void init() {
        movies.add(new Movie("Prestiż", "2006", "Christopher Nolan"));
        movies.add(new Movie("PBuntownik z wyboru", "1997", "QGus van Sant"));

    }


    public List<Movie> getMovies() {
        return movies;
    }

    public boolean addMovie(Movie movie) {

        return Optional.ofNullable(movie).map(m -> movies.add(m)).orElse(false);
    }
}
