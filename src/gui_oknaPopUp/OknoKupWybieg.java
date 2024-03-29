package gui_oknaPopUp;

import pakiet_sklep.Sklep;
import enumy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoKupWybieg extends JFrame implements ActionListener {
    private final Sklep sklepik;
    private final JButton kupButton;
    private final JRadioButton powietrznyButton;
    private final JRadioButton wodnyButton ;
    private final JRadioButton ladowyButton;
    private final JRadioButton malyButton;
    private final JRadioButton sredniButton;
    private final JRadioButton duzyButton;
    private wielkosc_wybiegu_enum wielkosc;
    private rodzaj_srodowiska_enum rodzaj;
    private final JLabel buttonLabel;

    public OknoKupWybieg(Sklep sklep) {
        this.sklepik = sklep;

        this.setTitle("Kup Wybieg");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLayout(new GridLayout(0,1));

        JLabel text = new JLabel("    Wybierz rodzaj i wielkość wybiegu:");
        this.add(text);

        // Radio buttons dla rodzaju wybiegu
        JPanel rodzajPanel = new JPanel();
        ButtonGroup rodzajWybieguGroup = new ButtonGroup();
        powietrznyButton = new JRadioButton("POWIETRZNY");
         wodnyButton = new JRadioButton("WODNY");
         ladowyButton = new JRadioButton("LĄDOWY");
        rodzajWybieguGroup.add(powietrznyButton);
        rodzajWybieguGroup.add(wodnyButton);
        rodzajWybieguGroup.add(ladowyButton);
        rodzajPanel.add(powietrznyButton);
        rodzajPanel.add(wodnyButton);
        rodzajPanel.add(ladowyButton);
        this.add(rodzajPanel);

        // Radio buttons dla wielkości wybiegu
        JPanel wielkoscPanel = new JPanel();
        ButtonGroup wielkoscWybieguGroup = new ButtonGroup();
         malyButton = new JRadioButton("MAŁY");
         sredniButton = new JRadioButton("ŚREDNI");
         duzyButton = new JRadioButton("DUŻY");
        wielkoscWybieguGroup.add(malyButton);
        wielkoscWybieguGroup.add(sredniButton);
        wielkoscWybieguGroup.add(duzyButton);
        wielkoscPanel.add(malyButton);
        wielkoscPanel.add(sredniButton);
        wielkoscPanel.add(duzyButton);
        this.add(wielkoscPanel);


        kupButton = new JButton("Kup wybieg");
        buttonLabel = new JLabel();
        buttonLabel.setFont(new Font(null, Font.PLAIN, 24));
        buttonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(buttonLabel);

        kupButton.addActionListener(this);
        malyButton.addActionListener(this);
        sredniButton.addActionListener(this);
        duzyButton.addActionListener(this);
        wodnyButton.addActionListener(this);
        powietrznyButton.addActionListener(this);
        ladowyButton.addActionListener(this);
        this.add(kupButton);

        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==malyButton)
        {
            wielkosc = wielkosc_wybiegu_enum.MALY;
            updateKoszt();
        }
        if(e.getSource()==sredniButton)
        {
            wielkosc = wielkosc_wybiegu_enum.SREDNI;
            updateKoszt();
        }if(e.getSource()==duzyButton)
        {
            wielkosc = wielkosc_wybiegu_enum.DUZY;
            updateKoszt();
        }
        if(e.getSource()==powietrznyButton)
        {
            rodzaj= rodzaj_srodowiska_enum.POWIETRZNY;
        } if(e.getSource()==ladowyButton)
        {
             rodzaj = rodzaj_srodowiska_enum.LADOWY;
        } if(e.getSource()==wodnyButton)
        {
            rodzaj= rodzaj_srodowiska_enum.WODNY;
            System.out.println(rodzaj);
        }
        if(e.getSource()==kupButton)
        {
            if(rodzaj==null || wielkosc==null) JOptionPane.showMessageDialog(OknoKupWybieg.this,
                    "Wybierz prosze wszystkie opcje :*",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE);
            else
                sklepik.kup_wybieg(rodzaj, wielkosc);
        }
    }

    public void updateKoszt()
    {
        if(wielkosc!=null)
        {
            buttonLabel.setIcon(new ImageIcon("src/ikony/IkonaMonety.png"));
            buttonLabel.setText("" + wielkosc.getLiczbowa_Cena_Wybiegu());
        }
        else buttonLabel.setText("Podaj wielkosc wybiegu");
        this.pack();
    }
    public static void brakSrodkow()
    {
        JOptionPane.showMessageDialog(null,
                "Nie masz wystarczajaco duzo monet!",
                "Brak Srodkow",
                JOptionPane.ERROR_MESSAGE);
    }
}