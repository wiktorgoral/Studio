import manager.ManagerEventow;
import manager.ManagerOsob;
import manager.Osoba;
import sensory.CzujkaRuchu;
import sensory.Kamera;
import sensory.KameraTermowizyjna;
import sensory.Sensor;
import wyswietlanie.Przydzielacz;
import wyswietlanie.Wyswietlacz;


import java.sql.SQLException;
import java.util.Random;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws SQLException {
        ManagerOsob managerOsob = new ManagerOsob();
        ManagerEventow managerEventow = new ManagerEventow();
        managerEventow.managerOsob = managerOsob;
        Przydzielacz przydzielacz = new Przydzielacz();
        Wyswietlacz wyswietlacz = new Wyswietlacz();
        Vector<OsobaWrap> osoby = new Vector<>();


        Vector<Integer> norm = new Vector<>();
        norm.addElement(1);
        norm.addElement(2);
        norm.addElement(3);
        przydzielacz.setNormalneKolejki(norm);
        norm.removeAllElements();
        norm.addElement(4);
        przydzielacz.setWolneKolejki(norm);
        norm.removeAllElements();
        norm.addElement(5);
        przydzielacz.setSzybkieKolejki(norm);
        norm.addElement(1);
        norm.addElement(2);
        norm.addElement(3);
        norm.addElement(4);
        przydzielacz.setKolejki(norm);


        przydzielacz.setWyswietlacz(wyswietlacz);
        int idCounter = 1;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                Vector<Sensor> sensors = managerEventow.getSensory();
                CzujkaRuchu sensor = new CzujkaRuchu();
                sensor.setId(idCounter++);
                sensor.setX(i * 5);
                sensor.setY(j * 5);
                sensors.add(sensor);
                Kamera sensor1 = new Kamera();
                sensor1.setX(i * 5);
                sensor1.setY(j * 5);
                sensor1.setId(idCounter++);
                sensors.add(sensor1);
                managerEventow.setSensory(sensors);
            }
        }
        Vector<Sensor> sensors = managerEventow.getSensory();
        KameraTermowizyjna kameraTermowizyjna = new KameraTermowizyjna();
        kameraTermowizyjna.setX(490);
        kameraTermowizyjna.setY(490);
        kameraTermowizyjna.setId(888888);
        kameraTermowizyjna.setId(idCounter);
        sensors.add(kameraTermowizyjna);
        managerEventow.setSensory(sensors);


        Vector<int[]> punkty = new Vector<>();

        punkty.addElement(new int[]{100, 100});
        punkty.addElement(new int[]{100, 200});
        punkty.addElement(new int[]{200, 100});
        punkty.addElement(new int[]{400, 200});
        punkty.addElement(new int[]{300, 100});
        punkty.addElement(new int[]{490, 490});

        int counter = 1;
        while (true) {
            if ((counter % 5) == 1) {
                OsobaWrap osoba = new OsobaWrap();
                Random rd = new Random();
                osoba.setTwarz(counter);
                int k = rd.nextInt(5) + 1;
                for (int i = 0; i < k; i++) {
                    osoba.droga.addElement(punkty.elementAt(rd.nextInt(5)));
                }
                osoba.droga.addElement(punkty.elementAt(5));
                osoba.setId(counter);
                osoby.addElement(osoba);
            }
            for (int i = 0; i < osoby.size(); i++) {
                OsobaWrap osoba = osoby.elementAt(i);
                int x = osoba.aktualnyX;
                int y = osoba.aktualnyY;
                if (x != osoba.droga.elementAt(0)[0]) {
                    int ileDodac = osoba.testPredkosc;
                    if (Math.abs(x - osoba.droga.elementAt(0)[0]) < osoba.testPredkosc)
                        ileDodac = Math.abs(x - osoba.droga.elementAt(0)[0]);
                    if (x > osoba.droga.elementAt(0)[0]) osoba.aktualnyX -= ileDodac;
                    else osoba.aktualnyX += ileDodac;
                    for (int j = 0; j < ileDodac / 5  ; j++) {

                        Kamera kamera = (Kamera) sensors.elementAt(((((x / 5)+j) + (y / 5) * 100)) * 2 + 1);
                        kamera.setZdjecie(osoba.getTwarz());
                        sensors.elementAt(((((x / 5)+j) + (y / 5) * 100)) * 2 + 1).wyslij(managerEventow, counter);
                        sensors.elementAt(((((x / 5)+j) + (y / 5) * 100)) * 2).wyslij(managerEventow, counter);
                    }
                    continue;
                }
                if (y != osoba.droga.elementAt(0)[1]) {
                    int ileDodac = osoba.testPredkosc;
                    if (Math.abs(y - osoba.droga.elementAt(0)[1]) < osoba.testPredkosc)
                        ileDodac = Math.abs(y - osoba.droga.elementAt(0)[1]);
                    if (y > osoba.droga.elementAt(0)[1]) osoba.aktualnyY -= ileDodac;
                    else osoba.aktualnyY += ileDodac;

                    for (int j = 1; j < ileDodac / 5 + 1; j++) {

                        Kamera kamera = (Kamera) sensors.elementAt((((x / 5) + ((y / 5)+j) * 100)) * 2 + 1);
                        kamera.setZdjecie(osoba.getTwarz());
                        sensors.elementAt((((x / 5) + ((y / 5)+j) * 100)) * 2 + 1).wyslij(managerEventow, counter);
                        sensors.elementAt((((x / 5) + ((y / 5)+j) * 100)) * 2).wyslij(managerEventow, counter);

                    }
                    continue;
                }
                if (x == osoba.droga.elementAt(0)[0] && y == osoba.droga.elementAt(0)[1] && osoba.droga.size() > 1) {
                    osoba.droga.removeElementAt(0);
                }
                if (x == osoba.droga.elementAt(0)[0] && y == osoba.droga.elementAt(0)[1] && osoba.droga.size() == 1) {
                    Random rd = new Random();
                    kameraTermowizyjna.setTemperatura(osoba.testTemp);
                    kameraTermowizyjna.setZdjecie(osoba.getTwarz());
                    kameraTermowizyjna.nowaOsobaWKolejce(przydzielacz, managerOsob);
                    osoby.remove(osoba);
                }
            }
            for (int i = 0; i < przydzielacz.getOsoby().size(); i++) {
                Osoba osoba = przydzielacz.getOsoby().elementAt(i);
                przydzielacz.przydzielKolejke(osoba);

            }
            System.out.println("Czas: " + counter);
            System.out.println("Aktualny ilosc wykrytych eventow: " + managerEventow.getEventy().size());
            System.out.println("Aktualny stan wykrytych ludzi: " + managerOsob.getOsoby().size());
            System.out.println("----------------------------------------------------------------");

            counter++;
        }
    }
}
