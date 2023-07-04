import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class Stopwatch extends JFrame implements ActionListener {
    JLabel label;
    JButton start, stop, reset;
    long startTime = 0;
    Timer timer;

    public Stopwatch() {
        label = new JLabel("00:00:00");
        start = new JButton("Start");
        stop = new JButton("Stop");
        reset = new JButton("Reset");

        start.addActionListener(this);
        stop.addActionListener(this);
        reset.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(start);
        panel.add(stop);
        panel.add(reset);

        add(panel, BorderLayout.SOUTH);
        add(label, BorderLayout.CENTER);

        setTitle("My Stopwatch");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            startTime = System.currentTimeMillis();
            timer = new Timer(100, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    long elapsedTime = System.currentTimeMillis() - startTime;
                    String formattedTime = String.format("%02d:%02d:%02d", 
                        TimeUnit.MILLISECONDS.toHours(elapsedTime),
                        TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - 
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(elapsedTime)),
                        TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - 
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedTime)));
                    label.setText(formattedTime);
                }
            });
            timer.start();
        } else if (e.getSource() == stop) {
            timer.stop();
        } else if (e.getSource() == reset) {
            timer.stop();
            label.setText("00:00:00");
        }
    }
}