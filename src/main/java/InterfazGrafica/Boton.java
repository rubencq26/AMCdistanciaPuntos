package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton{
    public Boton(String nombre){
        super(nombre);
        setMaximumSize(new Dimension(300, 100));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
