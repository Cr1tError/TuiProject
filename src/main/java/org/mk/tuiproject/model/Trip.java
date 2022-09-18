package org.mk.tuiproject.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "trips")
public class Trip {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "price", nullable = false)
    private long price;

    @Column(name = "travel_direction", nullable = false)
    private String travelDirection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guide_id", nullable = false)
    private Guide guide;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SoldTrip> trips;

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", price=" + price +
                ", travelDirection='" + travelDirection + '\'' +
                ", trips=" + trips.size() +
                '}';
    }
}
