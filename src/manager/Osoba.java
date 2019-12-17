package manager;

public class Osoba {
    private int id;
    private String imie;
    private String nazwisko;
    private int wiek;
    private Boolean vip = false;
    private int twarz;
    private int x;
    private int y;
    private Double temperatura;
    private Double predkosc;

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

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }


    public int getTwarz() {
        return twarz;
    }

    public void setTwarz(int twarz) {
        this.twarz = twarz;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getPredkosc() {
        return predkosc;
    }

    public void setPredkosc(Double predkosc) {
        this.predkosc = predkosc;
    }
}
