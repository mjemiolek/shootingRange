package managers;

import guns.Weapon;
import guns.Pistol;
import guns.Shotgun;
import guns.AssaultRifle;
import guns.SniperRifle;
import repositories.Repository;
import java.util.HashSet;
import java.util.Set;

public class WeaponManager {

    private Repository<Weapon> repository = new Repository<>();

    public int getWeaponsQuantity() {
        return repository.size();
    }

    public void registerNewWeapon(Weapon newWeapon) {
        if(findBySerial(newWeapon.getSerialNumber()) == null) {
            repository.add(newWeapon);
        }
    }

    public void removeBySerial(String serialNumber) {
        Weapon toRemove = findBySerial(serialNumber);
        if (toRemove != null) {
            repository.remove(toRemove);
        }
    }

    public Weapon findBySerial(String serialNumber) {
        for (Weapon weapon : getAllWeapons()) {
            if(weapon.getSerialNumber().equals(serialNumber)) {
                return weapon;
            }
        }
        return null;
    }

    public Set<Weapon> getAllWeapons() {
        return repository.findAll();
    }

    private <E> Set<E> findAllGen() {
        Set<E> found = new HashSet<>();
        for (Weapon weapon : repository.findAll()) {
            if(weapon instanceof Pistol) {
                E casted = (E)weapon;
                found.add(casted);
            }
        }
        return found;
    }

    public Set<Pistol> findAllPistols() {
        return findAllGen();
    }

    public Set<Shotgun> findAllShotguns() {
        return findAllGen();
    }

    public Set<AssaultRifle> findAllAssaultRifle() {
        return findAllGen();
    }

    public Set<SniperRifle> findAllSniperRifles() {
        return findAllGen();
    }

}
