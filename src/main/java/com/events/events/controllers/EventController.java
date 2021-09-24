package com.events.events.controllers;

import com.events.events.models.Event;
import com.events.events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value="/registerEvent", method= RequestMethod.GET)
    public String form() {
        return "event/formevent";
    }

    @RequestMapping(value="/registerEvent", method= RequestMethod.POST)
    public String form(Event event) {

        eventRepository.save(event);
        return "redirect:/registerEvent";
    }

    @RequestMapping("/events")
    public ModelAndView listEvents() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Event> events = eventRepository.findAll();
        modelAndView.addObject("events", events);
        return modelAndView;
    }
}
