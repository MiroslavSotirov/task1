package task1;

public class TemperatureConversion extends MeasurementFramework {
    private final int id;

    public TemperatureConversion(int id) {
        super();
        this.id = id;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Measurement measurement = readMeasurementIn();

                if (measurement.getId() == this.id) {
                    double fahrenheit = measurement.getMeasurementDouble();
                    double celsius = ((fahrenheit - 32) * (5 / 9.0));
                    measurement.setMeasurement(Double.doubleToLongBits(celsius));
                }

                writeMeasurementOut(measurement);
            } catch (EndOfStreamException e) {
                ClosePorts();
                System.out.print("\n" + this.getName() + "::TemperatureConversion Exiting;");
                break;
            }
        }

    }
}