package InterfazGrafica;

import TSPFicheros.TSPfichero;
import java.awt.Dimension;
import javax.swing.*;
import main.Main;

public class AlgortimosPanel extends JPanel {

    public AlgortimosPanel (Menu ventana){
        Boton exhaustivo = new Boton("Exhaustivo");
        exhaustivo.setMaximumSize(new Dimension(300, 100));
        exhaustivo.addActionListener(e->{
            try{
                TSPfichero file = new TSPfichero(Main.getFichero());
            } catch(Exception ex){
                
            }
        }
        );
        
        
        exhaustivo.setAlignmentX(CENTER_ALIGNMENT);


    }

}
