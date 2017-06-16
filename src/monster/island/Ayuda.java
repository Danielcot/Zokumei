/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster.island;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Omar xv
 */
public class Ayuda extends JFrame{
    private JLabel holi;
    private JTextArea hola;
    public Ayuda()
    {
        super();
        this.setSize(600,400);
        this.setLocation(0,0);
        
        holi= new JLabel ("hola prro");
        hola= new JTextArea("como se hace esta wea\n"+"quiero pasar\n");
        hola.setSize(80, 80);
        hola.setLocation(10, 10);
        hola.setForeground(java.awt.Color.YELLOW);
        
        
        this.add(hola);
        hola.setEditable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
