package guns;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Weapon {

    private final String serialNumber;

    public Weapon(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public abstract double getCostPerShot();

    public abstract String getInfo();

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if(!(obj instanceof Weapon)) {
            return false;
        }
        Weapon weapon = (Weapon)obj;
        return this.serialNumber.equals(weapon.serialNumber);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serialNumber).toHashCode();
    }
}
