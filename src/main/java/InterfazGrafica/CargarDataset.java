package InterfazGrafica;

import TSPFicheros.TSPfichero;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class CargarDataset extends JPanel {
    public CargarDataset(Menu ventana){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);


        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        CampoTexto nombreFichero = new CampoTexto("Introduzca el nombre del fichero a cargar (con extension)", 50);

        Boton cargar = new Boton("Cargar fichero");

        cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nomFichero = nombreFichero.getText();

                    if (nomFichero.equals(nombreFichero.texto)) {
                        throw new NullPointerException();
                    }

                    TSPfichero fich = new TSPfichero();
                    fich.leerFichero(nomFichero);
                    Main.recibirFichero(fich);

                }catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(null, "Error campos vacios", "Campos vacios", JOptionPane.ERROR_MESSAGE);
                }catch (IOException ex){
                    JOptionPane.showMessageDialog(null, "Error el fichero no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        Boton atras = new Boton("Atras");
        atras.addActionListener(e -> ventana.cambiarPanel("Panel1"));

        add(nombreFichero);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(cargar);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(atras);
    }


}
