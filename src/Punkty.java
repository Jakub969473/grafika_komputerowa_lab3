import javax.swing.*;
import java.awt.*;

public class Punkty extends JPanel {

    public Point points[];

    List list = new List();

    public Punkty(){
        setPreferredSize(new Dimension(100,500));
        setMaximumSize(new Dimension(100,500));

        setLayout(new GridLayout(1,2));

        list.setPreferredSize(new Dimension(100,100));

        add(list);

        list.add("NR  X   Y");
    }

    public void dodaj(){

        String temp ="P"+list.getItemCount()+" "+points[0].x+ " "+points[0].y;
        list.add(temp);
    }


}
