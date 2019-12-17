package manager;

import sensory.Dane;

import java.sql.*;
import java.util.Properties;
import java.util.Vector;

import static java.lang.StrictMath.sqrt;

public class ManagerOsob {
    Vector<Osoba> osoby = new Vector<>();
    int counter  = 1;

    public int sprawdzBaza(Dane dane) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "Wojownik1");
        Connection conn = DriverManager.getConnection(url, props);
        Statement statement = conn.createStatement(   ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.uzytkownicy");
        while (resultSet.next()) {
            if (resultSet.getInt("twarz") == dane.getZdjecie()) {
                int x = resultSet.getInt("id");
                resultSet.close();
                statement.close();
                conn.close();
                return x;
            }
        }
        resultSet.close();
        statement.close();
        conn.close();
        return -1;
    }

    public Osoba podajOsobe(Dane dane) {
        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.elementAt(i).getTwarz() == dane.getZdjecie()) {
                Osoba osoba = osoby.elementAt(i);
                osoba.setX(490);
                osoba.setY(490);
                osoby.remove(osoba);
                return osoba;
            }
        }
        return null;
    }

    public void sprawdzCzyIsnieje(Event event) throws SQLException {
        Dane dane = event.getDane();
        for (int i = 0; i < osoby.size(); i++) {
            if (dane.getZdjecie() > 0 && dane.getZdjecie() == osoby.elementAt(i).getTwarz()) {
                int x = osoby.elementAt(i).getX();
                int y = osoby.elementAt(i).getY();
                osoby.elementAt(i).setX(dane.getX());
                osoby.elementAt(i).setY(dane.getY());
                x = x - osoby.elementAt(i).getX();
                y = y - osoby.elementAt(i).getY();
                osoby.elementAt(i).setPredkosc(sqrt(x * x - y * y));
                return;
            } else if (dane.getZdjecie() == 0) {
                if (osoby.elementAt(i).getX()+6 >dane.getX() && osoby.elementAt(i).getX()-6<dane.getX()) {
                    if (osoby.elementAt(i).getY() + 6 > dane.getY() && osoby.elementAt(i).getY() - 6 < dane.getY()) {
                        int x = osoby.elementAt(i).getX();
                        int y = osoby.elementAt(i).getY();
                        osoby.elementAt(i).setX(dane.getX());
                        osoby.elementAt(i).setY(dane.getY());
                        x = x - osoby.elementAt(i).getX();
                        y = y - osoby.elementAt(i).getY();
                        osoby.elementAt(i).setPredkosc(sqrt(x * x - y * y));
                        return;
                    }
                }
            }
        }
        int idBaza = sprawdzBaza(dane);
        if (idBaza == 0) {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "Wojownik1");
            Connection conn = DriverManager.getConnection(url, props);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM public.uzytkownicy where id = %s", Integer.toString(idBaza)));
            Osoba osoba = new Osoba();
            resultSet.first();
            osoba.setId(counter);
            counter++;
            osoba.setWiek(resultSet.getInt("wiek"));
            osoba.setVip(resultSet.getBoolean("vip"));
            osoba.setTwarz(resultSet.getInt("twarz"));
            osoba.setX(dane.getX());
            osoba.setY(dane.getY());
            osoba.setImie(resultSet.getString("imie"));
            osoba.setNazwisko(resultSet.getString("nazwisko"));
            osoby.add(osoba);

            return;

        } else {
            Osoba osoba = new Osoba();
            osoba.setX(dane.getX());
            osoba.setY(dane.getY());
            osoba.setId(counter);
            counter++;
            if (dane.getZdjecie() != 0) {
                osoba.setTwarz(dane.getZdjecie());
            }
            osoby.add(osoba);
            return;
        }
    }

    public void dodajOsobe(Dane dane) {
        Osoba osoba = new Osoba();
        osoba.setX(dane.getX());
        osoba.setY(dane.getY());
        osoba.setTwarz(dane.getZdjecie());
    }

    public void usunOsobe(int id) {
        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.elementAt(i).getId() == id) {
                osoby.remove(i);
            }
        }
    }

    public Vector<Osoba> getOsoby() {
        return osoby;
    }

    public void setOsoby(Vector<Osoba> osoby) {
        this.osoby = osoby;
    }
}
