package com.hackerrank.github.service;

import java.util.List;
import java.util.Optional;

import com.hackerrank.github.model.Actor;

public interface ActorService {

	/**
	 * Get Actor Ordered By Maximum Streak
	 * 
	 * @return {@link List} of Actors
	 */
	List<Actor> getActorsOrderedByMaximumStreak();

	/**
	 * Update the actor
	 * 
	 * @param actor
	 * @return {@link Optional} with the Actor
	 */
	Optional<Actor> update(Actor actor);

	/**
	 * Get Actors Ordered By Total Number Of Events
	 * 
	 * @return {@link List} of Actors
	 */
	List<Actor> getActorsOrderedByTotalNumberOfEvents();
}
