package interfejsy;

public interface Obserwowany_interface {
    void dodaj_obserwatora( Obserwujacy_ZwierzeWybieg_interface o);
    void usun_obserwatora(Obserwujacy_ZwierzeWybieg_interface o);
    void powiadom_obserwatorow();
}