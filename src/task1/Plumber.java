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
        RemoveFilter deleteFilter1 = new RemoveFilter(1);
        RemoveFilter deleteFilter3 = new RemoveFilter(3);
        RemoveFilter deleteFilter5 = new RemoveFilter(5);
        FeetToMeterFilter feetToMeterFilter = new FeetToMeterFilter(2);
        TemperatureConversion temperatureConversion = new TemperatureConversion(4);
        SinkFilter sinkFilter = new SinkFilter(new int[]{0, 4, 2}, "OutputA.dat");

        // connect the filters to each other
        sinkFilter.Connect(temperatureConversion);
        temperatureConversion.Connect(feetToMeterFilter);
        feetToMeterFilter.Connect(deleteFilter5);
        deleteFilter5.Connect(deleteFilter3);
        deleteFilter3.Connect(deleteFilter1);
        deleteFilter1.Connect(sourceFilter);

        // start the filters
        sourceFilter.start();
        deleteFilter1.start();
        deleteFilter3.start();
        deleteFilter5.start();
        feetToMeterFilter.start();
        temperatureConversion.start();
        sinkFilter.start();

    }
}