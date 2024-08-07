package tests;

import guns.Beretta;
import guns.Weapon;
import mainModule.GunReservation;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GunReservationTest {

    Weapon gun  = new Beretta("223311", true, true);
    GunReservation reservation = new GunReservation(gun, 7);

    @Test
    public void getCostTest() {
        assertEquals(17.5, reservation.getCost());
    }

}
