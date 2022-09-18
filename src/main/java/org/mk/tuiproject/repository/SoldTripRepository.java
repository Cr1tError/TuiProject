package org.mk.tuiproject.repository;

import org.mk.tuiproject.model.SoldTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SoldTripRepository extends JpaRepository<SoldTrip, Long>  {
    @Modifying
    @Transactional
    @Query("DELETE FROM SoldTrip t WHERE t.id=:id AND t.client.id=:clientId")
    int deleteById(@Param("id") long id, @Param("clientId") long clientId);


    @Query("SELECT t FROM SoldTrip t WHERE t.client.id=:clientId ORDER BY t.departureDate DESC")
    List<SoldTrip> getAll(@Param("clientId") long clientId);

    @Query("SELECT t FROM SoldTrip t JOIN FETCH t.client WHERE t.id = ?1 and t.client.id = ?2")
    SoldTrip getWithClient(int id, int userId);
}
