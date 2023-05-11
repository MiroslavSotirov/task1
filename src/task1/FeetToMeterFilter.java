package task1;

/**
 * ***************************************************************************************************************
 * File:FeetToMeterFilter.java
 * <p/>
 * Description:
 * <p/>
 * Converts the Measurement with the given Id from feet to meters.
 * The conversion rate we use is: 3.2808 Feet to 1 Meter
 * <p/>
 * ****************************************************************************************************************
 */

public class FeetToMeterFilter extends MeasurementFramework {
    private final int id;

    /**
     * Instantiates a new FeetToMeterFilter object.
     *
     * @param id to remove
     */
    public FeetToMeterFilter(int id) {
        super();
        this.id = id;
    }

    /**
     * Converts the Measurement with the given Id from feet to meters.
     */
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
                System.out.print("\n" + this.getName() + "::FeetToMeter Exiting;");
                break;
            }
        }

    }
}