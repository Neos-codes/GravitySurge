
package proyecto;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class PanelDibujo extends JPanel implements MouseMotionListener{
    
    Pelota p;
    Barra b;
    Ladrillo l;
    Ladrillo[][] Blocks = new Ladrillo[6][4];
    
    
    private Clock clk;
    public PanelDibujo(){
        
        int xgrid = 150;
        int ygrid = 150;
        
        this.setBackground(Color.gray);
        clk = new Clock();
        p = new Pelota(300,300,this);
        b = new Barra(300,500,this);
        
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 4; j++){
                Blocks[i][j] = new Ladrillo(xgrid + 50*i, ygrid + 20*j, 1 , this);
            }
        }
        repaint();
        addMouseMotionListener(this);
        
    }
    
    public void paint (Graphics g){
        super.paint(g);
        g.setColor(Color.green);  //Color del fondo
        g.fillRect(100,50,400,550);
        g.setColor(Color.blue);
        p.paint(g);
        b.paint(g);
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 4; j++){
                Blocks[i][j].paint(g);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
        
        if(me.getX() >= 130 && me.getX() <= 470)
            b.setX(me.getX());
        else{
        if(me.getX() < 130)
            b.setX(130);
        if(me.getX() > 470)
            b.setX(470);
        }
    }
    
    public class Clock implements ActionListener{
        private Timer t;
        private int currentTime=0;
        private int clkSpeed=1000;
        public Clock(){
            t = new Timer(50,null); 
            t.addActionListener(this);
            t.start();
            //esto gobernara el tickrate del motor, que sera 20 ticks por segundo

        }
        @Override
        public void actionPerformed(ActionEvent ae){
          //  System.out.println(currentTime);
            currentTime++;
            repaint();
            p.tick();
            
        }

    }
}

