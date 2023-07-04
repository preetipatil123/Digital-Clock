import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class WorldClock extends JFrame {
    private JComboBox<String> timezoneComboBox;
    private JLabel timeLabel;

    public WorldClock() {
        initUI();
    }

    private void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
	setLocationRelativeTo(null);
        setTitle("World Clock");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
	setVisible(true);

        timezoneComboBox = new JComboBox<>();
        List<String> timezones = new ArrayList<>(ZoneId.getAvailableZoneIds());
        timezones.sort(String::compareToIgnoreCase);
        for (String timezone : timezones) {
            timezoneComboBox.addItem(timezone);
        }
        timezoneComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTimeInSelectedTimezone();
            }
        });

        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));

        add(timezoneComboBox, BorderLayout.NORTH);
        add(timeLabel, BorderLayout.CENTER);

        showTimeInSelectedTimezone();
    }

    private void showTimeInSelectedTimezone() {
        String selectedTimezone = (String) timezoneComboBox.getSelectedItem();
        LocalDateTime now = LocalDateTime.now(ZoneId.of(selectedTimezone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        timeLabel.setText(now.format(formatter));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WorldClock worldClock = new WorldClock();
            worldClock.setVisible(true);
        });
    }
}
