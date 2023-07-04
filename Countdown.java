
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Countdown extends JFrame implements ActionListener {
    private JLabel timeLabel;
    private JTextField timeText;
    private JButton startButton;
    private Timer timer;
    private int timeRemaining;

    public Countdown() {
        super("Countdown Timer");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timeLabel = new JLabel("Enter time in seconds:");
        add(timeLabel);

        timeText = new JTextField(10);
        add(timeText);

        startButton = new JButton("Start");
        add(startButton);
        startButton.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
	setSize(300, 200);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            timeRemaining = Integer.parseInt(timeText.getText());
            timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (timeRemaining <= 0) {
                        timer.stop();
                        JOptionPane.showMessageDialog(null, "Time is up!");
                    } else {
                        timeLabel.setText("Time remaining: " + timeRemaining);
                        timeRemaining--;
                    }
                }
            });
            timer.start();
        }
    }

    public static void main(String[] args) {
        new Countdown();
    }
}