package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.JsonResponse;
import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieRepository movieRepo;
	
	@GetMapping("/")
	public JsonResponse list() {
		JsonResponse jr = null;
		List<Movie> movies = movieRepo.findAll();
		if (movies.size()==0) {
			jr = JsonResponse.getInstance("No movies found.");
		}
		else {
			jr = JsonResponse.getInstance(movies);
		}
		return jr;
	}

	@GetMapping("/{id}")
	public JsonResponse get(@PathVariable int id) {
		// expected responses?
		// 1 - a single movie
		// 2 - bad id - no movie found
		// 3 - Exception?? - hold off for now, implement 
		//                   exception handling as needed
		JsonResponse jr = null;
		Optional<Movie> movie = movieRepo.findById(id);
		if (movie.isPresent()) {
			jr = JsonResponse.getInstance(movie.get());
		}
		else {
			jr = JsonResponse.getInstance("No movie found for id: "+id);
		}
		return jr;
	}
	
	
	
	
	
	

}
