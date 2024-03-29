package gui_oknaPopUp;

import Wybieg_package.Wybieg_podstawowy;
import enumy.zwierzeta_enum;
import pakiet_sklep.Sklep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OknoKupZwierze extends JFrame {

    private final Sklep sklep;
    private final Wybieg_podstawowy wybieg;
    private ZwierzeRadioButton wybrany;

    private final JTextField imieTextField;

    private final String [] imiona = {"Fafik", "Puszek", "Leon", "Lolek", "Bolek", "Tysiu", "Misiek", "Pypeć", "Miszor", "Klaus", "Berni", "Gwiazdor", "Król", "Cezar", "Pimpek", "Malec", "Słodziak", "Kluska", "Pikuś", "Rezi", "Gimper", "Multi", "Merghani", "Blowek", "Naruciak", "Vertez", "Pan Śmietanka", "Dremu", "Maniek"};

    JButton kupZwierzeButton;
    public OknoKupZwierze (Sklep sklep, Wybieg_podstawowy wybieg)
    {
        this.sklep = sklep;
        this.wybieg = wybieg;

        JPanel panelMain = new JPanel();
        JPanel panelRadio = new JPanel();
        JLabel text = new JLabel("Wybierz zwierze: ");

        Random gen = new Random();

        imieTextField = new JTextField(imiona[gen.nextInt(imiona.length)]);
        imieTextField.setPreferredSize(new Dimension(200, 30));

        kupZwierzeButton = new JButton("Kup zwierze");
        kupZwierzeButton.setEnabled(false);
        kupZwierzeButton.addActionListener(new ReakcjaKupZwierzeButton());

        ZwierzeRadioButton pingwin = new ZwierzeRadioButton("pingwin", zwierzeta_enum.PINGWIN);
        pingwin.addActionListener(new ReakcjaZwierzeRadioButton());

        ZwierzeRadioButton zolw = new ZwierzeRadioButton("zolw", zwierzeta_enum.ZOLW);
        zolw.addActionListener(new ReakcjaZwierzeRadioButton());

        ZwierzeRadioButton rekin = new ZwierzeRadioButton("rekin", zwierzeta_enum.REKIN);
        rekin.addActionListener(new ReakcjaZwierzeRadioButton());

        ZwierzeRadioButton orka = new ZwierzeRadioButton("orka", zwierzeta_enum.ORKA);
        orka.addActionListener(new ReakcjaZwierzeRadioButton());

        ZwierzeRadioButton niedzwiedz = new ZwierzeRadioButton("niedzwiedz", zwierzeta_enum.NIEDZWIEDZ);
        niedzwiedz.addActionListener(new ReakcjaZwierzeRadioButton());

        ZwierzeRadioButton los = new ZwierzeRadioButton("los", zwierzeta_enum.LOS);
        los.addActionListener(new ReakcjaZwierzeRadioButton());

        ZwierzeRadioButton niedzwiedz_polarny = new ZwierzeRadioButton("niedzwiedz_polarny", zwierzeta_enum.NIEDZWIEDZ_POLARNY);
        niedzwiedz_polarny.addActionListener(new ReakcjaZwierzeRadioButton());

        ZwierzeRadioButton lew = new ZwierzeRadioButton("lew", zwierzeta_enum.LEW);
        lew.addActionListener(new ReakcjaZwierzeRadioButton());

        ZwierzeRadioButton orzel = new ZwierzeRadioButton("orzel", zwierzeta_enum.ORZEL);
        orzel.addActionListener(new ReakcjaZwierzeRadioButton());

        ZwierzeRadioButton papuga = new ZwierzeRadioButton("papuga", zwierzeta_enum.PAPUGA);
        papuga.addActionListener(new ReakcjaZwierzeRadioButton());

        ZwierzeRadioButton paw = new ZwierzeRadioButton("paw", zwierzeta_enum.PAW);
        paw.addActionListener(new ReakcjaZwierzeRadioButton());

        ZwierzeRadioButton nietoperz = new ZwierzeRadioButton("nietoperz", zwierzeta_enum.NIETOPERZ);
        nietoperz.addActionListener(new ReakcjaZwierzeRadioButton());

        ButtonGroup group = new ButtonGroup();

        group.add(pingwin);
        group.add(zolw);
        group.add(rekin);
        group.add(orka);

        group.add(niedzwiedz);
        group.add(los);
        group.add(niedzwiedz_polarny);
        group.add(lew);

        group.add(orzel);
        group.add(papuga);
        group.add(paw);
        group.add(nietoperz);


        this.setTitle("Kup Zwierze");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        kupZwierzeButton.setFocusable(false);

        panelRadio.add(pingwin);
        panelRadio.add(zolw);
        panelRadio.add(rekin);
        panelRadio.add(orka);

        panelRadio.add(niedzwiedz);
        panelRadio.add(los);
        panelRadio.add(niedzwiedz_polarny);
        panelRadio.add(lew);

        panelRadio.add(orzel);
        panelRadio.add(papuga);
        panelRadio.add(paw);
        panelRadio.add(nietoperz);

        panelRadio.setLayout(new GridLayout(3,4));
        panelMain.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.add(panelMain);

        gbc.insets=new Insets(10,10,10,10);

        gbc.gridwidth=3;
        gbc.gridx=0;
        gbc.gridy=0;

        panelMain.add(text, gbc);

        gbc.gridwidth=3;
        gbc.gridx=0;
        gbc.gridy=1;

        panelMain.add(panelRadio, gbc);

        gbc.gridwidth=3;
        gbc.gridx=0;
        gbc.gridy=2;

        panelMain.add(imieTextField, gbc);

        gbc.gridwidth=1;
        gbc.gridx=3;
        gbc.gridy=3;

        panelMain.add(kupZwierzeButton, gbc);

        this.pack();
        this.setVisible(true);
    }

    class ReakcjaZwierzeRadioButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            kupZwierzeButton.setEnabled(true);
            if(!wybieg.czy_zwierze_spelnia_wymogi_dodania_do_wybiegu(((ZwierzeRadioButton)e.getSource()).getTyp().stworzZwierze("")))
            {
                kupZwierzeButton.setEnabled(false);
            }
            wybrany=(ZwierzeRadioButton)e.getSource();
        }
    }

    class ReakcjaKupZwierzeButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            sklep.kup_zwierze(wybrany.getTyp(), wybieg, imieTextField.getText());
            OknoKupZwierze.this.dispose();
        }
    }



    public static void brakSrodkow()
    {
        JOptionPane.showMessageDialog(null,
                "Nie masz wystarczajaco duzo monet!",
                "Brak Srodkow",
                JOptionPane.ERROR_MESSAGE);
    }

}
