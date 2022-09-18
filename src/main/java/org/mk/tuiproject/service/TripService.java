package org.mk.tuiproject.service;

import org.mk.tuiproject.model.Trip;
import org.mk.tuiproject.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip findById(long id){
        return tripRepository.getReferenceById(id);
    }

    public List<Trip> findAll(){
        return tripRepository.findAll();
    }

    public Trip saveTrip(Trip trip){
        return tripRepository.save(trip);
    }

    public void deleteById(long id){
        tripRepository.deleteById(id);
    }
}
