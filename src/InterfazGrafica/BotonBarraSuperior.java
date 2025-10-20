package InterfazGrafica;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Dimension; // Necesario para Dimension
import java.awt.FontMetrics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotonBarraSuperior extends JButton {

    private final Color defaultBg = new Color(29, 29, 39);
    private final Color hoverBg = new Color(60, 60, 60);
    private final Color foregroundColor = Color.WHITE;
    private final Color borderColor = new Color(50, 50, 60);

    private final int radius = 10;
    
    // Dimensiones estimadas para el botón "Connect Wallet" de la esquina superior derecha
    private final int PREFERRED_WIDTH = 120; // Ancho estimado
    private final int PREFERRED_HEIGHT = 30; // Alto estimado

    public BotonBarraSuperior() {
        super("Cargar Fichero");
        
        // Configuraciones necesarias para el estilo plano
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false); // <--- Es mejor dejarlo en false para el dibujo personalizado
        
        // Asignar los colores ajustados
        setForeground(foregroundColor);
        setBackground(defaultBg); // Se usa solo para el dibujo personalizado
        
        // Ajuste de fuente (parece un poco más grueso/negrita en la imagen)
        setFont(getFont().deriveFont(Font.BOLD, 12f)); 
        
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

    // Método para proporcionar el tamaño preferido del botón
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 1. Dibuja el fondo redondeado (usa el color de setBackground)
        g2.setColor(getBackground()); 
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        
        // 2. Dibuja el texto del botón y otros elementos de la superclase
        // NOTA: No uses super.paintComponent(g) después de pintar el fondo personalizado
        // en este caso, porque puede pintar encima del redondeado si el LAF lo hace mal.
        // En su lugar, dibujamos el texto manualmente.
        
        // Dibujar el texto centrado
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
        g2.drawString(getText(), x, y);
        
        g2.dispose();
    }

    
}