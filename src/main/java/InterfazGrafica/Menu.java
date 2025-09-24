package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    private JPanel panelContenedor;
    private CardLayout cardLayout;
    public Menu(){
        setTitle("AMC - Distancia de puntos");
        setSize(1080, 700); // Establecer el tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que se cierre al salir
        setLocationRelativeTo(null); // Que la ventana aparezca en el centro

        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);

        panelContenedor.add(new PanelPrincipal(this), "Panel1");
        panelContenedor.add(new CrearFicheroPanel(this), "Panel2");
        panelContenedor.add(new CargarDataset(this), "Panel3");

        add(panelContenedor);
        setVisible(true);

    }

    public void cambiarPanel(String nombrePanel){
        CardLayout layout = (CardLayout) panelContenedor.getLayout();
        layout.show(panelContenedor, nombrePanel);


    }

}
