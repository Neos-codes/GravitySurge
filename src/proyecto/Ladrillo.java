package proyecto;

import java.awt.*;
import java.util.Random;

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
    
    
    /*    public void tick(){
        //este metodo se ejecuta durante cada tick del motor y actualizara
        //variables como la posicion, llamara a metodos de colisiones, etc
    } */
    
  /*  public void collision(){
        //para cuando la pelota choca con uno de estos
    } */
}
