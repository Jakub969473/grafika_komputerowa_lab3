import java.awt.*;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MojeOkno();
            }
        });
        //wektorNormalny();
    }

    public static void wektorNormalny(){
        kartkówka6 x = new kartkówka6();
        x.wektorNormalny(new Punkt(2,2,-2), new Punkt(7,5,0), new Punkt(3,3,1));
    }
}

