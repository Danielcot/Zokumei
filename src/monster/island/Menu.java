/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster.island;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Omar xv
 */
public class Menu extends JFrame{ 
    private JLabel dragon, segundon, ayuda;
    private JLabel fondillo;
    public boolean openedOnce;
    public final AudioClip menu;
    public Menu()
    {
        super();
        ayuda = new JLabel(new ImageIcon(getClass().getResource("imagenes/menu/Ayuda.jpg")));
        dragon= new JLabel(new ImageIcon(getClass().getResource("imagenes/menu/1.gif")));
        fondillo = new JLabel(new ImageIcon(getClass().getResource("imagenes/menu/fondo.jpg")));
        segundon= new JLabel(new ImageIcon());    
        ayuda.setLocation(1040,460);
        ayuda.setSize(150,50);
        segundon.setSize(200,200);
        segundon.setLocation(320,50);
        fondillo.setLocation(0, 0);
        fondillo.setSize(1280, 720);
        dragon.setSize(200,200);
        dragon.setLocation(240,260);
        menu = java.applet.Applet.newAudioClip(getClass().getResource("audio/16.wav"));
        menu.play();
        setLayout(null);
        ayuda.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                new Ayuda();
            }
        });
        dragon.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                Tablero tablero = new Tablero();
                tablero.setVisible(true);
                tablero.addWindowListener(new WindowAdapter() {
                    public void windowClosed(WindowEvent we){
                        getMe().setVisible(true);
                    }
                });
                getMe().setVisible(false);
            }
            public void mouseEntered(MouseEvent e) {
                dragon.setIcon(new ImageIcon(getClass().getResource("imagenes/menu/2.jpg")));
            }
            public void mouseExited(MouseEvent e) {
                dragon.setIcon(new ImageIcon(getClass().getResource("imagenes/menu/1.gif")));
            }
        });
        segundon.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                Tablero tablero= new Tablero();
                tablero.setVisible(true);
                getMe().setVisible(false);
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(ayuda);
        this.add(segundon);
        this.add(dragon);
        this.add(fondillo);
        this.setSize(1280,720);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        if(openedOnce == false){
            new Splash(this);
            openedOnce = true;
        }
    }
    public Menu getMe()
    {
        return this;
    }
}
