import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;
    JButton[] numButtons = new JButton[10];
    JButton addBtn, subBtn, mulBtn, divBtn, eqBtn, clrBtn;
    JButton modBtn, sqrtBtn, squareBtn, cubeBtn;

    String operator = "";
    double num1 = 0, num2 = 0;

    public Calculator() {
        setTitle("Standard Calculator");
        setSize(400, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        display = new JTextField();
        display.setBounds(30, 30, 320, 40);
        display.setEditable(false);
        add(display);

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        eqBtn = new JButton("=");
        clrBtn = new JButton("C");
        modBtn = new JButton("%");
        sqrtBtn = new JButton("√");
        squareBtn = new JButton("x²");
        cubeBtn = new JButton("x³");

        JButton[] opButtons = {addBtn, subBtn, mulBtn, divBtn, eqBtn, clrBtn, modBtn, sqrtBtn, squareBtn, cubeBtn};

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
        }

        for (JButton btn : opButtons) {
            btn.addActionListener(this);
        }

        JPanel numPanel = new JPanel(new GridLayout(4, 3, 10, 10));
        numPanel.setBounds(30, 90, 230, 180);
        for (int i = 1; i <= 9; i++) numPanel.add(numButtons[i]);
        numPanel.add(numButtons[0]);
        numPanel.add(clrBtn);
        numPanel.add(eqBtn);
        add(numPanel);

        JPanel opPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        opPanel.setBounds(270, 90, 100, 230);
        opPanel.add(addBtn);
        opPanel.add(subBtn);
        opPanel.add(mulBtn);
        opPanel.add(divBtn);
        opPanel.add(modBtn);
        opPanel.add(sqrtBtn);
        opPanel.add(squareBtn);
        opPanel.add(cubeBtn);
        add(opPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (src == numButtons[i]) {
                display.setText(display.getText() + i);
                return;
            }
        }

        if (src == clrBtn) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
        } else if (src == addBtn || src == subBtn || src == mulBtn || src == divBtn || src == modBtn) {
            num1 = Double.parseDouble(display.getText());
            operator = ((JButton) src).getText();
            display.setText("");
        } else if (src == eqBtn) {
            num2 = Double.parseDouble(display.getText());
            double result = 0;
            if (operator.equals("+")) result = num1 + num2;
            else if (operator.equals("-")) result = num1 - num2;
            else if (operator.equals("*")) result = num1 * num2;
            else if (operator.equals("/")) result = num1 / num2;
            else if (operator.equals("%")) result = num1 % num2;
            display.setText(String.valueOf(result));
        } else if (src == sqrtBtn) {
            double value = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.sqrt(value)));
        } else if (src == squareBtn) {
            double value = Double.parseDouble(display.getText());
            display.setText(String.valueOf(value * value));
        } else if (src == cubeBtn) {
            double value = Double.parseDouble(display.getText());
            display.setText(String.valueOf(value * value * value));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
