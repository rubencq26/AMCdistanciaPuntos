package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class LienzoPuntos extends JPanel {
    private java.util.List<Utils.Punto> puntos = java.util.Collections.emptyList();
    private final Insets margen = new Insets(20, 20, 20, 20);
    private static final Dimension SIZE = new Dimension(800, 500);

    public LienzoPuntos() {
        setPreferredSize(SIZE);
        setMinimumSize(SIZE);
        setMaximumSize(SIZE);
    }

    public void setPuntos(java.util.List<Utils.Punto> pts){
        this.puntos = (pts != null) ? pts : Collections.<Utils.Punto>emptyList();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (puntos.isEmpty()) return;

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double minX = puntos.stream().mapToDouble(Utils.Punto::getX).min().orElse(0);
        double maxX = puntos.stream().mapToDouble(Utils.Punto::getX).max().orElse(1);
        double minY = puntos.stream().mapToDouble(Utils.Punto::getY).min().orElse(0);
        double maxY = puntos.stream().mapToDouble(Utils.Punto::getY).max().orElse(1);

        int w = SIZE.width - margen.left - margen.right;
        int h = SIZE.height - margen.top - margen.bottom;

        double sx = (maxX - minX) == 0 ? 1 : w / (maxX - minX);
        double sy = (maxY - minY) == 0 ? 1 : h / (maxY - minY);

        g2.setColor(Color.BLUE);
        int r = 4;
        for (Utils.Punto p : puntos) {
            int px = margen.left + (int) Math.round((p.getX() - minX) * sx);
            int py = margen.top + h - (int) Math.round((p.getY() - minY) * sy);
            g2.fillOval(px - r, py - r, 2 * r, 2 * r);
        }

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() { return SIZE; }
    @Override
    public Dimension getMinimumSize()   { return SIZE; }
    @Override
    public Dimension getMaximumSize()   { return SIZE; }
}