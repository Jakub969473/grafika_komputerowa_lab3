import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MojeOkno extends JFrame implements ActionListener {

    MenuOkna menu = new MenuOkna();

    public MojeOkno(){
        super("Grafia komputerowa");

        add(new Panel());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        setSize(new Dimension(500,500));

        setJMenuBar(menu);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


