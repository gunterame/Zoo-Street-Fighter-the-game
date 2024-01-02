package gui_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DzienneZooPakiet.DzienneZoo;
import interfejsy.ObserwujacyPracownikGUI_interface;
import interfejsy.UpdateGUI;
import pakiet_sklep.Sklep;


public class PanelDzienSklep extends JPanel implements UpdateGUI, ObserwujacyPracownikGUI_interface {
    private JButton kupJedzenie;
    private JButton kupWybieg;
    private JButton kupPracownika;
    private JButton sprzedajJedzenie ;
    private JButton sprzedajPracownika;
    private Sklep sklep;

    private DzienneZoo zoo;
    public PanelDzienSklep(Sklep sklep)
    {
        sklep.dodajObsewatoraGUI(this);

        this.sklep = sklep;
        this.zoo = sklep.getZoo();

        JLabel logosklepu = new JLabel();
        logosklepu.setText("Sklep (tu bedzie grafika)");
        this.setBackground(Color.yellow);
       // this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension( 250, 0));
        kupJedzenie = new JButton("Kup jedzenie");

        kupWybieg = new JButton("Kup Wybieg");
        kupPracownika = new JButton("Kup pracownika");
        sprzedajJedzenie = new JButton("sprzedaj jedzenie");

        sprzedajPracownika = new JButton("sprzedaj Pracownika");

        setsettingsforbutton(kupJedzenie);
        setsettingsforbutton(kupPracownika);
        setsettingsforbutton(kupWybieg);

        setsettingsforbutton(sprzedajJedzenie);
        setsettingsforbutton(sprzedajPracownika);


        kupWybieg.addActionListener(new ReakcjaKupWybieg());
        kupJedzenie.addActionListener(new ReakcjaKupJedzenie());
        kupPracownika.addActionListener(new ReakcjaKupPracownika());
        sprzedajJedzenie.addActionListener(new ReakcjaSprzedajJedzenie());
        sprzedajPracownika.addActionListener(new ReakcjaSprzedajPracownika());

        this.add(logosklepu);
        this.add(kupJedzenie);
        this.add(kupPracownika);
        this.add(kupWybieg);

        this.add(sprzedajJedzenie);
        this.add(sprzedajPracownika);




    }

    public Sklep getSklep() {
        return sklep;
    }

    public void setSklep(Sklep sklep) {
        this.sklep = sklep;
    }

    @Override
    public void reakcjaZaznaczenie() {

        kupJedzenie.setEnabled(false);
        kupPracownika.setEnabled(false);
        kupWybieg.setEnabled(false);
        sprzedajJedzenie.setEnabled(false);
        sprzedajPracownika.setEnabled(false);
    }

    @Override
    public void reakcjaOdznaczenie() {
        kupJedzenie.setEnabled(true);
        kupPracownika.setEnabled(true);
        kupWybieg.setEnabled(true);
        sprzedajJedzenie.setEnabled(true);
        sprzedajPracownika.setEnabled(true);
    }

    class ReakcjaKupWybieg implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            new gui_oknaPopUp.OknoKupWybieg(getSklep());
        }
    }
    class ReakcjaKupJedzenie implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new gui_oknaPopUp.OknoKupJedzenie(getSklep());
        }
    }

    class ReakcjaKupPracownika implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new gui_oknaPopUp.OknoKupPracownika(getSklep());
        }
    }

    class ReakcjaSprzedajJedzenie implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new gui_oknaPopUp.OknoSprzedajJedzenie(getSklep());
        }
    }

    class ReakcjaSprzedajPracownika implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!zoo.getListaPracownikow().isEmpty()) {
                new gui_oknaPopUp.OknoSprzedajPracownika(getSklep());
            }
        }
    }



    public void setsettingsforbutton (JButton button)
    {
        button.setPreferredSize(new Dimension(300,50));
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.TOP);
        button.setFont(new Font("Comic Sans",Font.BOLD,15));

        button.setForeground(Color.BLACK);
        button.setBackground(Color.lightGray);
    }




    @Override
    public void updateGUI() {
        this.repaint();
        this.revalidate();
    }
}
