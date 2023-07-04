import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SplashFrame extends JFrame{

	Container c;
	JLabel labAbout,labImage;	
	
	SplashFrame(){
	c=getContentPane();
	c.setLayout(new FlowLayout());
	
	labAbout = new JLabel("<html><center> Digital Clock </center> </html>");
	labImage= new JLabel(new ImageIcon("Clock.jpg"));
	Font f= new Font("Arial" ,Font.BOLD, 100);
	labImage.setBounds(0,0,0,0);	
	labAbout.setFont(f);
	labAbout.setForeground(Color.BLACK);
	c.setBackground(Color.PINK);
	
	c.add(labAbout);
	c.add(labImage);
	setUndecorated(true);	
	setSize(800, 800);
	setLocation(100,100);
	setTitle("Splash Frame");	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);

}	
}