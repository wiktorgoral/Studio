package wyswietlanie;

import manager.Osoba;

public class Wyswietlacz {
    public void wyswietlOsobe(Osoba osoba, int kolejka){
        System.out.println("osoba:"+osoba.getTwarz() +"   id:"+osoba.getId() +"   kolejka:"+kolejka);
    }
}
