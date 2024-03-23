package org.example.moviecatalogservice.controllers;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.moviecatalogservice.entitites.CatalogItem;
import org.example.moviecatalogservice.entitites.Movie;
import org.example.moviecatalogservice.entitites.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    private final RestTemplate restTemplate;

    public MovieCatalogController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/{userId}")
    @CircuitBreaker(name="getCatalog", fallbackMethod = "getCatalogFallback")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {


       UserRating ratings = restTemplate.getForObject("http://movie-rating-data-service/ratings/users/" + userId, UserRating.class);

        return ratings.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "Test description", rating.getRating());
                })
                .collect(Collectors.toList());
    }

    public String getCatalogFallback(Throwable throwable) {
        return "Default response";
    }
}
