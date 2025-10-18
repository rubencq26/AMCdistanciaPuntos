package InterfazGrafica; // Ajusta el paquete si es necesario

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font; // Para la fuente, si fuera necesario
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotonBasura extends JButton {

    private ImageIcon icon; // El icono que vamos a dibujar
    // Colores para el botón de icono rectangular
    private final Color defaultBg = new Color(240, 240, 240); // Gris muy claro, casi blanco
    private final Color hoverBg = new Color(220, 220, 220);    // Un gris un poco más oscuro para el hover
    private final int radius = 8;                              // Radio de las esquinas (un poco menos que el de "Connect Wallet")
    private final int iconSize = 16;                           // Tamaño del icono dentro del botón
    
    // Dimensiones estimadas para el botón de la luna/basura
    private final int PREFERRED_WIDTH = 30; // Ancho
    private final int PREFERRED_HEIGHT = 30; // Alto (para que sea cuadrado)

    public BotonBasura(ImageIcon originalIcon) {
        super(); // Constructor sin texto
        
        // Carga y escala el icono
        if (originalIcon != null) {
            Image scaledImage = originalIcon.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH);
            this.icon = new ImageIcon(scaledImage);
        } else {
            this.icon = null;
        }

        // Configuraciones necesarias para el estilo plano y redondeado
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false); // Importante para que nuestro paintComponent funcione
        
        // Color de fondo inicial
        setBackground(defaultBg); 
        
        // Efecto hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverBg);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(defaultBg);
            }
        });
        
        
    }

    // Proporcionar un tamaño preferido (cuadrado)
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 1. Dibuja el fondo rectangular redondeado
        g2.setColor(getBackground()); // Usa el color actual (defaultBg o hoverBg)
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius); 
        
        // 2. Dibuja el icono centrado
        if (icon != null) {
            int x = (getWidth() - icon.getIconWidth()) / 2;
            int y = (getHeight() - icon.getIconHeight()) / 2;
            icon.paintIcon(this, g2, x, y);
        }
        
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(200, 200, 200)); // Un gris aún más claro para el borde
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
        
    }
}