/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author rubco
 */
public class DimensionTextField extends JTextField{
    private final Color bgColor = new Color(29, 29, 39);
    private final Color bordeColor = new Color(60,60,65);
    private final Color focusColor = Color.WHITE;
    private final Color textColor = Color.WHITE;
    private final int radioEsquina = 15;
    
    private final Color bordeColorPredeterminado = new Color(60, 60, 65); // El color base
    private Color borderColor;
    
    private String placeHolder;
    private final Color placeholderColor = new Color(150, 150, 150);
    
    public DimensionTextField(String placeHolderText){
        super(20);
        this.placeHolder = placeHolderText;
        
        setOpaque(false);
        setBorder(null);
        
        setBackground(bgColor);
        setForeground(textColor);
        setCaretColor(textColor);
        setFont(getFont().deriveFont(Font.PLAIN, 12f));
        setPanelBorderColor(borderColor);
        
        addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                repaint();
                setPanelBorderColor(bgColor);
            }

            @Override
            public void focusLost(FocusEvent e) {
                repaint();
                setPanelBorderColor(bgColor);
            }
           
            
        });
        
        
    }
    
    private void setPanelBorderColor(Color color) {
        this.borderColor = color; // Asigna el color al campo CORRECTO
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. Dibujar el fondo redondeado (Color oscuro)
        g2.setColor(bgColor);
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radioEsquina, radioEsquina);
        
        // 2. Dibujar el borde redondeado usando la variable 'borderColor'
        g2.setColor(this.borderColor); // 👈 Usa la variable que cambia con el foco
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radioEsquina, radioEsquina);

        // 3. Llama al super.paintComponent para dibujar el texto que se escribe y el cursor
        super.paintComponent(g);
        
        // 4. Lógica del Placeholder
        if (getText().length() == 0 && !hasFocus()) {
            g.setColor(placeholderColor);
            g.setFont(getFont()); 

            FontMetrics fm = g.getFontMetrics();
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent(); 
            int x = getInsets().left; 
            
            g.drawString(placeHolder, x, y);
        }
        
        g2.dispose();
    }
    
    // Necesario para que el texto se dibuje correctamente dentro del área redondeada
    @Override
    public Insets getInsets() {
        int padding = 10;
        return new Insets(padding, padding, padding, padding);
    }
}
