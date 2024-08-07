package guns;

public class Saiga extends Shotgun {

    private boolean bottomHandle;

    public Saiga(String serialNumber, boolean shotgunAmmoBelt, boolean bottomHandle) {
        super(serialNumber, shotgunAmmoBelt);
        this.bottomHandle = bottomHandle;
    }

    @Override
    public double getCostPerShot() {
        double cost = super.getCostPerShot();
        if(bottomHandle) {
            return cost + 0.5;
        } else {
            return cost;
        }
    }

    @Override
    public String getInfo() {
        String info = "Saiga ";
        if(shotgunAmmoBelt) {
            info = info + "ammo belt, ";
        }
        if(bottomHandle) {
            info = info + "bottom handle";
        }
        return info;
    }

}
