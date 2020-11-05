
package proyecto;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Window extends JFrame {
    private PanelDibujo pd;
    public Window(){
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pd = new PanelDibujo();
        this.add(pd,BorderLayout.CENTER);


        this.setSize(600,800);
        this.setVisible(true);
    }

}



    