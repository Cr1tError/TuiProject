package org.mk.tuiproject.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="sold_trips")
public class SoldTrip {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

    @Column(name = "departure_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departureDate;

    @Column(name = "arrival_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;

    @Column(name = "payed")
    private long payed;

    @Column(name = "goal")
    private String goal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

 @Override
 public String toString() {
  return "SoldTrip{" +
          "id=" + id +
          ", departureDate=" + departureDate +
          ", arrivalDate=" + arrivalDate +
          ", payed=" + payed +
          ", goal='" + goal + '\'' +
          '}';
 }
}
