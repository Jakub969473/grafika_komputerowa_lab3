import javax.swing.*;
import java.awt.*;

public class Przeksztalcenia extends JPanel {

    JLabel dok = new JLabel("Dokładność");
    JLabel przesun = new JLabel("Przesuniecie");
    JLabel skala = new JLabel("Skaluj");
    JLabel obrot = new JLabel("Obroc");
    JLabel macierz = new JLabel("Macierz");
    JTextField dokText = new JTextField();
    JTextField przesunText = new JTextField();
    JTextField skalaText = new JTextField();
    JTextField obrotText = new JTextField();
    JPanel macierzWyswietl = new JPanel(new GridLayout(3,3,1,1));
    private JLabel[][] grid = new JLabel[3][3];
    double[][] matrix = new double[3][3];


    public Przeksztalcenia(){
        setPreferredSize(new Dimension(250,500));
        setMaximumSize(new Dimension(250,500));
        setBackground(new Color(255,255,255));

        setText();

        setLayout(new GridBagLayout());

        GridBagConstraints c=new GridBagConstraints();

        c.weightx = 0.5;

        c.insets =new Insets(10,10,10,10);

        c.weighty = 6;

        c.gridx = 0;
        c.gridy = 0;

        add(dok,c);

        c.gridx = 0;
        c.gridy = 1;

        add(przesun,c);

        c.gridx = 0;
        c.gridy = 2;

        add(skala,c);

        c.gridx = 0;
        c.gridy = 3;

        add(obrot,c);

        c.gridx = 0;
        c.gridy = 4;

        add(macierz,c);

        c.gridx = 1;
        c.gridy = 0;

        add(dokText,c);

        c.gridx = 1;
        c.gridy = 1;

        add(przesunText,c);

        c.gridx = 1;
        c.gridy = 2;

        add(skalaText,c);

        c.gridx = 1;
        c.gridy = 3;

        add(obrotText,c);

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrix[i][j] = 0;
            }
        }

        matrix [0][0] = 1;
        matrix [1][1] = 1;
        matrix [2][2] = 1;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j] = new JLabel(matrix[i][j]+"",SwingConstants.CENTER);
               //grid[i][j].setFont(LABEL_FONT); // make it big
                grid[i][j].setOpaque(true);
                grid[i][j].setBackground(Color.WHITE);
                macierzWyswietl.add(grid[i][j]);
            }
        }

        updateMatrix();

        c.gridx = 1;
        c.gridy = 4;

        add(macierzWyswietl,c);

    }

    private void setText(){
        dokText.setPreferredSize(new Dimension(100,50));
        dokText.setMinimumSize(new Dimension(100,50));
        dokText.setBackground(new Color(245,245,245));
        dokText.setText("100");

        przesunText.setPreferredSize(new Dimension(100,50));
        przesunText.setMinimumSize(new Dimension(100,50));
        przesunText.setBackground(new Color(245,245,245));
        przesunText.setText("0,0");

        skalaText.setPreferredSize(new Dimension(100,50));
        skalaText.setMinimumSize(new Dimension(100,50));
        skalaText.setBackground(new Color(245,245,245));
        skalaText.setText("0,0");

        obrotText.setPreferredSize(new Dimension(100,50));
        obrotText.setMinimumSize(new Dimension(100,50));
        obrotText.setBackground(new Color(245,245,245));
        obrotText.setText("0");

        macierzWyswietl.setPreferredSize(new Dimension(200,120));
        macierzWyswietl.setMinimumSize(new Dimension(200,120));
        macierzWyswietl.setBackground(new Color(245,245,245));

    }

    public void updateMatrix(){



        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if((int)matrix[i][j]!=matrix[i][j]){
                    grid[i][j].setText(String.format("%.4f",matrix[i][j]));
                }else{
                    grid[i][j].setText(String.format("%.1f",matrix[i][j]));
                }
            }
        }

        repaint();

    }
}
