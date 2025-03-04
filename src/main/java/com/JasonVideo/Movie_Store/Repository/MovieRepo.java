package com.JasonVideo.Movie_Store.Repository;

import com.JasonVideo.Movie_Store.Model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepo extends MongoRepository<Movie, String> {
}
