package org.mk.tuiproject.To;

import lombok.*;
import org.mk.tuiproject.model.SoldTrip;
import org.mk.tuiproject.service.SoldTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class SoldTripTo {

    private long id;
    private String travelDirection;
    private String departureDate;
    private String arrivalDate;
    private String guide;
    private long price;
    private String goal;

    private long clientId;




    public SoldTripTo(long id, String travelDirection, String departureDate, String arrivalDate, String guide, long price, String goal, long clientId) {
        this.id = id;
        this.travelDirection = travelDirection;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.guide = guide;
        this.price = price;
        this.goal = goal;
        this.clientId = clientId;
    }

    public static SoldTripTo getOne(SoldTrip soldTrip){

        long id = soldTrip.getId();
        String travelDirection = soldTrip.getTrip().getTravelDirection();
        String departureDate = soldTrip.getDepartureDate().toString();
        String arrivalDate = soldTrip.getArrivalDate().toString();
        String guide = "" + soldTrip.getTrip().getGuide().getName() + " " +soldTrip.getTrip().getGuide().getSurname();
        long price = soldTrip.getPayed();
        String goal = soldTrip.getGoal();
        long clientId = soldTrip.getClient().getId();

        return new SoldTripTo(id, travelDirection, departureDate, arrivalDate, guide, price, goal, clientId);
    }

    @Override
    public String toString() {
        return "SoldTripTo{" +
                "id=" + id +
                ", travelDirection='" + travelDirection + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", guide='" + guide + '\'' +
                ", price=" + price +
                ", goal='" + goal + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
