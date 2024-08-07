package repositories;

import mainModule.Reservation;

public class ReservationRepository extends Repository<Reservation> {

    public Reservation findById(String id) {
        for(Reservation reservation : repository) {
            if(reservation.getId().equals(id)) {
                return reservation;
            }
        }
        return null;
    }

}
