package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    public PanelPrincipal(Menu menu){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton boton1 = new JButton("Crear un fichero .tsp aleatorio");
        boton1.setMaximumSize(new Dimension(300, 100));
        boton1.addActionListener(e -> menu.cambiarPanel("Panel2"));

        JButton boton2 = new JButton("Cargar un dataset en memoria");
        boton2.setMaximumSize(new Dimension(300, 100));
        boton2.addActionListener(e -> menu.cambiarPanel("Panel3"));
        JButton boton3 = new JButton("Probar una estrategia");
        boton3.setMaximumSize(new Dimension(300, 100));
        JButton boton4 = new JButton("Comprobar estrategias");
        boton4.setMaximumSize(new Dimension(300, 100));
        JButton boton5 = new JButton("Comparar todas las estrategias");
        boton5.setMaximumSize(new Dimension(300, 100));
        JButton boton6 = new JButton("Comparar 2 estrategias");
        boton6.setMaximumSize(new Dimension(300, 100));
        JButton boton7 = new JButton("Comparar 3 estrategias");
        boton7.setMaximumSize(new Dimension(300, 100));
        JButton boton8 = new JButton("Salir");
        boton8.setMaximumSize(new Dimension(300, 100));

        boton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton3.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton4.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton5.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton6.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton7.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton8.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(boton1);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(boton2);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(boton3);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(boton4);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(boton5);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(boton6);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(boton7);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(boton8);

    }

}
