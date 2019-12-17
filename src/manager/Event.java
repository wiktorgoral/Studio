package manager;

import sensory.Dane;
import sensory.Sensor;


public class Event {
    private int data;
    private Sensor sensor;
    private Dane dane;
    private Double temp;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Dane getDane() {
        return dane;
    }

    public void setDane(Dane dane) {
        this.dane = dane;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
