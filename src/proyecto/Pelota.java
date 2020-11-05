package proyecto;

import java.awt.*;

public class Pelota {
    private int x,y;
    private double velY=7, velX=10;
    private double vectorVel = Math.sqrt(velX*velX+velY*velY);
    private double discriminante = vectorVel*vectorVel-(velX*velX);
    private int radio = 5;
    private PanelDibujo dp;
    public Pelota(int x, int y,PanelDibujo dp){
        this.x=x;
        this.y=y;
        this.dp = dp;
    }
    public void tick(){
        y=y+(int)velY;
        x=x+(int)velX;
        this.checkCollisions();
       // System.out.println("y es " + velY);
    }
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillOval(x-radio,y-radio,2*radio,2*radio);
        
    }
    public void checkCollisions(){
        
        Point north = new Point(this.x, this.y-radio);
        Point south = new Point(this.x,this.y+radio);
        Point east = new Point(this.x+radio,this.y);
        Point west = new Point(this.x-radio,this.y); 
        
        int downx = this.x;
        int downy = this.y+radio;
        
        //-----COLISIONADOR PARA LA BARRA-----//
        
        if(south.x >= (dp.b.x-30) && south.x <= (dp.b.x+30) && south.y >= dp.b.y && south.y <= dp.b.y +8){
            System.out.println("Colision con barra!");
                velX = (double)(south.x - dp.b.x)/(double)3;  //Calcular distancia del centro de la barra   
                                                    // con el punto de choque de la bola     
            discriminante = vectorVel*vectorVel-(velX*velX); //con esto obtenemos la
            discriminante = Math.sqrt(discriminante);  //velocidad en y, para que la
                                                       //aceleracion se mantenga constante                                           
            velY = -1* discriminante;
            if(velY >= 0) velY += 3;
            else velY -= 3;
            
            if(velX >= 0) velX += 3;
            else velX -= 3;
            // NO BORRAR ESTE SANITY CHECK! CALCULA VECTORES X,Y ADEMAS DE LA HIPOTENUSA 
            
         //   System.out.println("pixel "+ (x));
            System.out.println("x: "+velX+"y: "+velY +"Total: " + Math.sqrt(velX*velX + velY*velY));
        }
        
        //---------------------------------//
        
        
        //-----COLISIONADOR PARA LOS BLOQUES-----//
        else{
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 4; j++){
                    if(north.x >= dp.Blocks[i][j].downleft.x && north.x <= dp.Blocks[i][j].downright.x &&
                    north.y <= (dp.Blocks[i][j].downleft.y + 5) && north.y >= (dp.Blocks[i][j].downleft.y-10)){
                        dp.Blocks[i][j].hp-=1;
                        System.out.println("Choqué por abajo!   HP: " + dp.Blocks[i][j].hp);
                        velY *= -1;
                    }
                    else if(south.x >= dp.Blocks[i][j].upleft.x && south.x <= dp.Blocks[i][j].upright.x &&
                    south.y <= (dp.Blocks[i][j].upleft.y-5) && south.y >= (dp.Blocks[i][j].upleft.y + 5) ){
                        dp.Blocks[i][j].hp-=1;
                        System.out.println("Choqué por arriba!   HP: " + dp.Blocks[i][j].hp);
                        velY *= -1;
                    }
                }
            }
        }
        
        
        //----------------------------------------//

        //-----COLISIONADOR PARA LOS BORDES DE LA PANTALLA-----//
        if (y > (600 - 2*radio ) || y < (50 + 2*radio)){
            velY = -velY;
        }
        if (x > (500 - 2*radio) || x <( 100 + 2*radio)){
            velX = -velX;
        }
        //-----------------------------------------------------//
    }
}
