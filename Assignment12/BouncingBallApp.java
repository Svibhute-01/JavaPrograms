import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBallApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bouncing Blue Ball");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.add(new BallPanel());
            frame.setVisible(true);
        });
    }
}

class BallPanel extends JPanel implements MouseListener, Runnable {
    private int x = 50, y = 50;       // Ball position
    private int diameter = 30;       // Ball size
    private int dx = 2, dy = 3;      // Ball speed
    private boolean moving = false;  // Whether ball is moving

    public BallPanel() {
        setBackground(Color.WHITE);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter);
    }

    @Override
    public void run() {
        while (true) {
            if (moving) {
                x += dx;
                y += dy;

                // Bounce off edges
                if (x < 0 || x + diameter > getWidth()) {
                    dx = -dx;
                }
                if (y < 0 || y + diameter > getHeight()) {
                    dy = -dy;
                }

                repaint();
            }

            try {
                Thread.sleep(10); // Delay for smooth animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!moving) {
            moving = true;
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    // Unused mouse events
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
