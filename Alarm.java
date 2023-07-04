
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Alarm extends JFrame {
    private JLabel timeLabel;
    private JButton setButton;

    public Alarm() {
        setTitle("Alarm");
	setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        timeLabel = new JLabel();
        add(timeLabel);

        setButton = new JButton("Set Alarm");
        add(setButton);
	setVisible(true);
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String alarmTime = JOptionPane.showInputDialog("Enter alarm time (HH:mm:ss):");
                startAlarm(alarmTime);
            }
        });
    }

    private void startAlarm(String alarmTime) {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarm = LocalTime.parse(alarmTime, formatter);

        while (!currentTime.isAfter(alarm)) {
            currentTime = LocalTime.now();
            String currentTimeString = currentTime.format(formatter);
            timeLabel.setText("Current Time: " + currentTimeString);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        JOptionPane.showMessageDialog(null, "Alarm!" + "\nTime's up!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Alarm().setVisible(true);
            }
        });
    }
}