package com.hackerrank.github.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Actor_;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Event_;
import com.hackerrank.github.repository.CustomActorRepository;

public class ActorRepositoryImpl implements CustomActorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Actor> getActorsOrderedByTotalNumberOfEvents() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
		Root<Actor> root = cq.from(Actor.class);

		Join<Actor, Event> joinEvents = root.join(Actor_.events);

		List<Order> orders = new ArrayList<>();
		orders.add(cb.desc(cb.count(joinEvents.get(Event_.id))));
		orders.add(cb.desc(cb.greatest(joinEvents.get(Event_.createdAt))));
		orders.add(cb.desc(root.get(Actor_.login)));

		cq.orderBy(orders);

		cq.groupBy(root.get(Actor_.id));

		TypedQuery<Actor> query = entityManager.createQuery(cq);

		return query.getResultList();
	}
}
