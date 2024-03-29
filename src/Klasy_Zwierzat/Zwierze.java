package Klasy_Zwierzat;

import Przedmioty.Przedmiot;
import enumy.rodzaj_srodowiska_enum;
import interfejsy.Obserwujacy_ZwierzeWybieg_interface;
import java.io.Serializable;
import  propozycja_gui_package.HealthSubject;
public  class Zwierze extends HealthSubject implements Obserwujacy_ZwierzeWybieg_interface, Serializable, Comparable<Zwierze>{



    //===========================================================================
    //POLA ZWIERZĄT
    //===========================================================================
    private final String imie;
    private final String nazwa;
    private int zycie;
    private int sila;
    private int szybkosc;
    private int szczescie;
    private final int wielkosc;
    private int wskaznik_glodu;
    private int przezyte_dni = 0;
    private final int cena;
    private final rodzaj_srodowiska_enum rodzaj;
    private float mnoznik_pieniedzy=1;


// Gettery i settery





    private Przedmiot przedmiot;

    //===========================================================================
    //KONSTRUKTOR
    //===========================================================================

    public Zwierze(String imie, String nazwa, int zycie, int sila,int szybkosc, int szczescie, int wielkosc, int wskaznik_glodu, int cena,rodzaj_srodowiska_enum rodzaj){
        this.imie=imie;
        this.nazwa = nazwa;
        this.zycie = zycie;
        this.sila = sila;
        this.szybkosc=szybkosc;
        this.szczescie=szczescie;
        this.wielkosc = wielkosc;
        this.wskaznik_glodu = wskaznik_glodu;
        this.cena = cena;
        this.rodzaj=rodzaj;
    }


    //===========================================================================
    //METODY - ZMIANA MNOŻNIKA,KARMIENIE, RELEASE
    //===========================================================================

    //Metoda obserwatora
    public void aktualizuj_oberwujacego(float czystosc) {
        mnoznik_pieniedzy+= (czystosc-70)/10;
    }

    //Metoda na karmienie
    public void karmienie(int jedzenie){
        wskaznik_glodu+=jedzenie;
        if(wskaznik_glodu>100) wskaznik_glodu=100;
    }

    public Zwierze deep_clone() {
        return new Zwierze(getImie(),getNazwa(), getZycie(), getSila(),getSzybkosc(),getSzczescie(), getWielkosc(), getWskaznik_glodu(), getCena(), getRodzaj());
    }
    public void rozpocznij_dzien(){
        wskaznik_glodu = getWskaznik_glodu()-20;

    }


    //===========================================================================
    //TOSTRING WYŚWIETLAJĄCY
    //===========================================================================

    //toString wyswietlajacy info o zwierzeciu
    @Override
    public String toString() {
       if(this.getPrzedmiot()==null) {return "Imie to:" + getImie() +"\n"+
                "Typ to:" + getNazwa() +"\n"+
                "Zycie to: " + getZycie() +"\n"+
                "Sila to: " + getSila() +"\n"+
                "Wielkosc to: " + getWielkosc() +"\n"+
                "Najedzony w " + getWskaznik_glodu() +" procentach\n"+
                "Przezyl " + getPrzezyte_dni() +" dni\n"+
                "Cena to: " + getCena() +"\n"+
                "Rodzaj to: " + getRodzaj() +" \n"+
                "Szybkosc to: " + this.getSzybkosc() +"\n"+
                "Szczescie to: " + this.getSzczescie() +"\n";} else{
           return"Imie to:" + getImie() +"\n"+
                   "Typ to:" + getNazwa() +"\n"+
                   "Zycie to: " + getZycie() +"\n"+
                   "Sila to: " + getSila() +"\n"+
                   "Wielkosc to: " + getWielkosc() +"\n"+
                   "Najedzony w " + getWskaznik_glodu() +" procentach\n"+
                   "Przezyl " + getPrzezyte_dni() +" dni\n"+
                   "Cena to: " + getCena() +"\n"+
                   "Rodzaj to: " + getRodzaj() +" \n"+
                   "Szybkosc to: " + this.getSzybkosc() +"\n"+
                   "Szczescie to: " + this.getSzczescie() +"\n"+
                   this.getPrzedmiot().toString();

       }



    }

    //===========================================================================
    //SETTERY I GETTERY
    //===========================================================================


    public String getImie() {
        return imie;
    }


    public int getSzybkosc() {
        return szybkosc;
    }

    public void setSzybkosc(int szybkosc) {
        this.szybkosc = szybkosc;
    }

    public int getSzczescie() {
        return szczescie;
    }

    public void setSzczescie(int szczescie) {
        this.szczescie = szczescie;
    }


    public String getNazwa() {
        return nazwa;
    }


    public int getZycie() {
        return zycie;
    }

    public void setZycie(int zycie) {
        this.zycie = zycie;
    }

    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public int getWielkosc() {
        return wielkosc;
    }


    public int getWskaznik_glodu() {
        return wskaznik_glodu;
    }


    public int getPrzezyte_dni() {
        return przezyte_dni;
    }

    public void setPrzezyte_dni(int przezyte_dni) {
        this.przezyte_dni = przezyte_dni;
    }

    public int getCena() {
        return cena;
    }


    public rodzaj_srodowiska_enum getRodzaj() {
        return rodzaj;
    }


    public float getMnoznik_pieniedzy() {
        return mnoznik_pieniedzy;
    }



    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }


    @Override
    public int compareTo(Zwierze o) {
        return this.toString().compareTo( o.toString());
    }
    //
}