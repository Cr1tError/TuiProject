package org.mk.tuiproject.controller;

import org.mk.tuiproject.To.SoldTripTo;
import org.mk.tuiproject.model.SoldTrip;
import org.mk.tuiproject.service.ClientService;
import org.mk.tuiproject.service.SoldTripService;
import org.mk.tuiproject.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Controller
public class SoldTripController {

    private final SoldTripService soldTripService;
    private final TripService tripService;
    private final ClientService clientService;

    @Autowired
    public SoldTripController(SoldTripService soldTripService, TripService tripService, ClientService clientService) {
        this.soldTripService = soldTripService;
        this.tripService = tripService;
        this.clientService = clientService;
    }


    @GetMapping("/client-purchases/{id}")
    public String findAll(Model model, @PathVariable("id") long id){
        List<SoldTripTo>  trips;
        long clientId;
        try{
            List<SoldTrip> sTrips = soldTripService.getAll(id);
            trips = sTrips.stream().map(SoldTripTo::getOne).collect(Collectors.toList());
            clientId = id;
            model.addAttribute("trips", trips);
            model.addAttribute("clientId", clientId);
        } catch (NoSuchElementException e){
            trips = Collections.emptyList();
            clientId = id;
            model.addAttribute("trips", trips);
            model.addAttribute("clientId", clientId);
        }

        return "purchases-list";
    }

    @GetMapping("/client-purchases/purchase-create/{id}")
    public String createTripsForm(SoldTripTo soldTripTo, @PathVariable("id") long id){
        soldTripTo.setClientId(id);
        return "purchase-create";
    }

    @PostMapping("/purchase-create")
    public String createTrips(SoldTripTo soldTripto){
        SoldTrip soldTrip = new SoldTrip();
        soldTrip.setTrip(tripService.findAll().stream().filter(t-> t.getTravelDirection().equals(soldTripto.getTravelDirection())).findAny().orElse(null));
        soldTrip.setDepartureDate(Date.valueOf(soldTripto.getDepartureDate()));
        soldTrip.setArrivalDate(Date.valueOf(soldTripto.getArrivalDate()));
        soldTrip.setGoal(soldTripto.getGoal());
        soldTrip.setPayed(soldTripto.getPrice());
        soldTrip.setClient(clientService.findById(soldTripto.getClientId()));
        soldTripService.saveSoldTrip(soldTrip);
        return "redirect:/client-purchases/"+soldTripto.getClientId()+"";
    }

    @GetMapping("/client-purchases/{cid}/purchase-delete/{id}")
    public String deleteSoldTrip( @PathVariable("cid") long clientId, @PathVariable("id") long id){
        soldTripService.deleteById(id);
        return "redirect:/client-purchases/"+ clientId +"";
    }

}
