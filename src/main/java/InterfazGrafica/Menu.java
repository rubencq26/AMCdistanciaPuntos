package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private final NoFicheroPanel noFicheroPanel;
    private final FicheroCargadoPanel ficheroCargadoPanel;
    public JPanel panelInformativo;
    public JPanel panelContenedor;

    public Menu(){
        setTitle("AMC - Distancia de puntos");
        setSize(1080, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        noFicheroPanel = new NoFicheroPanel(this);
        ficheroCargadoPanel = new FicheroCargadoPanel(this);

        panelInformativo = new JPanel(new CardLayout());
        panelInformativo.add(noFicheroPanel, "Info1");
        panelInformativo.add(ficheroCargadoPanel, "Info2");

        panelContenedor = new JPanel(new CardLayout());
        panelContenedor.add(new PanelPrincipal(this), "Panel1");
        panelContenedor.add(new CrearFicheroPanel(this), "Panel2");
        panelContenedor.add(new CargarDataset(this), "Panel3");

        panelContenedor.setPreferredSize(new Dimension(360, 700));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelInformativo, panelContenedor);
        split.setResizeWeight(1.0);
        split.setDividerLocation(720);
        split.setOneTouchExpandable(true);

        add(split);
        setVisible(true);
    }

    public void cambiarPanelBotones(String nombrePanel){
        ((CardLayout) panelContenedor.getLayout()).show(panelContenedor, nombrePanel);
    }

    public void cambiarPanelInformativo(String nombrePanel){
        ((CardLayout) panelInformativo.getLayout()).show(panelInformativo, nombrePanel);
        panelInformativo.revalidate();
        panelInformativo.repaint();
    }

    // Llama esto tras cargar/generar fichero
    public void refrescarInfoFichero(){
        ficheroCargadoPanel.refresh();
        cambiarPanelInformativo("Info2");
    }
}