import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleTimer extends JFrame implements ActionListener {

    JLabel timeLabel;
    JButton startBtn, stopBtn;
    Timer timer;
    int seconds = 0;

    public SimpleTimer() {
        setTitle("Simple Timer");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        timeLabel = new JLabel("Time: 0 sec");
        timeLabel.setBounds(90, 30, 150, 30);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(timeLabel);

        startBtn = new JButton("Start");
        startBtn.setBounds(50, 100, 80, 30);
        add(startBtn);

        stopBtn = new JButton("Stop");
        stopBtn.setBounds(150, 100, 80, 30);
        add(stopBtn);

        startBtn.addActionListener(this);
        stopBtn.addActionListener(this);

        // Timer: fires every 1000 ms (1 sec), increments seconds
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seconds++;
                timeLabel.setText("Time: " + seconds + " sec");
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) {
            timer.start();
        } else if (e.getSource() == stopBtn) {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        new SimpleTimer();
    }
}
