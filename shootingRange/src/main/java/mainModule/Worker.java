package mainModule;

import guns.Weapon;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class Worker extends Person {

    private final String peselNumber;
    private double costPerHour;

    public Worker(String id, String name, String surname, String address, String peselNumber, double costPerHour) {
        super(id, name, surname, address);
        this.peselNumber = peselNumber;
        this.costPerHour = costPerHour;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if(!(obj instanceof Worker)) {
            return false;
        }
        Worker worker = (Worker)obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(peselNumber, worker.peselNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(peselNumber)
                .toHashCode();
    }

}
