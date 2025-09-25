package InterfazGrafica;

import TSPFicheros.TSPfichero;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CargarDataset extends JPanel {
    public CargarDataset(Menu ventana){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        CampoTexto nombreFichero = new CampoTexto("Introduzca el nombre del fichero a cargar (con extension)", 50);

        Boton cargar = new Boton("Cargar fichero");
        cargar.addActionListener(e -> {
            try {
                String nomFichero = nombreFichero.getText();
                if (nomFichero.equals(nombreFichero.texto) || nomFichero.isBlank()) {
                    throw new NullPointerException();
                }

                // Validación rápida de existencia
                File f = new File("src/data/" + nomFichero);
                if (!f.isFile()) {
                    throw new IOException("El fichero no existe");
                }

                TSPfichero fich = new TSPfichero();
                fich.leerFichero(nomFichero);
                Main.getFichero(fich);

                SwingUtilities.invokeLater(() -> {
                    ventana.refrescarInfoFichero();          // actualiza datos y muestra "Info2"
                    ventana.cambiarPanelInformativo("Info2"); // redundante pero inofensivo
                });

            } catch (NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Error: campo vacío", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Error: el fichero no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        Boton atras = new Boton("Atras");
        atras.addActionListener(_ -> ventana.cambiarPanelBotones("Panel1"));

        add(nombreFichero);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(cargar);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(atras);
    }
}