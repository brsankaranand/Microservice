/**
 * 
 */
package com.ms.ratingdataservice.models;

import java.util.List;

/**
 * @author brsan
 *
 */
public class UserRating {

	private List<Rating> ratings;

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
}
