package Pracownik_package;
//import Zoo_dzienne.*;
//import Zwierze.*;
import Wybieg_package.*;
import Klasy_Zwierzat.Zwierze;
import pakiet_zasoby.*;


public class Pracownik{

    //INICJOWANIE SKLADOWYCH
    private String imie;
    private String nazwisko;
    private int id;
    private int jakoscUslug; //w skali do 10,
    //wplywa na metody umyjWybieg i nakarmZwierze


    //KONSTRUKTOR
    public Pracownik(String imie, String nazwisko, int id, int jakoscUslug){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
        this.jakoscUslug = jakoscUslug;
    }



    //METODY KLASY

    public void umyjWybieg(Wybieg_podstawowy wybieg){
        int poziomCzystosci = (int) wybieg.getCzystosc();

        poziomCzystosci += getJakoscUslug() * poziomCzystosci;

        if(poziomCzystosci >= 100){ //nie moze przekraczac 100 z zalozenia
            poziomCzystosci = 100;
        }

        wybieg.setCzystosc(poziomCzystosci);

    }

    public void nakarmZwierze(Zwierze zwierze, int jedzenie){
        int poziomGlodu = zwierze.getWskaznik_glodu();
        poziomGlodu += jedzenie * getJakoscUslug();

        zwierze.setWskaznik_glodu(poziomGlodu);
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", id=" + id +
                ", jakoscUslug=" + jakoscUslug +
                '}';
    }


    //GETTERY I SETTERY
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJakoscUslug() {
        return jakoscUslug;
    }

    public void setJakoscUslug(int jakoscUslug) {
        this.jakoscUslug = jakoscUslug;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

}