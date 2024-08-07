package guns;

public class Remington extends Shotgun {

    private boolean collimator;

    public Remington(String serialNumber, boolean shotgunAmmoBelt, boolean collimator) {
        super(serialNumber, shotgunAmmoBelt);
        this.collimator = collimator;
    }

    @Override
    public double getCostPerShot() {
        double cost = super.getCostPerShot();
        if(collimator) {
            return cost + 0.5;
        } else {
            return cost;
        }
    }

    @Override
    public String getInfo() {
        String info = "Remington ";
        if(shotgunAmmoBelt) {
            info = info + "ammo belt, ";
        }
        if(collimator) {
            info = info + "collimator";
        }
        return info;
    }

}
