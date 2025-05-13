import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlowLayoutExample extends JFrame implements ActionListener {
    JCheckBox javaCheckBox, pythonCheckBox, cppCheckBox;

    public FlowLayoutExample() {
        // Set title and default operations
        super("FlowLayout with ActionListener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Set layout manager: FlowLayout with LEFT alignment, 10px horizontal gap, 20px vertical gap
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        // Create checkboxes
        javaCheckBox = new JCheckBox("Java");
        pythonCheckBox = new JCheckBox("Python");
        cppCheckBox = new JCheckBox("C++");

        // Add action listeners
        javaCheckBox.addActionListener(this);
        pythonCheckBox.addActionListener(this);
        cppCheckBox.addActionListener(this);

        // Add checkboxes to frame
        add(javaCheckBox);
        add(pythonCheckBox);
        add(cppCheckBox);

        // Make frame visible
        setVisible(true);
    }

    // Handle checkbox events
    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBox source = (JCheckBox) e.getSource();
        String status = source.getText() + (source.isSelected() ? " selected" : " deselected");
        System.out.println(status);
    }

    public static void main(String[] args) {
        // Run the GUI
        new FlowLayoutExample();
    }
}
