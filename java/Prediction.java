public class Prediction {

    private MachineData machineData;
    private String result;

    public Prediction(MachineData machineData, String result) {
        this.machineData = machineData;
        this.result = result;
    }

    public MachineData getMachineData() {
        return machineData;
    }

    public String getResult() {
        return result;
    }

    public void displayPrediction() {

        System.out.println();
        System.out.println("----- Prediction Result -----");

        System.out.println("Machine ID: "
                + machineData.getMachineId());

        System.out.println("Prediction: "
                + result);

        System.out.println("-----------------------------");
    }
}
