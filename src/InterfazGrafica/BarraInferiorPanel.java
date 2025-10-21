/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rubco
 */
public class BarraInferiorPanel extends JPanel {

    private JLabel solucion;

    public BarraInferiorPanel() {
        setLayout(null);
        solucion = new JLabel();
        solucion.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        solucion.setForeground(Color.DARK_GRAY);
        solucion.setBounds(20, 23, 500, 15);
        this.add(solucion);

    }

    public void actualizarSolucion() {
        if (MenuPrincipal.sol.getP1().getId() == -1 || MenuPrincipal.sol.getP2().getId() == -1) {
            solucion.setText(" ");
        } else {
            solucion.setText(MenuPrincipal.sol.getP1().toString() + "  " + MenuPrincipal.sol.getP2().toString() + "  " + MenuPrincipal.sol.getDistancia());
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(220, 220, 220));
        int x1 = 0;
        int y1 = 1;
        int x2 = 800;
        int y2 = 1;
        g.drawLine(x1, y1, x2, y2);
    }

}
