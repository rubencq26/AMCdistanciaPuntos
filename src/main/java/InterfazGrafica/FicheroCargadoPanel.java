package InterfazGrafica;

import TSPFicheros.TSPfichero;
import main.Main;

import javax.swing.*;
import java.awt.*;

public class FicheroCargadoPanel extends JPanel {

    private final LienzoPuntos lienzo = new LienzoPuntos();
    private final JLabel lblNombre = new JLabel();
    private final JLabel lblComentario = new JLabel();
    private final JLabel lblDimension = new JLabel();

    public FicheroCargadoPanel(Menu ventana){
        setLayout(new BorderLayout());

        JPanel infoAbajo = new JPanel();
        infoAbajo.setLayout(new BoxLayout(infoAbajo, BoxLayout.Y_AXIS));
        infoAbajo.add(lblNombre);
        infoAbajo.add(lblComentario);
        infoAbajo.add(lblDimension);

        add(lienzo, BorderLayout.CENTER);
        add(infoAbajo, BorderLayout.SOUTH);

        refresh();
    }

    public void refresh(){
        TSPfichero fich = Main.getFichero();
        if (fich == null) {
            lienzo.setPuntos(java.util.Collections.emptyList());
            lblNombre.setText("Nombre: -");
            lblComentario.setText("Comentario: -");
            lblDimension.setText("Dimensión: -");
        } else {
            lienzo.setPuntos(fich.getNodos());
            lblNombre.setText("Nombre: " + fich.getNAME());
            lblComentario.setText("Comentario: " + fich.getCOMMENT());
            lblDimension.setText("Dimensión: " + fich.getDIMENSION());
        }
        revalidate();
        repaint();
    }
}