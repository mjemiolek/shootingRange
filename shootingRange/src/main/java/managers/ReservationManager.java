package managers;

import mainModule.*;
import repositories.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.time.Period;
import java.time.Duration;

public class ReservationManager {
//do napisania

    private long idCounter = 0;
    private Repository<Reservation> repository = new Repository<>();

    //Czy dodać FiringPost ?
    public boolean addReservation(LocalDateTime start, LocalDateTime end, Client client, Worker worker,
                               GunReservationSet gunReservations) {
        List<Reservation> sameTimeReservations = findByPeriod(start, end);
        for(Reservation existingReservation : sameTimeReservations) {
            //Worker compare
            if(existingReservation.getWorker().equals(worker)) {
                return false;
            }
            //Guns compare
            Set<GunReservation> existingGunReservations = existingReservation.getGunReservationSet().getAllReservations();
            for(GunReservation gunRes : existingGunReservations) {
                for(GunReservation newGunRes : gunReservations.getAllReservations()) {
                    if(gunRes.getWeapon().equals(newGunRes.getWeapon())) {
                        return false;
                    }
                }
            }
            //Client compare
            if(client.equals(existingReservation.getClient())) {
                return false;
            }
        }
        String id = "R" + String.valueOf(idCounter);
        Reservation newReservation = new Reservation(id, start, end, client, worker, gunReservations);
        repository.add(newReservation);
        idCounter++;
        return true;
    }

    public void deleteReservation(String id) {
        Reservation found = findById(id);
        if(found != null) {
            repository.remove(found);
        }
    }

    public List<Reservation> findByPeriod(LocalDateTime start, LocalDateTime end) { //Nowa rezerwacja data
        //check start
        List<Reservation> found = new ArrayList<>(); //to chyba na Set trzeba zamienić
        for(Reservation reservation : repository.findAll()) {
            Duration startStart = Duration.between(start, reservation.getStart());
            Duration startEnd = Duration.between(reservation.getStart(), end);

            Duration endEnd = Duration.between(reservation.getEnd(), end);
            Duration endStart = Duration.between(start, reservation.getEnd());
            boolean startCondition = ( (startStart.toMinutes() >= 0) && (startEnd.toMinutes() > 0) );
            boolean endCondition = ( (endEnd.toMinutes() >= 0) && (endStart.toMinutes() > 0) );
            if( startCondition && endCondition ) { // bez równe CHYBA
                found.add(reservation);
            }
        }
        return found;
    }

    public Set<Reservation> getAllReservations() {
        return repository.findAll();
    }

    public Reservation findById(String id) {
        for(Reservation reservation : repository.findAll()) {
            if(reservation.getId().equals(id)) {
                return reservation;
            }
        }
        return null;
    }

}
