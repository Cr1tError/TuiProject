package org.mk.tuiproject.controller;


import org.mk.tuiproject.model.Guide;
import org.mk.tuiproject.model.Trip;
import org.mk.tuiproject.service.GuideService;
import org.mk.tuiproject.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TripController {

    private final TripService tripService;
    private final GuideService guideService;


    @Autowired
    public TripController(TripService tripService, GuideService guideService) {
        this.tripService = tripService;
        this.guideService=guideService;
    }

    @GetMapping("/trips")
    public String findAll(Model model){
        List<Trip> trips = tripService.findAll();
        model.addAttribute("trips", trips);
        return "trip-list";
    }

    @GetMapping("/trip-create")
    public String createTripForm(Trip trip){
        return "trip-create";
    }

    @PostMapping("/trip-create")
    public String createTrip(Trip trip){
        String travelDirection = trip.getTravelDirection();
        Guide guide = guideService.findAll().stream().filter(g -> travelDirection.equals(g.getDescription())).findAny().orElse(null);
        trip.setGuide(guide);
        tripService.saveTrip(trip);
        return "redirect:/trips";
    }

    @GetMapping("trip-delete/{id}")
    public String deleteTrip(@PathVariable("id") Long id){
        tripService.deleteById(id);
        return "redirect:/trips";
    }

    @GetMapping("/trip-update/{id}")
    public String updateTripForm(@PathVariable("id") Long id, Model model){
        Trip trip = tripService.findById(id);
        model.addAttribute("trip", trip);
        return "trip-update";
    }

    @PostMapping("/trip-update")
    public String updateTrip(Trip trip){
        String travelDirection = trip.getTravelDirection();
        Guide guide = guideService.findAll().stream().filter(g -> travelDirection.equals(g.getDescription())).findAny().orElse(null);
        trip.setGuide(guide);
        tripService.saveTrip(trip);
        return "redirect:/trips";
    }
}
