package task1;

public class MeasurementConversion extends MeasurementFramework {
    private final int id;

    public MeasurementConversion(int id) {
        super();
        this.id = id;
    }

    public void run() {

        while (true) {
            try {
                Measurement measurement = readMeasurementIn();

                if (measurement.getId() == this.id) {
                    double feet = measurement.getMeasurementDouble();
                    double meters = feet / 3.2808;
                    measurement.setMeasurement(Double.doubleToLongBits(meters));
                }

                writeMeasurementOut(measurement);
            } catch (EndOfStreamException e) {
                ClosePorts();
                System.out.print("\n" + this.getName() + "::MeasurementConversion Exiting;");
                break;
            }
        }

    }
}