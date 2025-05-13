import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextCounterGUI extends JFrame implements KeyListener {
    private JTextArea textArea;
    private JLabel countLabel;

    public TextCounterGUI() {
        setTitle("Live Text Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center window

        textArea = new JTextArea();
        countLabel = new JLabel("Characters: 0 | Words: 0");

        textArea.addKeyListener(this); // Register this class as the KeyListener

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Implement KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {
        // Not used, but must be implemented
    }

    @Override
    public void keyReleased(KeyEvent e) {
        updateCounts(); // Update on key release
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used, but must be implemented
    }

    private void updateCounts() {
        String text = textArea.getText();
        int charCount = text.length();
        int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
        countLabel.setText("Characters: " + charCount + " | Words: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextCounterGUI::new);
    }
}
