import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopwatchApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StopwatchFrame();
        });
    }
}

class StopwatchFrame extends JFrame {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private volatile boolean running = false;
    private int elapsedSeconds = 0;
    private Thread timerThread;

    public StopwatchFrame() {
        setTitle("Stopwatch");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        timeLabel = new JLabel(formatTime(elapsedSeconds), SwingConstants.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        add(timeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener(e -> start());
        stopButton.addActionListener(e -> stop());
        resetButton.addActionListener(e -> reset());

        setVisible(true);
    }

    private void start() {
        if (!running) {
            running = true;
            timerThread = new Thread(() -> {
                while (running) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        return;
                    }

                    elapsedSeconds++;
                    SwingUtilities.invokeLater(() -> timeLabel.setText(formatTime(elapsedSeconds)));
                }
            });
            timerThread.start();
        }
    }

    private void stop() {
        running = false;
    }

    private void reset() {
        stop();
        elapsedSeconds = 0;
        timeLabel.setText(formatTime(elapsedSeconds));
    }

    private String formatTime(int totalSeconds) {
        int hrs = totalSeconds / 3600;
        int mins = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hrs, mins, secs);
    }
}
