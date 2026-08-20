public class MachineData {

    private int machineId;
    private double airTemperature;
    private double processTemperature;
    private double rotationalSpeed;
    private double torque;
    private double toolWear;

    public MachineData(
            int machineId,
            double airTemperature,
            double processTemperature,
            double rotationalSpeed,
            double torque,
            double toolWear) {

        this.machineId = machineId;
        this.airTemperature = airTemperature;
        this.processTemperature = processTemperature;
        this.rotationalSpeed = rotationalSpeed;
        this.torque = torque;
        this.toolWear = toolWear;
    }

    public int getMachineId() {
        return machineId;
    }

    public double getAirTemperature() {
        return airTemperature;
    }

    public double getProcessTemperature() {
        return processTemperature;
    }

    public double getRotationalSpeed() {
        return rotationalSpeed;
    }

    public double getTorque() {
        return torque;
    }

    public double getToolWear() {
        return toolWear;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public void setAirTemperature(double airTemperature) {
        this.airTemperature = airTemperature;
    }

    public void setProcessTemperature(double processTemperature) {
        this.processTemperature = processTemperature;
    }

    public void setRotationalSpeed(double rotationalSpeed) {
        this.rotationalSpeed = rotationalSpeed;
    }

    public void setTorque(double torque) {
        this.torque = torque;
    }

    public void setToolWear(double toolWear) {
        this.toolWear = toolWear;
    }

    public void displayData() {

        System.out.println("Machine ID: " + machineId);
        System.out.println(
                "Air Temperature: " + airTemperature + " K"
        );
        System.out.println(
                "Process Temperature: "
                + processTemperature + " K"
        );
        System.out.println(
                "Rotational Speed: "
                + rotationalSpeed + " rpm"
        );
        System.out.println(
                "Torque: " + torque + " Nm"
        );
        System.out.println(
                "Tool Wear: " + toolWear + " min"
        );
    }
}
