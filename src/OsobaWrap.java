import manager.Osoba;

import java.util.Random;
import java.util.Vector;

public class OsobaWrap extends Osoba {
    Random rd = new Random();
    Double testTemp = 34 + rd.nextDouble() * 6;
    int testPredkosc = (rd.nextInt(4) +1) * 5;
    Vector<int[]> droga = new Vector<>();
    int aktualnyX=0;
    int aktualnyY = 0;



    public Double getTestTemp() {
        return testTemp;
    }

    public void setTestTemp(Double testTemp) {
        this.testTemp = testTemp;
    }

    public int getTestPredkosc() {
        return testPredkosc;
    }

    public void setTestPredkosc(int testPredkosc) {
        this.testPredkosc = testPredkosc;
    }

    public Vector<int[]> getDroga() {
        return droga;
    }

    public void setDroga(Vector<int[]> droga) {
        this.droga = droga;
    }
}
