/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package InterfazGrafica;

import Algoritmos.Exhaustivo;
import Algoritmos.ExhaustivoPoda;
import Utils.Punto;
import Utils.Solucion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rubco
 */
public class DatasetPanel extends javax.swing.JPanel {

    /**
     * Creates new form DatasetPanel
     */
    public static int p1 = -1;
    public static int p2 = -1;
    private DimensionTextField dimensionDataset;
    private DimensionTextField nombreFichero;
    private DimensionTextField dimensionFichero;

    public DatasetPanel() {
        initComponents();
        this.setBounds(201, 67, 799, 670);
        if (!MenuPrincipal.file.getVacio()) {
            ExhaustivoPoda exha = new ExhaustivoPoda(MenuPrincipal.file.getNodos());
            Solucion sol = exha.calcular();
            this.p1 = sol.getP1().getId();
            this.p2 = sol.getP2().getId();

            BarraSuperiorPanel.cambiarLabel();
            repaint();
        }

        JLabel titulo = new JLabel("Dataset");
        titulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(20, 40, 200, 30);
        this.add(titulo);

        BotonBarraSuperior cargarFicheroBoton = new BotonBarraSuperior();
        cargarFicheroBoton.setText("Cargar Fichero");
        cargarFicheroBoton.setBounds(540, 38, 220, 45);
        cargarFicheroBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirDialogoArchivo();

            }
        });
        this.add(cargarFicheroBoton);

        dimensionDataset = new DimensionTextField("Introduzca el n de nodos a generar");
        dimensionDataset.setBounds(540, 145, 220, 40);
        this.add(dimensionDataset);

        BotonBarraSuperior generarDatasetBoton = new BotonBarraSuperior();
        generarDatasetBoton.setText("Generar Dataset");
        generarDatasetBoton.setBounds(540, 98, 220, 45);
        generarDatasetBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirGenerarDataset();
            }

        });
        this.add(generarDatasetBoton);
        
        nombreFichero = new DimensionTextField("Introduzca el nombre(sin extension)");
        nombreFichero.setBounds(540, 260, 220, 45);
        this.add(nombreFichero);
        
        JLabel nombreLabel = new JLabel("Nombre Fichero");
        nombreLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        nombreLabel.setBounds(550, 245,220 ,15);
        nombreLabel.setForeground(Color.WHITE);
        this.add(nombreLabel);
    }

    void abrirGenerarDataset() {

        try {
            String dim = dimensionDataset.getText();
            if(dim == null || dim.trim().isEmpty()){
                return;
            }          
            
            int d = Integer.parseInt(dim.trim());
            
            MenuPrincipal.file.generarDataset(d);

            ExhaustivoPoda exha = new ExhaustivoPoda(MenuPrincipal.file.getNodos());
            Solucion sol = exha.calcular();
            p1 = sol.getP1().getId();
            p2 = sol.getP2().getId();

            BarraSuperiorPanel.cambiarLabel();
            System.out.println("Archivo seleccionado: " + MenuPrincipal.file.getNAME());

            repaint();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    void abrirDialogoArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        File carpeta = new File("src/data");
        fileChooser.setCurrentDirectory(carpeta);

        int resultado = fileChooser.showOpenDialog(MenuPrincipal.menuPrincipal);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            try {
                MenuPrincipal.file.leerFichero(archivoSeleccionado.getName());

                ExhaustivoPoda exha = new ExhaustivoPoda(MenuPrincipal.file.getNodos());
                Solucion sol = exha.calcular();
                p1 = sol.getP1().getId();
                p2 = sol.getP2().getId();

                BarraSuperiorPanel.cambiarLabel();
                System.out.println("Archivo seleccionado: " + archivoSeleccionado.getName());

                repaint();

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("No se seleccionó ningun archivo");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(220, 220, 220));
        int x1 = 0;
        int y1 = 569;
        int x2 = 800;
        int y2 = 569;
        g.drawLine(x1, y1, x2, y2);

        g.setColor(Color.BLACK);
        g.drawRect(20, 90, 450, 450);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        
        g2d.setColor(new Color(28,28,28));
        
        g2d.fillRoundRect(540, 205, 220, 335, 15, 15);
        
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawLine(540, 316, 760, 316);
        g2d.drawLine(540, 417, 760, 417);
        
        g2d.setColor(Color.WHITE);
        

        if (MenuPrincipal.file.getVacio()) {
        } else {
            {
                double escalado = Math.max(MenuPrincipal.file.getMaxY(), MenuPrincipal.file.getMaxX());
                escalado = (442 / escalado);

                final int p1Id = this.p1;
                final int p2Id = this.p2;

                for (Punto p : MenuPrincipal.file.getNodos()) {
                    g2d.setColor(Color.BLACK);

                    if (p.getId() == p1Id || p.getId() == p2Id) {
                        g2d.setColor(Color.RED);
                    }

                    g2d.fillOval((int) (24 + (p.getX() * escalado) - 3), (int) (94 + (p.getY() * escalado) - 3), 6, 6);
                }
            }
        }
    }

    void rePintar() {
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
