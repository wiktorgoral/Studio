package manager;

import sensory.Sensor;

import java.sql.SQLException;
import java.util.Vector;

public class ManagerEventow {
    private Vector<Event> eventy = new Vector<>();
    private Vector<Sensor> sensory= new Vector<>();
    public ManagerOsob managerOsob= new ManagerOsob();


    public void sprawdzOsobe(Event dane) throws SQLException {
        managerOsob.sprawdzCzyIsnieje(dane);
    }
    public void dodajEvent(Event event) throws SQLException {
        eventy.add(event);
        sprawdzOsobe(event);
    }


    public void usunEvent(Event event){
        eventy.remove(event);
    }

    public Vector<Event> getEventy() {
        return eventy;
    }

    public void setEventy(Vector<Event> eventy) {
        this.eventy = eventy;
    }

    public Vector<Sensor> getSensory() {
        return sensory;
    }

    public void setSensory(Vector<Sensor> sensory) {
        this.sensory = sensory;
    }
}
