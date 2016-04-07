package Training;
import java.awt.*;
import java.awt.event.*;

public class LichtShow extends Frame {

    public LichtShow() {
        super("Lichtshow");
        setLayout(new GridLayout(1, 8));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }});

        LichtPanel[] verlichting = new LichtPanel[8];

        verlichting[0] = new LichtPanel(Color.magenta);
        verlichting[1] = new LichtPanel(Color.cyan);
        verlichting[2] = new LichtPanel(Color.pink);
        verlichting[3] = new LichtPanel(Color.blue);
        verlichting[4] = new LichtPanel(Color.orange);
        verlichting[5] = new LichtPanel(Color.green);
        verlichting[6] = new LichtPanel(Color.red);
        verlichting[7] = new LichtPanel(Color.yellow);

        for (int i=0; i<verlichting.length; i++) {
            add(verlichting[i]);
            new Thread(verlichting[i]).start();
        }

        setSize(600, 90);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LichtShow();
    }
}


class LichtPanel extends Panel implements Runnable {

    private Color mijnKleur;

    public LichtPanel(Color c) {
        setBackground(Color.black);
        mijnKleur = c;
    }

    public void run() {
        while (true) {
            wacht();

            // ***** BEGIN KRITISCHE CODE *****
            setBackground(mijnKleur);
            repaint();
            wacht();
            setBackground(Color.black);
            repaint();
            // *****  EINDE KRITISCHE CODE  *****
        }
    }

    private void wacht() {
        try {
            long slaapTijd = (long)(Math.random() * 1000) + 100;
            Thread.sleep(slaapTijd);
        } catch (InterruptedException e) {
        }
    }
}
