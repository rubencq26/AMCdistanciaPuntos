package InterfazGrafica;

import TSPFicheros.TSPfichero;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CrearFicheroPanel extends JPanel {
    public CampoTexto nombreFichero;

    public CrearFicheroPanel(Menu ventana){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        CampoTexto nombreFichero = new CampoTexto("Nombre fichero (sin extension)", 50);

        CampoTexto Comentario = new CampoTexto("Escriba el comentario", 100);

        CampoTexto Dimension = new CampoTexto("Introduzca la dimension (int)", 20);

        Boton enviar = new Boton("Crear fichero");

        Boton atras = new Boton("Atras");

        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreFichero.getText();
                String comentario = Comentario.getText();
                try{
                    int dimension = Integer.parseInt(Dimension.getText());
                    if(dimension <= 0){
                        throw new NumberFormatException();
                    }
                    if(comentario.equals(Comentario.texto)){
                        comentario = "";
                    }

                    if(nombre.contains(".")){
                        throw new Exception("El nombre no puede contener puntos");
                    }
                    if(nombre.equals(nombreFichero.texto)){
                        throw new NullPointerException();
                    }

                    TSPfichero fichero = new TSPfichero();
                    fichero.generarFichero(nombre, comentario, dimension);
                    Main.fichero = fichero;

                }catch (NumberFormatException ex){
                       JOptionPane.showMessageDialog(
                               null,
                               "Error la dimension debe ser un numero entero mayor a 0",
                               "Formato de numero erroneo", JOptionPane.ERROR_MESSAGE);
                }catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(null, "Error campos vacios", "Campos vacios", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        atras.addActionListener(e -> ventana.cambiarPanel("Panel1"));

        add(nombreFichero);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(Comentario);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(Dimension);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(enviar);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(atras);



    }
}
