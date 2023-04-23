import javax.swing.*;
import java.awt.*;

public class Punkty extends JPanel {

    public Point points[];
    public Punkty(){
        setPreferredSize(new Dimension(500,500));
        setMaximumSize(new Dimension(500,500));
        Point p[] = new Point[3];
        JList list = new JList(p);
    }
}
