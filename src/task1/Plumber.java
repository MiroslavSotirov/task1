package task1;

/**
 * ***************************************************************************************************************
 * File:Plumber.java
 * <p/>
 * Description:
 * <p/>
 * This class instatiates and connects all of our Filters to create the output.
 * <p/>
 * ****************************************************************************************************************
 */
public class Plumber {
    public static void main(String argv[]) {

        // instantiate three filters.
        SourceFilter sourceFilter = new SourceFilter("FlightData.dat");
        RemoveFilter removeFilter1 = new RemoveFilter(1);
        RemoveFilter removeFilter3 = new RemoveFilter(3);
        RemoveFilter removeFilter5 = new RemoveFilter(5);
        MeasurementConversion measurementConversion = new MeasurementConversion(2);
        TemperatureConversion temperatureConversion = new TemperatureConversion(4);
        SinkFilter sinkFilter = new SinkFilter(new int[]{0, 4, 2}, "OutputA.dat");

        // connect the filters to each other
        sinkFilter.Connect(temperatureConversion);
        temperatureConversion.Connect(measurementConversion);
        measurementConversion.Connect(removeFilter5);
        removeFilter5.Connect(removeFilter3);
        removeFilter3.Connect(removeFilter1);
        removeFilter1.Connect(sourceFilter);

        // start the filters
        sourceFilter.start();
        removeFilter1.start();
        removeFilter3.start();
        removeFilter5.start();
        measurementConversion.start();
        temperatureConversion.start();
        sinkFilter.start();

    }
}