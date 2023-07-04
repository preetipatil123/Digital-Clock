import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;
import javax.swing.Timer;

class App1 extends JFrame implements ActionListener{

	Container c;	
	SimpleDateFormat timeFormat;
	JLabel timeLabel,labAbout;
	String time;
	
	JButton 	btnTime,btnWorldClock,btnCountdown,btnAlarm,btnStopwatch;
	
	App1()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		labAbout = new JLabel(" C    L    O    C    K ");
		btnTime = new JButton("Time");
		btnStopwatch = new JButton("Stop Watch");
		btnWorldClock = new JButton("WorldClock");
		btnCountdown= new JButton("Countdown Timer");	
		btnAlarm= new JButton("Alarm");	
		timeLabel= new JLabel(); 
	
		Font f= new Font("Impact" ,Font.BOLD +Font.ITALIC,50);
		
		btnStopwatch.setFont(f);
		btnTime.setFont(f);
		btnWorldClock.setFont(f);
		btnCountdown.setFont(f);
		btnAlarm.setFont(f);
		labAbout.setFont(f);
		labAbout.setForeground(Color.BLACK);
		c.setBackground(Color.MAGENTA);
		
		btnTime.setBounds(350,650,350,50);
		btnStopwatch.setBounds(350,350,350,50);
		btnWorldClock.setBounds(350,550,350,50);
		btnCountdown.setBounds(350,650,350,50);
		btnAlarm.setBounds(350,750,350,50);
		
		btnTime.addActionListener(this);
		btnStopwatch.addActionListener(this);
		btnCountdown.addActionListener(this);
		btnWorldClock.addActionListener(this);
		btnAlarm.addActionListener(this);
		c.add(labAbout);	
		c.add(btnTime);
		c.add(btnStopwatch);
		c.add(btnCountdown);
		c.add(btnWorldClock);
		c.add(btnAlarm);
		


	setTitle("CLOCK");
	setSize(500,1000);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
}
	public void actionPerformed(ActionEvent e){
	if(e.getSource()==btnTime)
{
	Format f = new SimpleDateFormat("HH.mm.ss");
	String strResult = f.format(new Date());
	JOptionPane.showMessageDialog(c,"Time = "+strResult);

}
	else if(e.getSource()==btnStopwatch)
{ 	
	Stopwatch s= new Stopwatch();
}
	else if(e.getSource()==btnCountdown)
{

	 Countdown c= new  Countdown();
}
	else if(e.getSource()==btnWorldClock)
{
	WorldClock w= new WorldClock();

}
	else if(e.getSource()==btnAlarm)
{
	Alarm a = new Alarm();

}
}
	
}



















