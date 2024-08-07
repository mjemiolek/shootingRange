package guns;

public abstract class AssaultRifle extends Weapon {

    private final static double shotCost = 5;
    protected boolean silencer;

    public AssaultRifle(String serialNumber, boolean silencer) {
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
