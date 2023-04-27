import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MojeOkno extends JFrame implements ActionListener {

    MenuOkna menu = new MenuOkna();

    Panel lewy = new Panel();

    Punkty punkty = new Punkty();

    Przeksztalcenia prawy = new Przeksztalcenia();

    double[][] aktualnaMacierz = new double[3][3];

    public MojeOkno(){
        super("Grafia komputerowa");

        setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));

        add(lewy);

        add(punkty);

        add(prawy);

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
        menu.resetPunkty.addActionListener(this);
        menu.resetMacierz.addActionListener(this);

        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ArrayList x = lewy.points;
                Point [] p = new Point[x.size];

                for(int i=0;i<p.length;i++){
                    p[i] = x.get(i);
                }

                punkty.points=p;

                punkty.dodaj();
            }
        };

        lewy.addMouseListener(mouse);

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                aktualnaMacierz[i][j] = 0;
            }
        }

        aktualnaMacierz[0][0] = 1;
        aktualnaMacierz[1][1] = 1;
        aktualnaMacierz[2][2] = 1;


        prawy.dokText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                int dok = 0;

                if(e.getKeyChar() == '\n'){
                    String temp = prawy.dokText.getText();
                    try{
                        dok = Integer.parseInt(temp);
                    }catch(Exception exception){
                        JOptionPane.showMessageDialog(new JFrame(),"Wrong Input");
                        dok = lewy.dok;
                    }

                    lewy.dok = dok;

                    lewy.repaint();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        prawy.przesunText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                boolean poprawny = true;

                if(e.getKeyChar() == '\n'){
                    String[] temp = prawy.przesunText.getText().split(",");
                    double x = 0,y = 0;
                    try{
                        x = Double.parseDouble(temp[0]);
                        y = Double.parseDouble(temp[1]);
                    }catch(Exception exception){
                        JOptionPane.showMessageDialog(new JFrame(),"Wrong Input");
                        poprawny = false;
                    }

                    if(poprawny){
                        double[][] z = new double[3][3];


                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                z[i][j] = 0;
                            }
                        }

                        z[0][0] = 1;
                        z[1][1] = 1;
                        z[2][2] = 1;
                        z[2][0] = x;
                        z[2][1] = y;

                        Mul(z);

                        lewy.aktualnaMacierz = aktualnaMacierz;
                        lewy.przeksztalc();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        prawy.obrotText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                boolean poprawny = true;

                if(e.getKeyChar() == '\n'){
                    String temp = prawy.obrotText.getText();
                    double x = 0;
                    try{
                        x = Double.parseDouble(temp);
                    }catch(Exception exception){
                        JOptionPane.showMessageDialog(new JFrame(),"Wrong Input");
                        poprawny = false;
                    }

                    if(poprawny){
                        double[][] z = new double[3][3];


                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                z[i][j] = 0;
                            }
                        }

                        z[0][0] = Math.cos(Math.toRadians(x));
                        z[1][1] = Math.cos(Math.toRadians(x));
                        z[1][0] = -Math.sin(Math.toRadians(x));
                        z[0][1] = Math.sin(Math.toRadians(x));
                        z[2][2] = 1;


                        Mul(z);
                        lewy.aktualnaMacierz = aktualnaMacierz;
                        lewy.przeksztalc();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        prawy.skalaText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                boolean poprawny = true;

                if(e.getKeyChar() == '\n'){
                    String[] temp = prawy.skalaText.getText().split(",");
                    double x = 0,y = 0;
                    try{
                        x = Double.parseDouble(temp[0]);
                        y = Double.parseDouble(temp[1]);
                    }catch(Exception exception){
                        JOptionPane.showMessageDialog(new JFrame(),"Wrong Input");
                        poprawny = false;
                    }

                    if(poprawny){
                        double[][] z = new double[3][3];


                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                z[i][j] = 0;
                            }
                        }

                        z[0][0] = x;
                        z[1][1] = y;
                        z[2][2] = 1;

                        Mul(z);
                        lewy.aktualnaMacierz = aktualnaMacierz;
                        lewy.przeksztalc();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String label = e.getActionCommand();

        if(label.equals("Punkty")){
            lewy.linia = 0;
            lewy.repaint();
        }else if(label.equals("Lamana")){
            lewy.linia = 1;
            lewy.repaint();
        }else if(label.equals("Bezir")){
            lewy.linia = 2;
            lewy.repaint();
        }else if(label.equals("Reset Punktów")){
            lewy.reset();
            punkty.list.removeAll();
            punkty.list.add("NR  X   Y");
        }else if(label.equals("Reset Macierzy")){
            double[][] x = new double[3][3];

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    x[i][j] = 0;
                }
            }

            x[0][0] = 1;
            x[1][1] = 1;
            x[2][2] = 1;

            aktualnaMacierz=x;

            lewy.aktualnaMacierz = x;
            lewy.przeksztalc();

            prawy.matrix = x;
            prawy.updateMatrix();


        }

    }

    public void Mul(double[][] przeksztalcenie){

        double [][] result = new double[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                    result[i][j] = 0;
            }
        }


        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++) {
                    result[i][j] +=  przeksztalcenie[k][j] * aktualnaMacierz[i][k];
                }
            }
        }


        aktualnaMacierz = result;

        prawy.matrix = result;
        prawy.updateMatrix();
    }
}


