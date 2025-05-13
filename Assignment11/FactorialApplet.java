import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class FactorialApplet extends Applet implements ActionListener {
    Label label;
    TextField input;
    Button calculate;
    String result = "";

    public void init() {
        label = new Label("Enter a number:");
        input = new TextField(10);
        calculate = new Button("Find Factorial");

        add(label);
        add(input);
        add(calculate);

        calculate.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num = Integer.parseInt(input.getText());
            long factorial = 1;

            for (int i = 1; i <= num; i++) {
                factorial *= i;
            }

            result = "Factorial of " + num + " is " + factorial;
        } catch (NumberFormatException ex) {
            result = "Invalid input! Please enter an integer.";
        }

        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(result, 20, 100);
    }
}
