package com.hackerrank.github.repository;

import java.util.List;

import com.hackerrank.github.model.Actor;

public interface CustomActorRepository {

	/**
	 * Get Actors Ordered By Total Number Of Events
	 * 
	 * @return {@link List} of Actors
	 */
	List<Actor> getActorsOrderedByTotalNumberOfEvents();

}
