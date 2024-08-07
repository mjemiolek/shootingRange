package guns;

public abstract class Shotgun extends Weapon {

    private final static double shotCost = 3;
    protected boolean shotgunAmmoBelt;

    public Shotgun(String serialNumber, boolean shotgunAmmoBelt) {
        super(serialNumber);
        this.shotgunAmmoBelt = shotgunAmmoBelt;
    }

    @Override
    public abstract String getInfo();

    @Override
    public double getCostPerShot() {
        if(shotgunAmmoBelt) {
            return shotCost + 0.5;
        } else {
            return shotCost;
        }
    }

}
