package Bublina.model;

import java.awt.*;

public class Bublina {
    private int prumer;
    private Color barva;

    public Bublina(int prumer, Color barva){
        this.prumer = prumer;
        this.barva = barva;
    }

    public Color getBarva() {
        return barva;
    }

    public void setBarva(Color barva) {
        this.barva = barva;
    }

    public int getPrumer() {
        return prumer;
    }

    public void setPrumer(int prumer) {
        this.prumer = prumer;
    }

    public void zmenaPrumeru(int delta){
        prumer += delta;
    }

    public void vykresli(Graphics g , int x, int y){
        vykresli(g,x,y,barva);
    }

    public void vykresli(Graphics g , int x, int y, Color barva){
        g.setColor(barva);
        g.drawOval(x, y, prumer, prumer);
    }
}
