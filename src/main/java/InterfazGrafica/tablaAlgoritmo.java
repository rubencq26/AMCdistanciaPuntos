/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazGrafica;

import Utils.Solucion;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.Main;

/**
 *
 * @author Ruben
 */
public class tablaAlgoritmo extends JScrollPane {

    private String[] columnas = {"Estrategia", "Punto 1", "Punto 2", "Distancia", "Calculadas", "Tiempo(mseg)"};
    private Object[][] datos;

    public tablaAlgoritmo(int filas, int columnas, List<Solucion> soluciones) {
        datos = new Object[filas][columnas];
        for (int i = 0; i < filas; i++) {
            String p1 = String.valueOf(soluciones.get(i).getP1()) + " (" + String.valueOf(Main.getFichero().getNodo(soluciones.get(i).getP1()).getX()) + " " + String.valueOf(Main.getFichero().getNodo(soluciones.get(i).getP1()).getY()) + ")";
            String p2 = String.valueOf(soluciones.get(i).getP2()) + " (" + String.valueOf(Main.getFichero().getNodo(soluciones.get(i).getP2()).getX()) + " " + String.valueOf(Main.getFichero().getNodo(soluciones.get(i).getP2()).getY()) + ")";
            datos[i] = new Object[]{
                soluciones.get(i).getNombre(),
                p1,
                p2,
                soluciones.get(i).getDistancia(),
                soluciones.get(i).getNCalculadas(),
                soluciones.get(i).getTiempo()
            };
        }
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(modelo);

        setViewportView(tabla);

    }

}
