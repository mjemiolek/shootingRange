package tests;

import guns.Beretta;
import guns.Weapon;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WeaponTest {

    String serialNumber1 = "89123kASD01";
    String serialNumber2 = "WAW9321JKL2";
    Weapon gun1 = new Beretta(serialNumber1, true, true);
    Weapon gun12 = new Beretta(serialNumber1, false, false);
    Weapon gun2 = new Beretta(serialNumber2, true, true);
    Weapon gun22 = new Beretta(serialNumber2, false, false);

    @Test
    public void equalsTest() {
        assertTrue(gun1.equals(gun1));
        assertTrue(gun1.equals(gun12));
        assertTrue(gun12.equals(gun1));

        assertFalse(gun1.equals(null));
        assertFalse(gun1.equals(new Object()));

        assertFalse(gun1.equals(gun2));
        assertFalse(gun2.equals(gun1));
    }

    @Test
    public void hashCodeTest() {
        assertTrue(gun1.hashCode() == gun1.hashCode());
        assertTrue(gun1.hashCode() == gun12.hashCode());
        assertTrue(gun1.hashCode() != gun2.hashCode());
    }

}
