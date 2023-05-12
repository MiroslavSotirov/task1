package task1;

public class RemoveFilter extends MeasurementFramework {
    private final int id;

    public RemoveFilter(int id) {
        super();
        this.id = id;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Measurement measurement = readMeasurementIn();

                if (measurement.getId() != this.id) {
                    writeMeasurementOut(measurement);
                }
            } catch (EndOfStreamException e) {
                ClosePorts();
                System.out.print("\n" + this.getName() + "::RemoveFilter Exiting;");
                break;
            }
        }

    }
}