package InterfazGrafica;

import TSPFicheros.TSPfichero;
import main.Main;

import javax.swing.*;
import java.awt.*;

public class NoFicheroPanel extends JPanel {
    private final JLabel lblEstado = new JLabel("No se ha cargado un fichero", SwingConstants.CENTER);


    public NoFicheroPanel(Menu ventana){
        setLayout(new BorderLayout());


        lblEstado.setForeground(Color.RED);
        lblEstado.setFont(new Font("Arial", Font.BOLD, 25));

        add(lblEstado);



    }





    }


