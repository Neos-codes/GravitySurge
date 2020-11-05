package proyecto.Objetos;

import java.awt.*;
import java.util.Random;
import proyecto.Interfaz.PanelDibujo;

public class Ladrillo {
    public int x,y,hp;
    private int ancho = 50, alto = 20;
    private int rand;
    private PanelDibujo dp;
    private Random r = new Random(System.currentTimeMillis());
  
    private Color block_color;
    
    public Point upleft;
    public Point upright;
    public Point downleft;
    public Point downright;
    
    public Ladrillo(int x, int y, int hp,PanelDibujo dp){
        this.x=x;
        this.y=y;
        this.hp=hp;
        this.dp = dp;
        
        
        upleft = new Point(x,y);
        upright = new Point(x + ancho,y);
        downleft = new Point(x, y + alto);
        downright = new Point(x + ancho , y + alto);
        
        if(hp > 2)
            block_color = Color.GRAY; // color gris para ladrillo
        else{
            this.rand = r.nextInt(8);    // Cualquier color menos gris
            Color[] colores = {Color.RED , Color.BLUE, Color.CYAN, Color.MAGENTA,
            Color.ORANGE, Color.PINK, Color.WHITE, Color.YELLOW}; // son 9
            
            block_color = colores[rand];
        }

        
        
        
    }
    
    
    public void paint(Graphics g){
        g.setColor(block_color);
        g.fillRect(x, y, ancho, alto);
       
        // Pintar Border del Ladrillo
        g.setColor(Color.blue);
        g.drawLine(upleft.x, upleft.y, upright.x, upright.y);
        g.drawLine(upleft.x, upleft.y, downleft.x,downleft.y);
        g.drawLine(downleft.x, downleft.y ,downright.x,downright.y);
        g.drawLine(downright.x, downright.y,upright.x,upright.y);
        
        
    }
    
    
    public Point collision(Rectangle ball){
        //esta es la colision usada para los bloques
        Point p = new Point (1,1);
        Rectangle tRect = new Rectangle(x,y,ancho,2);
        Rectangle bRect = new Rectangle(x,y+18,ancho,2);
        Rectangle lRect = new Rectangle(x,y,2,alto);
        Rectangle rRect = new Rectangle(x+48,y,2,alto);
        if (tRect.intersects(ball) || bRect.intersects(ball)){
            p.y = -1;
        }
        if (rRect.intersects(ball) || lRect.intersects(ball)){
            p.x = -1;
        }
        if(p.x<0 || p.y<0){
            this.hp=hp-1;
            System.out.println("Hp = "+ hp);
            if(hp==0){                
                System.out.println("delet dis");
            }
                    
        }
        return p;
    }
    public int getHp(){
        return hp;
    }
}
