import javax.swing.*;

public class MenuOkna extends JMenuBar {

    JMenu opcje = new JMenu("Opcje");

    JMenuItem punkty = new JMenuItem("Punkty");
    JMenuItem łamana = new JMenuItem("Lamana");
    JMenuItem bezir = new JMenuItem("Bezir");
    JMenuItem reset = new JMenuItem("Reset");

    public MenuOkna(){

        opcje.add(punkty);

        opcje.add(łamana);

        opcje.add(bezir);

        opcje.add(reset);

        add(opcje);
    }
}
