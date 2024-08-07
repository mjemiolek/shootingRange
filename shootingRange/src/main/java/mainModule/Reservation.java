package mainModule;

import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import java.time.Duration;

public class Reservation {

    private String id;
    private final LocalDateTime start;
    private final LocalDateTime end;
    GunReservationSet gunReservations;
    Client client;
    Worker worker;

    public Reservation(String id, LocalDateTime start, LocalDateTime end, Client client, Worker worker, GunReservationSet gunReservations) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.gunReservations = gunReservations;
        this.client = client;
        this.worker = worker;
    }

    public double calcPrice() {
        return gunReservations.getTotalCost() + (calcDuration() * worker.getCostPerHour());
    }

    //Duration in Hours
    public double calcDuration() {
        Duration durationHours = Duration.between(start, end);
        return durationHours.toHours();
    }

    public String getId() {
        return id;
    }

    public GunReservationSet getGunReservationSet() {
        return gunReservations;
    }

    public Client getClient() {
        return client;
    }

    public Worker getWorker() {
        return worker;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}
