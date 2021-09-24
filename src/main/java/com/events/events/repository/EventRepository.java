package com.events.events.repository;

import com.events.events.models.Event;
import org.springframework.data.repository.CrudRepository;


public interface EventRepository extends CrudRepository<Event, String> {
}
