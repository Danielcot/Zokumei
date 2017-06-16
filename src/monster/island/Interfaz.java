/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster.island;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Omar xv
 */
public class Interfaz extends JPanel{
    private JButton pausa;
    public Interfaz(){
        super();
        pausa = new JButton("Salir");
        this.setSize(430,720);
        this.setBackground(java.awt.Color.BLUE);
        this.setLocation(720,0);
        this.add(pausa);
        this.setLayout(null);
        pausa.setSize(200, 50);
        pausa.setLocation(0, 0);
        this.setVisible(true);
        pausa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                getMe().setVisible(false);
            }
        });
    }
    private Interfaz getMe(){
        return this;
    }
}
