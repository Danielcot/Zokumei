package monster.island;

import java.util.Random;
import javax.swing.JLabel;

public class Enemigo  extends JLabel{
    private int HP, ATT, DEF, fotograma, randInt, noAtaques;
    private String nombre;
    private Ataque att1, att2, att3, att4;
    private Random rand;
    public Enemigo()
    {
        rand = new Random();
        att1 = new Ataque();
        att2 = new Ataque();
        att3 = new Ataque();
        att4 = new Ataque();
        noAtaques = 0;
        randInt = 0; //Aqui hay un entero asignado al azar, que es responsable de elegir que ataque usara el enemigo
        noAtaques = 0; //el numero de ataques que puede llegar a usar un enemigo (maximo 4)
        HP = 0;
        ATT = 0;
        DEF = 0;
        nombre = "";
        fotograma = 0; //responsable de la animacion de ataque y de estar parado
    }
    public void setNombre(String nom){ //metodo para nombrar al enemigo
        this.nombre = nom;
    }
    public void setATT(int at){//metodo para darle una cantidad de ataque al enemigo
        this.ATT = at;
    }
    public void setDEF(int def){//metodo para darle una cantidad de defensa al enemigo
        this.DEF = def;
    }
    public void setHP(int hp){//metodo para darle una cantidad de vida al enemigo
        this.HP = hp;
    }
    public String getNombre(){//metodo para obtener el nombre del enemigo
        return this.nombre;
    }
    public int getHP(){//metodo para obtener la vida del enemigo
        return this.HP;
    }
    public int getDEF(){//metodo para obtener la defensa del enemigo
        return this.DEF;
    }
    public int getATT(){//metodo para obtener el ataque del enemigo
        return this.ATT;
    }
    public int Ataca(){ //Metodo para iniciar la animacion de ataque y dar un valor de daño que aplicara el enemigo
        switch(randInt){//utiliza un entero generado al azar
            case 0:
                att1.Atacar();//Inicia la animacion de golpe
                fotograma = 4;//fotograma de ataque
                return att1.getDamage()+this.getATT();//daño aplicado
            case 1:
                att2.Atacar();
                fotograma = 4;//fotograma de ataque
                return att2.getDamage()+this.getATT();//daño aplicado
            case 2:
                att3.Atacar();//Inicia la animacion de golpe
                fotograma = 4;//fotograma de ataque
                return att3.getDamage()+this.getATT();//daño aplicado
            case 3:
                att4.Atacar();//Inicia la animacion de golpe
                fotograma = 4;//fotograma de ataque
                return att4.getDamage()+this.getATT();//daño aplicado
        }
        return -1;//en caso de que falle por mal codigo
    }
    public void setAtaque1Daño(int i){//metodo para ponerle valor de daño al ataque1
        att1.setDamage(i);
    }
    public void setAtaque2Daño(int i){//metodo para ponerle valor de daño al ataque2
        att1.setDamage(i);
    }
    public void setAtaque3Daño(int i){//metodo para ponerle valor de daño al ataque3
        att1.setDamage(i);
    }
    public void setAtaque4Daño(int i){//metodo para ponerle valor de daño al ataque4
        att1.setDamage(i);
    }
    public void setAtaque1Nombre(String attNom){//metodo para ponerle nombre al ataque1
        att1.setNomAtt(attNom);
    }
    public void setAtaque2Nombre(String attNom){//metodo para ponerle nombre al ataque1
        att2.setNomAtt(attNom);
    }
    public void setAtaque3Nombre(String attNom){//metodo para ponerle nombre al ataque1
        att3.setNomAtt(attNom);
    }
    public void setAtaque4Nombre(String attNom){//metodo para ponerle nombre al ataque1
        att4.setNomAtt(attNom);
    }
    public void setNoAtaques(int no){//metodo para poner el numero de ataques que puede tener el enemigo (maximo 4) 
        this.noAtaques = no;
        switch(noAtaques){ //si el numero de ataques es menor a 4 se elimina toda referencia a los ataques no usados
            case 0:
                att2 = null;
                att3 = null;
                att4 = null;
                break;
            case 1:
                att3 = null;
                att4 = null;
                break;
            case 2:
                att4 = null;
                break;
            case 3:
                break;
        }
    }
    public int getFotograma(){//metodo para obtener el fotograma actual
        return this.fotograma;
    }
}
