package mainModule;

import guns.Weapon;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.Period;

public abstract class Person {

    private String id;
    private String name;
    private String surname;
    private String address;

    public Person(String id, String name, String surname, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if(!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person)obj;
        return new EqualsBuilder()
                .append(id, person.id)
                .append(name, person.name)
                .append(surname, person.surname)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(surname)
                .toHashCode();
    }

}
