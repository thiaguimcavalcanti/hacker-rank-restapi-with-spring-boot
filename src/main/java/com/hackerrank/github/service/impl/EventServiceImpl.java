package com.hackerrank.github.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hackerrank.github.exceptions.BadRequestException;
import com.hackerrank.github.exceptions.NotFoundException;
import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Event_;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private ActorRepository actorRepository;

	@Override
	public List<Event> getEventsByActorId(Long actorId) {
		if (!actorRepository.existsById(actorId)) {
			throw new NotFoundException();
		} else {
			Actor actor = new Actor();
			actor.setId(actorId);

			Event event = new Event();
			event.setActor(actor);

			return eventRepository.findAll(Example.of(event), sortAscendingOrderById());
		}
	}

	@Override
	public Optional<Event> save(Event event) {
		if (!eventRepository.existsById(event.getId())) {
			return Optional.ofNullable(eventRepository.save(event));
		} else {
			throw new BadRequestException();
		}
	}

	@Override
	public List<Event> findAll() {
		return eventRepository.findAll(sortAscendingOrderById());
	}

	private Sort sortAscendingOrderById() {
		return new Sort(Direction.ASC, Event_.ID);
	}

	@Override
	public void deleteAll() {
		eventRepository.deleteAll();
	}
}
