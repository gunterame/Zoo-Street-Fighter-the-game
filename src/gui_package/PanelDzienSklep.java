package gui_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui_oknasklepu.*;



public class PanelDzienSklep extends JPanel implements ActionListener {
    private JButton kupJedzenie;
    private JButton kupZwierze;
    private JButton kupWybieg;
    private JButton kupPracownika;
    private JButton sprzedajJedzenie ;
    private JButton sprzedajZwierze;
    private JButton sprzedajWybieg;
    private JButton sprzedajPracownika;
    public PanelDzienSklep()
    {
        JLabel logosklepu = new JLabel();
        logosklepu.setText("Sklep (tu bedzie grafika)");
        this.setBackground(Color.yellow);
       // this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension( 250, 0));
        kupJedzenie = new JButton("Kup jedzenie");
        kupZwierze = new JButton("Kup zwierze");
        kupWybieg = new JButton("Kup Wybieg");
        kupPracownika = new JButton("Kup pracownika");
        sprzedajJedzenie = new JButton("sprzedaj jedzenie");
        sprzedajZwierze = new JButton("sprzedaj Zwierze");
        sprzedajWybieg = new JButton("sprzedaj Wybieg");
        sprzedajPracownika = new JButton("sprzedaj Pracownika");

        setsettingsforbutton(kupJedzenie);
        setsettingsforbutton(kupPracownika);
        setsettingsforbutton(kupWybieg);
        setsettingsforbutton(kupZwierze);
        setsettingsforbutton(sprzedajJedzenie);
        setsettingsforbutton(sprzedajPracownika);
        setsettingsforbutton(sprzedajWybieg);
        setsettingsforbutton(sprzedajZwierze);

        kupZwierze.addActionListener(this);

        this.add(logosklepu);
        this.add(kupJedzenie);
        this.add(kupPracownika);
        this.add(kupWybieg);
        this.add(kupZwierze);
        this.add(sprzedajJedzenie);
        this.add(sprzedajPracownika);
        this.add(sprzedajWybieg);
        this.add(sprzedajZwierze);



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
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==kupZwierze)
        {
            System.out.println("asas");
            new gui_oknasklepu.OknoKupZwierze();
        }
    }
}
