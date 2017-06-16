package monster.island;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omar xv
 */
public class Tablero extends JFrame
{
    private boolean openedOnce;
    private Mapa map;
    private Interfaz interfaz;
    private JLayeredPane capas;
    public Tablero()
    {
        super();
        interfaz = new Interfaz();
        map = new Mapa();
        capas = new JLayeredPane();
        capas.setSize(1150, 720);
        capas.setLocation(0, 0);
        this.add(capas);
        capas.setVisible(true);
        capas.add(map, new Integer(1));
        capas.add(interfaz, new Integer(2));
        map.setFocusable(true);
        map.requestFocus();
        openedOnce = false;
        setSize(1150,720); 
        interfaz.addComponentListener(new ComponentAdapter(){
            public void componentHidden(ComponentEvent ce){
                getMe().dispose();
            }
        });
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setUndecorated(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    private Tablero getMe(){
        return this;
    }
}
