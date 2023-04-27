import javax.swing.*;

public class MenuOkna extends JMenuBar {

    JMenu opcje = new JMenu("Opcje");

    JMenuItem punkty = new JMenuItem("Punkty");
    JMenuItem łamana = new JMenuItem("Lamana");
    JMenuItem bezir = new JMenuItem("Bezir");
    JMenuItem resetPunkty = new JMenuItem("Reset Punktów");

    JMenuItem resetMacierz = new JMenuItem("Reset Macierzy");

    public MenuOkna(){

        opcje.add(punkty);

        opcje.add(łamana);

        opcje.add(bezir);

        opcje.add(resetPunkty);

        opcje.add(resetMacierz);

        add(opcje);
    }
}
