package mainModule;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class GunReservationSet {

    private Set<GunReservation> gunsReservations = new HashSet<>();

    public GunReservationSet() {
    }

    public boolean addGunReservation(GunReservation newReservation) {
        return gunsReservations.add(newReservation);
    }

    public double getTotalCost() {
        double totalCost = 0;
        for(GunReservation reservation : gunsReservations) {
            totalCost += reservation.getCost();
        }
        return totalCost;
    }
    //może getAllWeapons, getWeapon, getGunReservation

    public Set<GunReservation> getAllReservations() {
        return gunsReservations;
    }

//    public Set<GunReservation> getAllWeapons
    
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        }
//        if(!(obj instanceof GunReservation)) {
//            return false;
//        }
//        GunReservationSet gunReservationSet = (GunReservationSet)obj;
//
//        for(GunReservation thisGun : gunsReservations) {
//            for(GunReservation thatGun : gunReservationSet.gunsReservations) {
//                if(thisGun.equals(thatGun)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return weapon.hashCode();
//    }

}
