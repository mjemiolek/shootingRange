package mainModule;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import guns.Weapon;

public class GunReservation {

    private final int shots;
    private final Weapon weapon;

    public GunReservation(Weapon weapon, int shots) {
        this.weapon = weapon;
        this.shots = shots;
    }

    public double getCost() {
        return weapon.getCostPerShot() * shots;
    }

    public int getShots() {
        return shots;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if(!(obj instanceof GunReservation)) {
            return false;
        }
        GunReservation gunReservation = (GunReservation)obj;
        return weapon.equals(gunReservation.getWeapon());
    }

    @Override
    public int hashCode() {
        return weapon.hashCode();
    }

}
