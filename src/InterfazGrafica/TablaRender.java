package InterfazGrafica;


import Algoritmos.DyV;
import Algoritmos.Exhaustivo;
import Algoritmos.ExhaustivoPoda;
import Utils.Solucion;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class TablaRender extends JTable {
    // Colores basados en tu diseño
    private static final Color DARK_BG = new Color(28, 28, 30);
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Color HEADER_BG = new Color(35, 35, 45); // Un poco más oscuro para el encabezado
    
    public TablaRender(){
        super();
        
        
        getTableHeader().setBackground(new Color(29, 29, 39));
        getTableHeader().setForeground(Color.WHITE);
        getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        setFont(new Font("Segoe UI", Font.PLAIN, 10));
        setRowHeight(50);
        setShowVerticalLines(false);
        setShowHorizontalLines(true);
        setGridColor(Color.DARK_GRAY);
        
    }
    
    
    
}