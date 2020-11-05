package proyecto;

import java.awt.Color;
import java.awt.Graphics;

public class Barra{
    public int x,y;
    private PanelDibujo dp;
    
    public Barra(int x, int y, PanelDibujo dp){
        this.x = x;
        this.y = y;
        this.dp = dp;
    }
    public void tick(){
        //este metodo se ejecuta durante cada tick del motor y actualizara
        //variables como la posicion, llamara a metodos de colisiones, etc
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x-30,y,60,8);   //  (x - 30 , y ) es el punto de dibujo
        
        
        // Pintar linea sobre Barra
       /* g.setColor(Color.blue);
        g.drawLine(x-30,y,x+30,y); */
    }
    public void setX(int x){   //setea la posicion en x de la barra
        this.x = x; 
    }
    public void setY(int y){   //setea la posicion en y de la barra
        this.y = y;
    }

}