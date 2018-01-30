package com.business;

import gvjava.org.json.JSONException;
import gvjava.org.json.JSONObject;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Recipe {
	private double averageRating;
	private String cookTime;
	private String description;
	private transient List<Directions> directions;
	private int fiveStarReviews;
	private int fourStarReviews;
	private String handle;
	private String imageUrl;
	private transient List<Ingredients> ingredients;
	private String largeImageUrl;
	private int oneStarReviews;
	private String prepTime;
	private String reviewsUrl;
	private String servingSize;
	private int threeStarReviews;
	private String thumbImageUrl;
	private String title;
	private int totalReviews;
	private int twoStarReviews;
	private String url;

	public Recipe() { 
		super(); 
	} 

	public Recipe(double averageRating, String cookTime, String description, List<Directions> directions, int fiveStarReviews, int fourStarReviews, String handle, String imageUrl, List<Ingredients> ingredients, String largeImageUrl, int oneStarReviews, String prepTime, String reviewsUrl, String servingSize, int threeStarReviews, String thumbImageUrl, String title, int totalReviews, int twoStarReviews, String url) {
		this.averageRating = averageRating;
		this.cookTime = cookTime;
		this.description = description;
		this.directions = directions;
		this.fiveStarReviews = fiveStarReviews;
		this.fourStarReviews = fourStarReviews;
		this.handle = handle;
		this.imageUrl = imageUrl;
		this.ingredients = ingredients;
		this.largeImageUrl = largeImageUrl;
		this.oneStarReviews = oneStarReviews;
		this.prepTime = prepTime;
		this.reviewsUrl = reviewsUrl;
		this.servingSize = servingSize;
		this.threeStarReviews = threeStarReviews;
		this.thumbImageUrl = thumbImageUrl;
		this.title = title;
		this.totalReviews = totalReviews;
		this.twoStarReviews = twoStarReviews;
		this.url = url;
	}


	//Getters and setters
	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public String getCookTime() {
		return cookTime;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Directions> getDirections() {
		return directions;
	}

	public void setDirections(List<Directions> directions) {
		this.directions = directions;
	}

	public int getFiveStarReviews() {
		return fiveStarReviews;
	}

	public void setFiveStarReviews(int fiveStarReviews) {
		this.fiveStarReviews = fiveStarReviews;
	}

	public int getFourStarReviews() {
		return fourStarReviews;
	}

	public void setFourStarReviews(int fourStarReviews) {
		this.fourStarReviews = fourStarReviews;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	public String getLargeImageUrl() {
		return largeImageUrl;
	}

	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}

	public int getOneStarReviews() {
		return oneStarReviews;
	}

	public void setOneStarReviews(int oneStarReviews) {
		this.oneStarReviews = oneStarReviews;
	}

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public String getReviewsUrl() {
		return reviewsUrl;
	}

	public void setReviewsUrl(String reviewsUrl) {
		this.reviewsUrl = reviewsUrl;
	}

	public String getServingSize() {
		return servingSize;
	}

	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}

	public int getThreeStarReviews() {
		return threeStarReviews;
	}

	public void setThreeStarReviews(int threeStarReviews) {
		this.threeStarReviews = threeStarReviews;
	}

	public String getThumbImageUrl() {
		return thumbImageUrl;
	}

	public void setThumbImageUrl(String thumbImageUrl) {
		this.thumbImageUrl = thumbImageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(int totalReviews) {
		this.totalReviews = totalReviews;
	}

	public int getTwoStarReviews() {
		return twoStarReviews;
	}

	public void setTwoStarReviews(int twoStarReviews) {
		this.twoStarReviews = twoStarReviews;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	//JSON representation
	public JSONObject toJSON() { 
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			return new JSONObject(mapper.writeValueAsString(this));
		} catch (Exception e) {
			throw new RuntimeException("Cannot convert Recipe data into JSONObject");
		}
	}

	//Inner class Directions
	@JsonInclude(Include.NON_NULL)
	public static class Directions {

		private String description;

		public Directions() { 
			super(); 
		} 

		public Directions(String description) {
			super(); 
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public JSONObject toJSON() throws JSONException { 
			return(new JSONObject(this.toString()));
		}

		public String toString() {
			return "{" +
					"description=" + getDescription() + "}";
		}
	}

	//Inner class Ingredients
	@JsonInclude(Include.NON_NULL)
	public static class Ingredients {

		private String description;
		private String size;
		private String unit;

		public Ingredients() { 
			super(); 
		} 

		public Ingredients(String description, String size, String unit) {
			super(); 
			this.description = description;
			this.size = size;
			this.unit = unit;
		}

		//Getter and setters
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public JSONObject toJSON() throws JSONException { 
			return(new JSONObject(this.toString()));
		}

		public String toString() {
			return "{" +
					"description=" + getDescription() + 
					",size=" + getSize()  +
					",unit=" + getUnit() +
					"}";
		}
	}

	public static Recipe create(JSONObject data) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(data.toString().getBytes(), Recipe.class);
	}
}
