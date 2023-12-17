package Wybieg_package;

import pomocnicze.zwierzeta;
import pomocnicze.Obserwujacy_interface;

import java.util.ArrayList;
import java.util.List;

public class Wybieg implements Obserwowany_interface {



    //==========================================================================
    //                              zmienne
    //--------------------------------------------------------------------------

    private List<Obserwujacy_interface> Obserwujacy = new ArrayList<>();
    private int wole_miejsce_w_wybiegu;
    private List<zwierzeta> lista_zwierzat =
            new ArrayList<>();
    private rodzaj_wybiegu_enum rodzaj_wybiegu;
    private wielkosc_wybiegu_enum wielkosc_wybiegu;
    private float czystosc = 100;       //od 0 do 100
    private float jedzenie = 100;
    private float cena;
    private float czas_sprzatania;
    //=================================================================================




    //===================================================================================
    //                          konstruktory
    //-----------------------------------------------------------------------------------
    public Wybieg( rodzaj_wybiegu_enum rodzaj_wybiegu, wielkosc_wybiegu_enum wielkosc_wybiegu) {
        this.rodzaj_wybiegu = rodzaj_wybiegu;
        this.wielkosc_wybiegu = wielkosc_wybiegu;
        this.wole_miejsce_w_wybiegu = wielkosc_wybiegu.getLiczbowa_Wielkosc_Wybiegu();
        this.cena = wielkosc_wybiegu.getLiczbowa_Wielkosc_Wybiegu()*10;
        this.czas_sprzatania = wielkosc_wybiegu.getLiczbowa_Wielkosc_Wybiegu()*2;
    }

    //=====================================================================================


    //=============================================================================
    //                          dodawanie i usuwanie zwierzecia do wybieg
    //---------------------------------------------------------------------------------------

    public <T extends zwierzeta> void dodaj_zwierze(T obiekt){
        if (czy_zwierze_spelnia_wymogi_dodania_do_wybiegu(obiekt)){
            lista_zwierzat.add(obiekt);
            setWole_miejsce_w_wybiegu( getWole_miejsce_w_wybiegu() - obiekt.getWielkosc() );
            System.out.println("dodano zwierze do wybiegu");
        }
        else System.out.println(" nie udalo sie dodac zwierzecia");
    }

    public  <T extends zwierzeta> void usun_zwierze(T obiekt){
        if (lista_zwierzat.contains(obiekt)){
            lista_zwierzat.remove(obiekt);
            setWole_miejsce_w_wybiegu( getWole_miejsce_w_wybiegu() + obiekt.getWielkosc() );
            System.out.println("usunieto zwierze");
        }
        System.out.println("nie udalo sie usunac zwierzecia");
    }



    //funkcje majace na celu sprawdzenie czy zwierze spelnia wymogi dodania
    //---------------------------------------------------------------------------------

    public  boolean czy_zwierze_spelnia_wymogi_dodania_do_wybiegu(zwierzeta obiekt){
        return czy_wybieg_ma_ten_rodzaj_zwierzecia(obiekt) &&
                czy_zwierze_zmiesci_sie(obiekt) &&
                czy_zwierze_ma_dobry_typ(obiekt);
    }

    public  boolean czy_wybieg_ma_ten_rodzaj_zwierzecia(zwierzeta obiekt){
        if (!lista_zwierzat.isEmpty()){
            return obiekt.getClass().getName() == getRodzaj_zwierzecia_w_wybiegu();
        }
        return true;
    }

    public boolean czy_zwierze_zmiesci_sie(zwierzeta obiekt){
        return (getWole_miejsce_w_wybiegu() - obiekt.getWielkosc())>=0;
    }
    public boolean czy_zwierze_ma_dobry_typ(zwierzeta obiekt){
        return getRodzaj_wybiegu() == obiekt.getRodzaj_zwierzecia();
    }
    //---------------------------------------------------------------------------------------
    //========================================================================================






    //========================================================================================
    //                      metody zwiazane z wlasnosciami zwierzat
    //-------------------------------------------------------------------------------------
    public float przychody_z_wybiegu(){
        int przychod = 0;
        for (zwierzeta obiekt : lista_zwierzat){
            przychod+=obiekt.getMnoznik_pieniedzy()*10;
        }
        return przychod;
    }
    //=========================================================================================




    //========================================================================================
    //                                  release
    //-------------------------------------------------------------------------------------
    public void release(){
        Obserwujacy.clear();

    }




    //=================================================================================
    //                      metody zwiazanie z obserwowaniem zwierzat
    //---------------------------------------------------------------------------------------
    @Override
    public void dodaj_obserwatora(Obserwujacy_interface o) {
        Obserwujacy.add(o);
    }

    @Override
    public void usun_obserwatora(Obserwujacy_interface o) {
        if (Obserwujacy.contains(o))
            Obserwujacy.remove(o);
    }

    @Override
    public void powiadom_obserwatorow() {
        for(Obserwujacy_interface o : Obserwujacy){
            o.aktualizuj_oberwujacego(getCzystosc(),getJedzenie());
        }
    }


    //===============================================================================





    //======================================================================================
    //                                  gettery i settery oraz toString
    //-------------------------------------------------------------------------------------
    public String  toString(){
        String status =  "Wybieg " + getRodzaj_wybiegu().toString() + " \n" +
                getWielkosc_wybiegu().toString() + " \n" +
                "dla : " + getRodzaj_zwierzecia_w_wybiegu() + " \n" +
                "czystosc: " + getCzystosc() + " \n" +
                "jedzenie: " + getJedzenie() + " \n" +
                "ilosc wolnego miejsca: " + getWole_miejsce_w_wybiegu() + " \n" +
                "Zwierzeta w tym wybiegu : \n";
        for (zwierzeta obiekt : lista_zwierzat)
            status+= obiekt.toString() + " \n";

        return status;
    }

    public List<Obserwujacy_interface> getObserwujacy() {
        return Obserwujacy;
    }

    public void setObserwujacy(List<Obserwujacy_interface> Obserwujacy) {
        this.Obserwujacy = Obserwujacy;
    }

    public int getWole_miejsce_w_wybiegu() {
        return wole_miejsce_w_wybiegu;
    }

    public void setWole_miejsce_w_wybiegu(int wole_miejsce_w_wybiegu) {
        this.wole_miejsce_w_wybiegu = wole_miejsce_w_wybiegu;
    }

    public List<zwierzeta> getLista_zwierzat() {
        return lista_zwierzat;
    }

    public void setLista_zwierzat(List<zwierzeta> lista_zwierzat) {
        this.lista_zwierzat = lista_zwierzat;
    }

    public rodzaj_wybiegu_enum getRodzaj_wybiegu() {
        return rodzaj_wybiegu;
    }

    public void setRodzaj_wybiegu(rodzaj_wybiegu_enum rodzaj_wybiegu) {
        this.rodzaj_wybiegu = rodzaj_wybiegu;
    }

    public wielkosc_wybiegu_enum getWielkosc_wybiegu() {
        return wielkosc_wybiegu;
    }

    public void setWielkosc_wybiegu(wielkosc_wybiegu_enum wielkosc_wybiegu) {
        this.wielkosc_wybiegu = wielkosc_wybiegu;
    }

    public float getCzystosc() {
        return czystosc;
    }

    public void setCzystosc(float czystosc) {
        this.czystosc = czystosc;
    }

    public float getJedzenie() {
        return jedzenie;
    }

    public void setJedzenie(float jedzenie) {
        this.jedzenie = jedzenie;
    }

    //specjalny getter
    //--------------------------------------------------------------
    public String getRodzaj_zwierzecia_w_wybiegu(){
        if (!getLista_zwierzat().isEmpty())
            return getLista_zwierzat().get(0).getClass().getName();
        return null;
    }
    //===================================================================================
}