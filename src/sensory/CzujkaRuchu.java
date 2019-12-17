package sensory;

import manager.Event;
import manager.ManagerEventow;

import java.sql.SQLException;

public class CzujkaRuchu implements Sensor{
    int x = 0;
    int y = 0;
    int id = 0;
    @Override
    public void wyslij(ManagerEventow managerEventow, int data) throws SQLException {
        Event x = new Event();
        x.setSensor(this);
        x.setData(data);
        x.setDane(new Dane(this.x, this.y, 0));
        x.setTemp((double) 0);
        managerEventow.dodajEvent(x);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
