package sensory;

import manager.Event;
import manager.ManagerEventow;
import manager.ManagerOsob;
import wyswietlanie.Przydzielacz;

import java.sql.SQLException;


public class KameraTermowizyjna implements Sensor {
    int x = 0;
    int y = 0;
    int id = 0;
    private int zdjecie;
    private Double temperatura;
    @Override
    public void wyslij(ManagerEventow managerEventow, int data) throws SQLException {
        Event x = new Event();
        x.setSensor(this);
        x.setData(data);
        x.setDane(new Dane(this.x, this.y, this.zdjecie));
        x.setTemp(this.temperatura);
        managerEventow.dodajEvent(x);
    }
    public void nowaOsobaWKolejce(Przydzielacz przydzielacz, ManagerOsob managerOsob){
        Dane dane = new Dane(this.x, this.y, this.zdjecie);
        dane.setTemperatura(temperatura);
        przydzielacz.pobierzNowaOsobe(dane, managerOsob);
    }

    public int getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(int zdjecie) {
        this.zdjecie = zdjecie;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
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
