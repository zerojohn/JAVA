package Chapter2Observer;

import java.util.Observable;
import java.util.Observer;

public class WeatherStation {
    public static void main(String[] args) {

    }
}

class CurrentConditionsDisplay implements Observer{
    Observable observable;
    private float temperature;
    private float humidity;
    @Override
    public void update(Observable o, Object arg) {
          if(o instanceof WeatherData){
              WeatherData weatherData = (WeatherData)o;
              this.temperature = weatherData.getTemperature();
              this.humidity = weatherData.getHumidity();
              display();
          }
    }

    public void display(){
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity.");
    }

    CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }


}

class WeatherData extends Observable{
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){};

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void  setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
