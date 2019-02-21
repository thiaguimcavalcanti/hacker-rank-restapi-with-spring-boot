package com.hackerrank.github.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.github.exceptions.BadRequestException;
import com.hackerrank.github.exceptions.NotFoundException;
import com.hackerrank.github.model.Actor;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository actorRepository;

	@Override
	public List<Actor> getActorsOrderedByMaximumStreak() {
		return actorRepository.getActorsOrderedByMaximumStreak();
	}

	@Override
	public Optional<Actor> update(Actor actor) {
		Optional<Actor> persistedActor = actorRepository.findById(actor.getId());
		if (persistedActor.isPresent()) {
			if (Objects.equals(actor.getLogin(), persistedActor.get().getLogin())) {
				return Optional.ofNullable(actorRepository.save(actor));
			} else {
				throw new BadRequestException();
			}
		} else {
			throw new NotFoundException();
		}
	}

	@Override
	public List<Actor> getActorsOrderedByTotalNumberOfEvents() {
		return actorRepository.getActorsOrderedByTotalNumberOfEvents();
	}
}
