/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster.island;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Mapa extends JPanel{
    private Personaje personaje;
    final AudioClip oyasumi;
    private String nombre, texto;
    private JLabel talk, tiles[][], superior[][];
    private boolean flagPausa;
    private JLayeredPane capitas;
    private boolean esCaminable[][];
    private int images[][], superiorima[][];
    private int i, ii, buyXright, buyYup,buyYdown,buyXleft, x, y, j, jj, randInt;
    private Random rand;
    private CampoBatalla guerra;
    public Mapa(){
        super();
            rand = new Random();
            flagPausa = false;
            i = 0;
            ii = 0;
            j = 0;
            jj = 0;
            nombre = "";
            texto = "";
            buyXleft = 0;
            buyYup = 0;
            buyYdown = 0;
            buyXright = 0;
            randInt = 0;
            guerra = null;
            talk = new JLabel(new ImageIcon(getClass().getResource("imagenes/interfaz/canDo.png")));
            personaje = new Personaje(1);
            personaje.setLocation(80, 160);
            talk.setLocation(personaje.getLocation().x, personaje.getLocation().y - 40);
            talk.setSize(40, 40);
            x = personaje.getLocation().x / 40;
            y = personaje.getLocation().y / 40;
            capitas = new JLayeredPane();
            int images[][] = new int [][]{
                {1, 2, 3, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22},
                {4, 5, 6, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22},
                {7, 8, 9, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 39, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33},
                {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 72, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 72, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 10, 11, 51, 51, 51, 10, 11, 51, 51, 51, 51, 51, 51, 51, 10, 11, 51, 51, 51, 51, 51, 51, 51, 10, 11, 72, 53, 53, 53, 53, 53, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 10, 11, 51, 10, 11, 51, 51, 51, 51, 10, 11, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 73, 52, 52, 71, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 72, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 25, 26, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 24, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 73, 52, 71, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {10, 11, 51, 51, 24, 51, 51, 51, 51, 70, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 24, 51, 73, 52, 71, 59, 55, 55, 55, 60, 53, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 25, 26, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 10, 11, 51, 51, 10, 11, 51, 51, 51, 24, 51, 51, 72, 25, 26, 54, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 10, 11, 12, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 13, 53, 53, 54, 53, 41, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {10, 11, 51, 61, 62, 63, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 21, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 53, 53, 54, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 25, 26, 53},
                {51, 51, 51, 64, 65, 66, 51, 40, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 20, 20, 20, 20, 18, 53, 53, 54, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 67, 68, 69, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 18, 53, 53, 54, 53, 53, 53, 54, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 42, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 24, 51, 51, 51, 51, 16, 20, 20, 20, 20, 21, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 53, 53, 54, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 25, 26, 54, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 10, 11, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 53, 59, 58, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 20, 20, 20, 20, 18, 53, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 20, 20, 20, 20, 20, 20, 18, 53, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 41, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 10, 11, 51, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 41, 54, 25, 26, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 16, 20, 20, 21, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 53, 54, 53, 53, 53, 53, 54, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53},
                {51, 51, 51, 24, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 53, 54, 53, 43, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 14, 49, 49, 49, 49, 50, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 15, 53, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53, 29, 29, 29, 29, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 10, 11, 51, 51, 51, 73, 52, 71, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 59, 55, 55, 55, 55, 58, 53, 53, 53, 53, 54, 53, 53, 53, 53, 30, 30, 30, 30, 59, 55, 55, 55, 55, 60, 53, 53, 53, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 73, 71, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 41, 54, 53, 53, 53, 53, 30, 30, 32, 30, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53},
                {10, 11, 51, 51, 51, 51, 51, 51, 73, 52, 71, 53, 53, 25, 26, 53, 53, 53, 53, 53, 25, 26, 25, 26, 53, 54, 53, 53, 53, 25, 26, 53, 53, 53, 53, 54, 53, 53, 53, 53, 30, 31, 30, 30, 54, 53, 53, 53, 53, 54, 53, 27, 28, 53},
                {51, 51, 51, 51, 51, 51, 51, 51, 72, 53, 44, 25, 26, 53, 53, 59, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 53, 53, 53, 53, 47, 54, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53},
                {51, 51, 51, 73, 52, 52, 52, 52, 71, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 59, 55, 55, 58, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53},
                {10, 11, 51, 72, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 54, 53, 27, 28, 53},
                {51, 51, 73, 71, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 29, 29, 29, 29, 54, 53, 53, 53, 53},
                {51, 51, 72, 53, 53, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53, 59, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 30, 30, 30, 30, 57, 55, 55, 60, 53},
                {52, 52, 71, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 30, 32, 30, 30, 53, 53, 53, 54, 53},
                {55, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 46, 53, 53, 53, 53, 25, 26, 54, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 30, 30, 31, 30, 53, 53, 53, 54, 53},
                {53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53},
                {53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53},
                {53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53},
                {53, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 29, 29, 29, 29, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 41, 54, 53, 53, 30, 30, 30, 30, 54, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53},
                {53, 53, 25, 26, 54, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 54, 53, 53, 30, 30, 32, 30, 54, 53, 29, 29, 29, 29, 53, 53, 53, 53, 53, 53, 53},
                {53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 30, 31, 30, 30, 54, 53, 30, 30, 30, 30, 53, 53, 53, 53, 53, 53, 53},
                {53, 53, 53, 53, 54, 53, 53, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 54, 53, 30, 30, 32, 30, 53, 48, 53, 53, 53, 53, 53},
                {53, 53, 53, 53, 54, 53, 25, 26, 53, 53, 53, 45, 53, 53, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 59, 55, 58, 53, 30, 31, 30, 30, 53, 53, 53, 53, 53, 53, 53},
                {53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 29, 29, 29, 29, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {53, 53, 53, 41, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 30, 30, 30, 30, 53, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {25, 26, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 30, 30, 32, 30, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
                {53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 30, 31, 30, 30, 53, 53, 53, 53, 53, 29, 29, 29, 29, 53, 53, 53, 53, 53, 54, 53, 53, 53, 34, 34, 34, 53, 53, 53, 53, 53, 34, 34, 34},
                {53, 53, 53, 53, 57, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 30, 30, 30, 30, 53, 53, 53, 53, 53, 54, 53, 53, 53, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34},
                {53, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 30, 32, 30, 30, 53, 53, 53, 53, 53, 54, 53, 53, 53, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34},
                {41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 30, 30, 31, 30, 53, 53, 53, 53, 53, 54, 53, 53, 53, 34, 34, 34, 34, 34, 36, 37, 34, 34, 34, 34},
                {53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 34, 34, 34, 34, 34, 35, 38, 34, 34, 34, 34},
                {53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53},
                {53, 53, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 57, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53}
            };
        capitas.setLocation(0, 0);
        capitas.setSize(2160, 2160);
        oyasumi = java.applet.Applet.newAudioClip(getClass().getResource("audio/35.wav"));
        oyasumi.play();
        JLabel tiles[][] = new JLabel[54][54];
        for(i = 0;i < tiles.length;i++){
            for(ii = 0;ii < tiles[i].length;ii++){
                tiles[i][ii] = new JLabel(new ImageIcon(getClass().getResource("imagenes/mapa/"+images[ii][i]+".png")));
                tiles[i][ii].setSize(40, 40);
                tiles[i][ii].setLocation(i*40, ii*40);
                capitas.add(tiles[i][ii], new Integer(1));
            }
        }
        int superiorima[][] = new int [][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 81, 0, 0, 0, 80, 81, 0, 0, 0, 0, 0, 0, 0, 80, 81, 0, 0, 0, 0, 0, 0, 0, 80, 81, 0, 0, 0, 0, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 80, 81, 0, 80, 81, 0, 82, 83, 0, 80, 81, 82, 83, 0, 0, 0, 0, 0, 0, 0, 82, 83, 0, 0, 0, 0, 0, 0, 0, 82, 83, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 82, 83, 0, 82, 83, 0, 0, 0, 0, 82, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 0},
            {80, 81, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 84, 85, 0},
            {82, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 81, 0, 0, 80, 81, 0, 0, 0, 0, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0},
            {0, 0, 0, 0, 0, 0, 80, 81, 0, 0, 0, 0, 0, 0, 0, 0, 82, 83, 0, 0, 82, 83, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {80, 81, 0, 0, 0, 0, 82, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 84, 85, 0},
            {82, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 80, 81, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 82, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 76, 77, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 78, 79, 76, 77, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 78, 79, 0, 0, 0, 0, 0, 0, 0},
            {0, 80, 81, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 82, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 76, 77, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 78, 79, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 80, 81, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 82, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {80, 81, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 84, 85, 84, 85, 0, 0, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 76, 77, 0},
            {82, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 84, 85, 86, 87, 0, 0, 0, 0, 0, 86, 87, 86, 87, 0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 78, 79, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {80, 81, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 76, 77, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 76, 77, 0},
            {82, 83, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 78, 79, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 78, 79, 0},
            {0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 76, 77, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 78, 79, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 76, 77, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 84, 85, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 78, 79, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 75, 75, 75, 0, 0, 0, 0, 0, 75, 75, 75},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 75, 75, 75, 75, 75, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 76, 77, 0, 0, 0, 0, 0, 0, 0, 0, 0, 76, 77, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 84, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 78, 79, 0, 0, 0, 0, 0, 0, 0, 76, 77, 78, 79, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 86, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 78, 79, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        JLabel superior[][] = new JLabel[54][54];
        for(i = 0;i < superior.length;i++){
            for(ii = 0;ii < superior[i].length;ii++){
                superior[i][ii] = new JLabel(new ImageIcon(getClass().getResource("imagenes/mapa/"+superiorima[ii][i]+".png")));
                superior[i][ii].setSize(40, 40);
                superior[i][ii].setLocation(i*40, ii*40);
                capitas.add(superior[i][ii], new Integer(3));
            }
        }
        final boolean esCaminable[][] = new boolean[54][54];
            for(j = 0;j < esCaminable.length;j++){
                for(jj = 0;jj < esCaminable[j].length;jj++){
                    if(images[jj][j] <= 50){
                        esCaminable[j][jj] = false;
                    }
                    else{
                        esCaminable[j][jj] = true;
                    }
                }
            }
        this.setBackground(new Color(0, 76, 0));
        this.setLocation(0, 0);
        this.setSize(2200, 2160);
        this.setLayout(null);
        this.add(capitas);
        capitas.add(personaje, new Integer(2));
        capitas.add(talk, new Integer(2));
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode()==KeyEvent.VK_SPACE)
                {
                    x = personaje.getLocation().x / 40;
                    y = personaje.getLocation().y / 40;
                   if((y >= 12 && y <= 14) && (x >= 6 && x <= 7)){ //Aqui se pone el rango en que se puede hablar con un personaje y lo que este se va a decir, para nuevo rango y dialogo copiar todo y cambiar nombre, texto y condicion
                       nombre = "skull";
                       texto = "MAMA MIA";
                       getMe().setFocusable(false);
                   }
                   else if((y >= 13 && y <= 15) && (x >= 46 && x <= 48)){
                       nombre = "guy in a rock";
                       texto = "Que onda carnal";
                       getMe().setFocusable(false);
                   }
                   else if((y >= 27 && y <= 29) && (x >= 9 && x <= 12)){
                       nombre = "ghost";
                       texto = "buuu..... te asuste?";
                       getMe().setFocusable(false);
                   }
                   else if((y >= 42 && y <= 44) && (x >= 10&& x <= 12)){
                       nombre = "vikingo";
                       texto = "Que onda carnal";
                       getMe().setFocusable(false);
                   }
                   else if((y >= 33 && y <= 35) && (x >= 26 && x <= 28)){
                       nombre = "Maradona Goku";
                       texto = "Hola soy Goku";
                       getMe().setFocusable(false);
                   }
                   else if((y >= 22 && y <= 24) && (x >= 31 && x <= 33)){
                       nombre = "campesino";
                       texto = "Que onda carnal";
                       getMe().setFocusable(false);
                   }
                   else if((y >= 41 && y <= 43) && (x >= 47 && x <= 49)){
                       nombre = "knight";
                       texto = "Que onda carnal";
                       getMe().setFocusable(false);
                   }
                }
                else if(ke.getKeyCode()==KeyEvent.VK_DOWN){
                    x = personaje.getLocation().x / 40;
                    y = personaje.getLocation().y / 40;
                    if(!(personaje.getLocation().y == 2040)){
                        if(personaje.getLocation().y == 600+(buyYdown*40)){
                            getMe().setLocation(getMe().getLocation().x, getMe().getLocation().y - 40);
                            buyYup--;
                            buyYdown++;   
                        }
                    }
                    if(!(personaje.getLocation().y == 2120)){
                        if(esCaminable[x][y+1] == true){
                            personaje.muevete(3);     
                            randInt = rand.nextInt(149);
                            if(randInt == 3){
                                guerra = new CampoBatalla();
                                guerra.addWindowListener(new WindowAdapter() {
                                    public void windowClosed(WindowEvent we){
                                    }
                                });
                            }
                        }
                    }
                    if((y >= 12 && y <= 14) && (x >= 6 && x <= 7)){
                        talk.setLocation(personaje.getLocation().x, personaje.getLocation().y - 40);
                        talk.setVisible(true);
                    }
                    else{
                        talk.setVisible(false);
                    }
                }
                else if (ke.getKeyCode()==KeyEvent.VK_LEFT)
                {
                    x = personaje.getLocation().x / 40;
                    y = personaje.getLocation().y / 40;
                    if((personaje.getLocation().x >120)){   
                        if(personaje.getLocation().x == 120-(buyXleft*40)){
                            getMe().setLocation(getMe().getLocation().x + 40, getMe().getLocation().y);
                            buyXright--;
                            buyXleft++;
                        }
                    }
                    if(!(personaje.getLocation().x == 0)){
                        if(esCaminable[x-1][y] == true){
                            personaje.muevete(4);      
                            randInt = rand.nextInt(149);
                            if(randInt == 3){
                                guerra = new CampoBatalla();
                            }
                        }
                    }
                    if((y >= 12 && y <= 14) && (x >= 6 && x <= 7)){
                        talk.setLocation(personaje.getLocation().x, personaje.getLocation().y - 40);
                        talk.setVisible(true);
                    }
                    else{
                        talk.setVisible(false);
                    }
                }
                else  if (ke.getKeyCode()==KeyEvent.VK_UP)
                {
                    x = personaje.getLocation().x / 40;
                    y = personaje.getLocation().y / 40;
                    if((personaje.getLocation().y > 120)){
                        if(personaje.getLocation().y == 120-(buyYup*40)){
                            getMe().setLocation(getMe().getLocation().x, getMe().getLocation().y + 40);
                            buyYup++;
                            buyYdown--;
                        }
                    }    
                if(esCaminable[x][y-1] == true){
                    personaje.muevete(1);      
                    randInt = rand.nextInt(149);
                            if(randInt == 3){
                                guerra = new CampoBatalla();
                            }
                }
                if((y >= 12 && y <= 14) && (x >= 6 && x <= 7)){
                    talk.setLocation(personaje.getLocation().x, personaje.getLocation().y - 40);
                    talk.setVisible(true);
                }
                else{
                    talk.setVisible(false);
                }
                }
                else if (ke.getKeyCode()==KeyEvent.VK_RIGHT)
                {
                    x = personaje.getLocation().x / 40;
                    y = personaje.getLocation().y / 40;
                    if(!(personaje.getLocation().x == 2040)){
                        if(personaje.getLocation().x == 600+(buyXright*40)){
                            getMe().setLocation(getMe().getLocation().x - 40, getMe().getLocation().y);
                            buyXright++;
                            buyXleft--;
                        }
                    }
                    if(!(personaje.getLocation().x == 2120)){
                        if(esCaminable[x+1][y] == true){
                            personaje.muevete(2);    
                            randInt = rand.nextInt(149);
                            if(randInt == 3){
                                guerra = new CampoBatalla();
                            }
                        }
                    }   
                    if((y >= 12 && y <= 14) && (x >= 6 && x <= 7)){
                        talk.setLocation(personaje.getLocation().x, personaje.getLocation().y - 40);
                        talk.setVisible(true);
                    }
                    else{
                        talk.setVisible(false);
                    }
                }
            }
        });
    }
    public AudioClip getOyasumi(){
        return oyasumi;
    }
    private Mapa getMe(){
        return this;
    }
    public boolean isPaused(){
        return flagPausa;
    }
    public String getNombre(){
        return nombre;
    }    
    public String getTexto(){
        return texto;
    }
}
 