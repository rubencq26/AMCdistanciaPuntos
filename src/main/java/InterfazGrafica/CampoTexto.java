package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CampoTexto extends JTextField implements Restablecible{
    public String texto;
    public CampoTexto(String texto ,int ancho) {

        super(texto, ancho);
        setForeground(Color.GRAY);
        this.texto = texto;

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(getText().equals(texto)){
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(texto);
                    setForeground(Color.GRAY); // Restaurar color gris
                }

            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Detectar si la tecla presionada es Backspace
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    // Cancelar el evento si el texto está vacío o es el placeholder
                    if (getText().isEmpty() || getText().equals("Escribe aquí...")) {
                        e.consume(); // Elimina el evento y evita el sonido
                    }
                }
            }
        });


        setMaximumSize(new Dimension(350, 30));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void restablecer(){
        setText(texto);
        setForeground(Color.GRAY);
    }
}
