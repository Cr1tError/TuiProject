package org.mk.tuiproject.service;

import org.mk.tuiproject.model.SoldTrip;
import org.mk.tuiproject.model.Trip;
import org.mk.tuiproject.repository.SoldTripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldTripService {
    private final SoldTripRepository soldTripRepository;

    @Autowired
    public SoldTripService(SoldTripRepository soldTripRepository) {
        this.soldTripRepository = soldTripRepository;
    }

    public SoldTrip get(int id, int clientId) {
        return soldTripRepository.getWithClient(id, clientId);
    }

    public SoldTrip saveSoldTrip(SoldTrip trip){
        return soldTripRepository.save(trip);
    }


    public List<SoldTrip> getAll(long clientId) {
        return soldTripRepository.getAll(clientId);
    }

    public void deleteById(Long id){
        soldTripRepository.deleteById(id);
    }
}
