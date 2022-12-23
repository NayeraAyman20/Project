
package Textures.Example1;

//import com.sun.opengl.util.FPSAnimator;

import com.sun.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;


//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import javax.media.opengl.*;

public class BouncedBall extends JFrame {
   private GLCanvas glcanvas;
  static FPSAnimator animator=null;
  private BouncedBall2 listener=new BouncedBall2();   
 
  
  public static void main(String[] args) {
     BouncedBall app= new BouncedBall();
      animator.start();
    // show what we've done
/*    SwingUtilities.invokeLater (
      new Runnable() {
        public void run() {
          app.setVisible(true);
        }
      }
    );*/
  }
   public BouncedBall() {
    //set the JFrame title
    super("Bounced Ball");

    //kill the process when the JFrame is closed
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //only three JOGL lines of code ... and here they are 
    GLCanvas glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);
    animator= new FPSAnimator(glcanvas,60);
    
    // add the GLCanvas just like we would	 any Component
    add(glcanvas, BorderLayout.CENTER);
    setSize(1100,700);

    //center the JFrame on the screen
    centerWindow();
    setVisible(true);
    
   
  }
   public void centerWindow() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize  = this.getSize();

    if (frameSize.width  > screenSize.width ) frameSize.width  = screenSize.width;
    if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;

    this.setLocation (
      (screenSize.width  - frameSize.width ) >> 1, 
      (screenSize.height - frameSize.height) >> 1
    );
  }
    
}
