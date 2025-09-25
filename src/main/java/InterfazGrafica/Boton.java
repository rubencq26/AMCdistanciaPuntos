package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton{
    public Boton(String nombre){
        super(nombre);
        setMaximumSize(new Dimension(300, 100));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        setOpaque(true);
        //setContentAreaFilled(false);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(Color.DARK_GRAY);
            }
        });
    }
}
