package main;
import InterfazGrafica.Menu;
import TSPFicheros.TSPfichero;

import javax.swing.*;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame {
    private static TSPfichero fichero;
    public static void main(String[] args) {
        // Crear la ventana principal

        Menu ventana = new Menu();




    }

    public static void getFichero(TSPfichero fich){
        fichero = fich;
    }

    public static TSPfichero getFichero(){
        return fichero;
    }
}