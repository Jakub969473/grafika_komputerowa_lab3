import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MojeOkno extends JFrame implements ActionListener {

    MenuOkna menu = new MenuOkna();

    Panel panel = new Panel();

    Punkty punkty = new Punkty();

    public MojeOkno(){
        super("Grafia komputerowa");

        setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));

        add(panel);

        add(punkty);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        setSize(new Dimension(600,600));

        setJMenuBar(menu);

        pack();

        setLocationRelativeTo(null);

        setVisible(true);

        menu.punkty.addActionListener(this);
        menu.łamana.addActionListener(this);
        menu.bezir.addActionListener(this);
        menu.reset.addActionListener(this);

        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ArrayList x = panel.points;
                Point [] p = new Point[x.size];

                for(int i=0;i<p.length;i++){
                    p[i] = x.get(i);
                }

                punkty.points=p;
            }
        };

        panel.addMouseListener(mouse);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String label = e.getActionCommand();

        if(label.equals("Punkty")){
            panel.linia = 0;
            panel.repaint();
        }else if(label.equals("Lamana")){
            panel.linia = 1;;
            panel.repaint();
        }else if(label.equals("Bezir")){
            panel.linia = 2;
            panel.repaint();
        }else if(label.equals("Reset")){
            panel.reset();
        }

    }
}


