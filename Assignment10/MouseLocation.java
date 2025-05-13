import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseLocation extends JFrame implements MouseMotionListener {

    JLabel label;

    public MouseLocation() {
        setTitle("Mouse Coordinate Tracker");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel("Move the mouse");
        label.setBounds(100, 100, 200, 30);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        add(label);

        addMouseMotionListener(this);

        setVisible(true);
    }

    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        label.setText("Mouse at: (" + x + ", " + y + ")");
    }

    public void mouseDragged(MouseEvent e) {
        // Optional: you can update coordinates while dragging if needed
        mouseMoved(e);
    }

    public static void main(String[] args) {
        new MouseLocation();
    }
}
