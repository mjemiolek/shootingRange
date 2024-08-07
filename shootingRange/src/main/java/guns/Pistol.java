package guns;

public abstract class Pistol extends Weapon {

    private final static double shotCost = 1.5;
    protected final boolean silencer;

    public Pistol(String serialNumber, boolean silencer) {
        super(serialNumber);
        this.silencer = silencer;
    }

    @Override
    public double getCostPerShot() {
        if(silencer) {
            return shotCost + 0.5;
        } else {
            return shotCost;
        }
    }

    @Override
    public abstract String getInfo();


}
