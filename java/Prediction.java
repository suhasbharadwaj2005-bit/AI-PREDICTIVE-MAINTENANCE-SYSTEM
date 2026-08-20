public class Prediction {

    private MachineData machineData;
    private int predictionResult;

    public Prediction(
            MachineData machineData,
            int predictionResult) {

        this.machineData = machineData;
        this.predictionResult = predictionResult;
    }

    public MachineData getMachineData() {
        return machineData;
    }

    public int getPredictionResult() {
        return predictionResult;
    }

    public String getPredictionLabel() {

        if (predictionResult == 1) {
            return "Failure";
        }

        return "No Failure";
    }

    public void displayPrediction() {

        System.out.println(
                "Prediction: " + getPredictionLabel()
        );
    }
}
