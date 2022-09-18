package org.mk.tuiproject.repository;

import org.mk.tuiproject.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TripRepository extends JpaRepository<Trip, Long> {


}
