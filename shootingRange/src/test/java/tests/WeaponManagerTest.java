package tests;

import static org.junit.jupiter.api.Assertions.*;

import guns.*;
import managers.WeaponManager;
import org.junit.jupiter.api.Test;
import java.util.Set;

public class WeaponManagerTest {

    String serialNumber1 = "9812LKJ123A";
    String serialNumber2 = "POQ123Kl0oa";
    Weapon gun = new Beretta(serialNumber1, true, true);
    Weapon gunSame = new Beretta(serialNumber1, false, false);
    Weapon gunDiff = new Beretta(serialNumber2, true, true);

    @Test
    public void addTest() {
        WeaponManager manager = new WeaponManager();
        assertTrue(manager.getWeaponsQuantity() == 0);

        manager.registerNewWeapon(gun);
        assertTrue(manager.getWeaponsQuantity() == 1);

        manager.registerNewWeapon(gun);
        assertTrue(manager.getWeaponsQuantity() == 1);

        manager.registerNewWeapon(gunSame);
        assertTrue(manager.getWeaponsQuantity() == 1);

        manager.registerNewWeapon(gunDiff);
        assertTrue(manager.getWeaponsQuantity() == 2);
    }

    @Test
    public void findBySerialTest() {
        WeaponManager manager = new WeaponManager();
        manager.registerNewWeapon(gun);
        manager.registerNewWeapon(gunDiff);

        Weapon gunFound1 = manager.findBySerial(serialNumber1);
        assertTrue(gun == gunFound1);
        assertTrue(gun.equals(gunFound1));

        Weapon gunFound2 = manager.findBySerial(serialNumber2);
        assertTrue(gunDiff == gunFound2);
        assertTrue(gunDiff.equals(gunFound2));
    }

    @Test
    public void findAllPistolsTest() {
        Weapon pistol1 = new Beretta("Beretta", true, true);
        Weapon pistol2 = new Colt("Colt", false, true);
        Weapon rifle1 = new Kalashnikov("Kalashnikov", true, false);
        Weapon rifle2 = new AR15("AR15", false, true);
        Weapon shotgun = new Remington("Remington", true, true);
        WeaponManager manager = new WeaponManager();
        manager.registerNewWeapon(pistol1);
        manager.registerNewWeapon(pistol2);
        manager.registerNewWeapon(rifle1);
        manager.registerNewWeapon(rifle2);
        manager.registerNewWeapon(shotgun);
        assertTrue(manager.getWeaponsQuantity() == 5);
        Set<Pistol> fundPistols = manager.findAllPistols();
        assertTrue(fundPistols.size() == 2);
        boolean pistol1Flag = false;
        boolean pistol2Flag = false;
        for (Weapon pistol : fundPistols) {
            if( (pistol == pistol1) && pistol.getSerialNumber().equals("Beretta") ) {
                pistol1Flag = true;
            } else if( (pistol == pistol2) && pistol.getSerialNumber().equals("Colt") ) {
                pistol2Flag = true;
            }
        }
        assertTrue(pistol1Flag);
        assertTrue(pistol2Flag);
    }

}
