package guns;

public class AR15 extends AssaultRifle {

    private boolean opticalSight;

    public AR15(String serialNumber, boolean silencer, boolean opticalSight) {
        super(serialNumber, silencer);
        this.opticalSight = opticalSight;
    }

    @Override
    public double getCostPerShot() {
        double cost = super.getCostPerShot();
        if(opticalSight) {
            return cost + 0.5;
        } else {
            return cost;
        }
    }

    @Override
    public String getInfo() {
        String info = "AR15 ";
        if(silencer) {
            info = info + "silencer, ";
        }
        if(opticalSight) {
            info = info + "optical sight";
        }
        return info;
    }

}
