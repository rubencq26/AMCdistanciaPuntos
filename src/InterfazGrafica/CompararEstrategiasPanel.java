/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazGrafica;

import Algoritmos.DyV;
import Algoritmos.DyVMejorado;
import Algoritmos.Exhaustivo;
import Algoritmos.ExhaustivoPoda;
import TSPFicheros.TSPfichero;
import Utils.Solucion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rubco
 */
public class CompararEstrategiasPanel extends JPanel{
    
    private JScrollPane scroll;
    private TablaRender tabla;
    private DefaultTableModel model;
    
    public CompararEstrategiasPanel(){
        setLayout(null);
        setBackground(Color.WHITE);
        
        JLabel titulo = new JLabel("Comprobar Estrategias");
        titulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(20, 40, 300, 40);
        add(titulo);
        
        tabla = new TablaRender();
        tabla.setBounds(20, 200, 740, 200);
        model = new DefaultTableModel(new Object[]{"Talla", "Exhaustivo(t mseg)", "ExhaPoda(t mseg)", "DyV(t mseg)", "DyVMejorado(t mseg)"}, 0);
        tabla.setModel(model);
        
        
        scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 100, 740, 350);
        this.add(scroll);
        
        BotonBarraSuperior boton = new BotonBarraSuperior();
        boton.setText("Comparar Estrategias");
        boton.setBounds(540, 40, 220, 40);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comparar();
            }
            
        });
        
        this.add(boton);
    }
    
    public void comparar(){
        int contador = 500;
        TSPfichero dataset = new TSPfichero();
        
        while(contador < 7500){
            dataset.generarDataset(contador);
            Exhaustivo ex = new Exhaustivo(dataset.getNodos());
            ExhaustivoPoda exp = new ExhaustivoPoda(dataset.getNodos());
            DyV dy = new DyV(dataset.getNodos());
            DyVMejorado dim = new DyVMejorado(dataset.getNodos());
            
            Solucion solEx = ex.calcularDistanciaMasCorta();
            Solucion solExP = exp.calcular();
            Solucion solDyV = dy.calcular();
            Solucion solDim = dim.calcular();
            
            model.addRow(new Object[]{contador, solEx.getTiempo(), solExP.getTiempo(), solDyV.getTiempo(), solDim.getTiempo()});
            
        }
        
        contador +=500;
        
    }
    
    
    
    
}
