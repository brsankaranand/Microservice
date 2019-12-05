/**
 * 
 */
package com.ms.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.ms.moviecatalogservice.models.CatalogItem;
import com.ms.moviecatalogservice.models.Movie;
import com.ms.moviecatalogservice.models.UserRating;

/**
 * @author brsan
 *
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	public WebClient.Builder webClientBuilder;

	@RequestMapping("{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		UserRating ratings = restTemplate.getForObject("http://rating-dat-service/ratingsdata/userdata/"+userId, UserRating.class);

		return ratings.getRatings().stream().map(rating->{
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(),"Test",rating.getRating());
		}).collect(Collectors.toList());
		
	}
}
