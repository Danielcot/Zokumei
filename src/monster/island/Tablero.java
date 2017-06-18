package monster.island;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

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
    private JLayeredPane capas;
    private JLabel pausa;
    private String thisPersona;
    private Interfaz interfaz;
    private Dialogos dialogo;
    public Tablero()
    {
        super();
        thisPersona = "";
        dialogo = new Dialogos();
        interfaz = new Interfaz();
        capas = new JLayeredPane();
        capas.setLocation(0, 0);
        capas.setSize(1150, 1150);
        pausa = new JLabel(new ImageIcon(getClass().getResource("imagenes/interfaz/pause.png")));
        pausa.setVisible(false);
        pausa.setLocation(0, 0);
        pausa.setSize(760, 720);
        map = new Mapa();
        map.setFocusable(true);
        map.requestFocus();
        openedOnce = false;
        this.add(capas);
        capas.add(map,new Integer(1));
        capas.add(pausa, new Integer(2));
        capas.add(interfaz,new Integer(3));
        capas.add(dialogo, new Integer(4));
        interfaz.addComponentListener(new ComponentAdapter(){
            public void componentHidden(ComponentEvent ce){
                map.setVisible(false);
            }
        });
        map.addComponentListener(new ComponentAdapter(){
            public void componentHidden(ComponentEvent ce){
                getMe().dispose();
            }
        });
        map.addFocusListener(new FocusAdapter(){ //Cuando el mapa pierde el focus le da el focus al cuadro de dialogo el requestFocus() esta en dialogo.habla();
            public void focusLost(FocusEvent e) {
                pausa.setVisible(true);
                dialogo.habla(map.getNombre(), map.getTexto()); //aqui no se cambia el texto, esto se deja igual
            }
        });
        dialogo.addFocusListener(new FocusAdapter(){//Cuando el dialogo pierde focus le da el focus al mapa
            public void focusLost(FocusEvent e){
                pausa.setVisible(false);
                map.setFocusable(true);
                map.requestFocus();
            }
        });
        setSize(1150,720); 
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
