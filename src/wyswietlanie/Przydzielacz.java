package wyswietlanie;

import manager.ManagerOsob;
import manager.Osoba;
import sensory.Dane;

import java.util.Vector;

public class Przydzielacz {

    Vector<Osoba> osoby = new Vector<>();
    Wyswietlacz wyswietlacz = new Wyswietlacz();
    Vector<Integer> normalneKolejki = new Vector<>();
    Vector<Integer> szybkieKolejki = new Vector<>();
    Vector<Integer> wolneKolejki = new Vector<>();
    Vector<Integer> kolejki = new Vector<>();

    public void przydzielKolejke(Osoba osoba){
        if (osoba.getTemperatura()>36 && osoba.getTemperatura()<38){
            if (osoba.getPredkosc()< 15 && osoba.getPredkosc()> 5) wyswietlOsobe(osoba, 1);
            if (osoba.getPredkosc()< 6) wyswietlOsobe(osoba, 3);
            else wyswietlOsobe(osoba, 2);

        }
        else wyswietlOsobe(osoba, 2);
        osoby.remove(osoba);
    }

    public void pobierzNowaOsobe(Dane dane, ManagerOsob managerOsob){
        Osoba osoba = managerOsob.podajOsobe(dane);
        osoba.setTemperatura(dane.getTemperatura());
        osoby.add(osoba);
    }

    public void dodajOsobe(Osoba osoba){
        osoby.add(osoba);
    }

    public void usunOstatniaOsobe(){
        osoby.removeElementAt(osoby.size()-1);
    }

    public void wyswietlOsobe(Osoba osoba, int kolejka){
        wyswietlacz.wyswietlOsobe(osoba, kolejka);
    }


    public Vector<Osoba> getOsoby() {
        return osoby;
    }

    public void setOsoby(Vector<Osoba> osoby) {
        this.osoby = osoby;
    }

    public Wyswietlacz getWyswietlacz() {
        return wyswietlacz;
    }

    public void setWyswietlacz(Wyswietlacz wyswietlacz) {
        this.wyswietlacz = wyswietlacz;
    }

    public Vector<Integer> getNormalneKolejki() {
        return normalneKolejki;
    }

    public void setNormalneKolejki(Vector<Integer> normalneKolejki) {
        this.normalneKolejki = normalneKolejki;
    }

    public Vector<Integer> getSzybkieKolejki() {
        return szybkieKolejki;
    }

    public void setSzybkieKolejki(Vector<Integer> szybkieKolejki) {
        this.szybkieKolejki = szybkieKolejki;
    }

    public Vector<Integer> getWolneKolejki() {
        return wolneKolejki;
    }

    public void setWolneKolejki(Vector<Integer> wolneKolejki) {
        this.wolneKolejki = wolneKolejki;
    }

    public Vector<Integer> getKolejki() {
        return kolejki;
    }

    public void setKolejki(Vector<Integer> kolejki) {
        this.kolejki = kolejki;
    }
}
