package sensory;

public class Dane {
    int x;
    int y;
    int zdjecie;
    Double temperatura;

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

    public Dane(int x, int y, int zdjecie) {
        this.x = x;
        this.y = y;
        this.zdjecie = zdjecie;
    }
}
