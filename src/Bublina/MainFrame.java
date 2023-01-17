package Bublina;

import Bublina.model.Bublina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private final JPanel panel;
    private Bublina bublina = new Bublina(100,Color.RED);
    private AnimacniVlakno vlakno;

    public MainFrame(){
        super("Bublina");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btKresli = new JButton("Kresli");
        add(btKresli, BorderLayout.NORTH);

        btKresli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spustitAnimaci();
            }
        });

        JButton btZastav = new JButton("Zastav");
        add(btZastav, BorderLayout.SOUTH);

        btZastav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vlakno != null) {
                    vlakno.ukoncit();
                    vlakno = null;
                }
            }
        });

        panel = new JPanel();
        add(panel, BorderLayout.CENTER);


        setSize(800, 600);
        setVisible(true);
    }

    private void spustitAnimaci() {
        if(vlakno == null) {
            vlakno = new AnimacniVlakno();
            vlakno.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }

    private class AnimacniVlakno extends Thread{
        private boolean konec = false;

        @Override
        public void run() {
            int d = 2;
            Graphics g = panel.getGraphics();
            while (!konec) {

                g.setColor(panel.getBackground());
//                g.fillRect(200,200,250,250);
                bublina.vykresli(g,200,200,panel.getBackground());
                bublina.zmenaPrumeru(d);
                if(bublina.getPrumer() > 200||bublina.getPrumer() < 10){
                    d = -d;
                }
                bublina.vykresli(g, 200, 200);
                try {
                    sleep(60);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        public void ukoncit(){
            konec = true;
        }
    }
}
