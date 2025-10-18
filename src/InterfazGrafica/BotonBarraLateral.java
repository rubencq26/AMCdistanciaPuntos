/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author rubco
 */
public class BotonBarraLateral extends JButton{
    public BotonBarraLateral(String name){
        setFocusPainted(false); // Quita el borde del foco
        setBorderPainted(false); // Quita el borde por defecto
        setContentAreaFilled(false); // Deja transparente el area del boton
        setOpaque(true); // Permite que setBackground funcione
        
        setBackground(new Color(246, 244, 245)); // Mismo color que el panel de fondo
        setForeground(Color.DARK_GRAY);
        setFont(new Font("Segoe UI Light", Font.PLAIN, 14)); // Fuente similar a la imagen
        setText(name);
        
        setHorizontalAlignment(SwingConstants.LEFT); // Alinea texto e icono a la izquierda
        setPreferredSize(new Dimension(200, 40)); // Tamaño preerido del boton
        setMaximumSize(new Dimension(200, 40)); // Se Asegura que el boton no se extira
        
        //Hover
        
        Color defaultBg = new Color(246, 244, 245);
        Color hoverBg = new Color(230, 230, 230); // Un gris ligeramente más oscuro para el hover
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                setBackground(hoverBg);
            }
            
            @Override 
            public void mouseExited(MouseEvent e){
                setBackground(defaultBg);
            }
            
        });
        
        
    }
    
}
