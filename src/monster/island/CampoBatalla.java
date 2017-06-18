/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster.island;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class CampoBatalla extends JFrame{
    private int noEnemigos;
    private panelBatalla HUD,opciones,estatus;
    private Enemigo ene1, ene2, ene3;
    private Image hub, op, es;
    public CampoBatalla(){
        hub = new ImageIcon(getClass().getResource("imagenes/interfaz/HUD.png")).getImage();
        op = new ImageIcon(getClass().getResource("imagenes/interfaz/opciones.png")).getImage();
        es = new ImageIcon(getClass().getResource("imagenes/interfaz/estatus.png")).getImage();
        HUD = new panelBatalla();
        opciones = new panelBatalla();
        estatus =new panelBatalla();
        ene1 = new Enemigo();
        ene2 = new Enemigo();
        ene3 = new Enemigo();
        HUD.setImage(hub);
        opciones.setImage(op);
        estatus.setImage(es);

        setSize(1280, 720);
        setLayout(null);
        HUD.setLocation(0, 504);
        HUD.setSize(174, 216);
        opciones.setLocation(176, 504);
        opciones.setSize(1106,216);
        estatus.setLocation(945,396);
        estatus.setSize(335,107);
    }
}
