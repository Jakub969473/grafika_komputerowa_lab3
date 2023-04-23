import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel extends JPanel {

    public ArrayList points = new ArrayList();
    int linia = 0;

    public Panel(){

        setBackground(new Color(255,255,255));

        setPreferredSize(new Dimension(500,500));
        setMaximumSize(new Dimension(500,500));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                points.add(new Point(e.getX(),e.getY()));
                repaint();
            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        g2.setColor(Color.gray);
        for (int i=0;i<points.size;i++){
            Point p=points.get(i);
            g2.fillOval(p.x, p.y, 5, 5);

            if(linia !=0) {
                Lamana(i, p, g);
            }
        }

        if(linia == 2 && points.size>0) {
            Bezir(g2);
        }
    }

    public void Lamana(int i, Point p,Graphics g ){

        if(i<points.size && points.size>1){
            Point prev = points.get(i-1);
            g.drawLine(p.x+2,p.y+2,prev.x+2,prev.y+2);
        }

    }

    public void Bezir(Graphics g){
        int n=points.size;
        int m;
        int dok=100;

        double x1=0,y1=0,x2,y2,temp,t=1.0/dok;

        double [][] R= new double[points.size][2];
        double [][] Q=new double[points.size][2];
        Point [] P=new Point[dok];

        for(int j=0;j<dok;j++) {
            for (int i = 0; i < points.size; i++) {
                R[i][0] = points.get(i).x;
                R[i][1] = points.get(i).y;

            }

            m=n;

            while (m > 0) {
                for (int i = 0; i < m - 1; i++) {

                    Q[i][0] = R[i][0]+t*(R[i+1][0]-R[i][0]);
                    Q[i][1] = R[i][1]+t*(R[i+1][1]-R[i][1]);
                }
                m--;
                for (int i = 0; i < m; i++) {
                    R[i] = Q[i];
                }
            }
            P[j]=new Point((int)Math.round(R[0][0]),(int)Math.round(R[0][1]));

            t+=1.0/dok;
        }

        Point p =points.get(0);

        g.drawLine(p.x+2,p.y+2,P[0].x+2,P[0].y+2);

        for(int i=1;i<P.length;i++){
            g.drawLine(P[i-1].x+2,P[i-1].y+2,P[i].x+2,P[i].y+2);
        }

        System.out.println(P[0]);

    }

    private long Silnia(int n){

        long wynik = 1;

        if(n == 0 || n == 1){
            return 1;
        }else{

            for(int i=1; i<=n;i++){
                wynik*=i;
            }
            return wynik;
        }
    }

    public void reset() {
        points = new ArrayList();
        repaint();
    }
}
