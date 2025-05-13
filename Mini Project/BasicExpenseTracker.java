import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Expense {
    String description, date, category;
    double amount;

    public Expense(String description, double amount, String date, String category) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public String toString() {
        return description + " | ₹" + amount + " | " + date + " | " + category;
    }
}

public class BasicExpenseTracker extends JFrame implements ActionListener {
    JPanel sidebar, dashboardPanel, addPanel, viewPanel;
    JButton btnDashboard, btnAdd, btnView;
    JTextField incomeField, descField, amountField, dateField;
    JComboBox<String> categoryBox;
    JTextArea dashboardSummary;
    ArrayList<Expense> expenses = new ArrayList<>();
    double income = 0;

    // For view panel table
    String[] columnNames = {"Description", "Amount", "Date", "Category"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    JTable expenseTable = new JTable(tableModel);

    // For dashboard recent table
    DefaultTableModel recentModel = new DefaultTableModel(columnNames, 0);
    JTable recentTable = new JTable(recentModel);

    public BasicExpenseTracker() {
        setTitle("Expense Tracker");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Sidebar
        sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setBackground(Color.DARK_GRAY);
        sidebar.setBounds(0, 0, 180, 500);

        JLabel title = new JLabel("Expense Tracker");
        title.setForeground(Color.WHITE);
        title.setBounds(20, 20, 150, 30);
        sidebar.add(title);

        btnDashboard = new JButton("Dashboard");
        btnAdd = new JButton("Add Expense");
        btnView = new JButton("View All");

        btnDashboard.setBounds(20, 80, 140, 30);
        btnAdd.setBounds(20, 120, 140, 30);
        btnView.setBounds(20, 160, 140, 30);

        btnDashboard.addActionListener(this);
        btnAdd.addActionListener(this);
        btnView.addActionListener(this);

        sidebar.add(btnDashboard);
        sidebar.add(btnAdd);
        sidebar.add(btnView);
        add(sidebar);

        // Dashboard Panel
        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(null);
        dashboardPanel.setBounds(180, 0, 620, 500);

        JLabel incomeLabel = new JLabel("Monthly Income:");
        incomeLabel.setBounds(20, 20, 120, 25);
        dashboardPanel.add(incomeLabel);

        incomeField = new JTextField();
        incomeField.setBounds(140, 20, 120, 25);
        dashboardPanel.add(incomeField);

        JButton setIncomeBtn = new JButton("Set Income");
        setIncomeBtn.setBounds(270, 20, 120, 25);
        setIncomeBtn.addActionListener(e -> {
            try {
                income = Double.parseDouble(incomeField.getText());
                updateDashboard();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid income");
            }
        });
        dashboardPanel.add(setIncomeBtn);

        dashboardSummary = new JTextArea();
        dashboardSummary.setBounds(20, 60, 550, 80);
        dashboardSummary.setEditable(false);
        dashboardPanel.add(dashboardSummary);

        JLabel recentLabel = new JLabel("Recent 5 Transactions:");
        recentLabel.setBounds(20, 150, 200, 25);
        dashboardPanel.add(recentLabel);

        recentTable.setEnabled(false); // Make table non-editable
        JScrollPane recentScrollPane = new JScrollPane(recentTable);
        recentScrollPane.setBounds(20, 180, 570, 260);
        dashboardPanel.add(recentScrollPane);

        // Add Expense Panel
        addPanel = new JPanel();
        addPanel.setLayout(null);
        addPanel.setBounds(180, 0, 620, 500);

        JLabel descLabel = new JLabel("Description:");
        JLabel amountLabel = new JLabel("Amount:");
        JLabel dateLabel = new JLabel("Date (DD/MM/YYYY):");
        JLabel categoryLabel = new JLabel("Category:");

        descLabel.setBounds(30, 30, 120, 25);
        amountLabel.setBounds(30, 70, 120, 25);
        dateLabel.setBounds(30, 110, 150, 25);
        categoryLabel.setBounds(30, 150, 120, 25);

        descField = new JTextField();
        amountField = new JTextField();
        dateField = new JTextField();
        categoryBox = new JComboBox<>(new String[]{"Food", "Transport", "Entertainment", "Others"});

        descField.setBounds(180, 30, 200, 25);
        amountField.setBounds(180, 70, 200, 25);
        dateField.setBounds(180, 110, 200, 25);
        categoryBox.setBounds(180, 150, 200, 25);

        JButton addBtn = new JButton("Add Expense");
        addBtn.setBounds(180, 200, 200, 30);
        addBtn.addActionListener(e -> {
            try {
                String desc = descField.getText();
                double amt = Double.parseDouble(amountField.getText());
                String date = dateField.getText();
                String cat = (String) categoryBox.getSelectedItem();

                expenses.add(new Expense(desc, amt, date, cat));

                updateDashboard();

                double totalExpense = 0;
                for (Expense exp : expenses) {
                    totalExpense += exp.amount;
                }

                if (totalExpense > income) {
                    JOptionPane.showMessageDialog(this,
                            "⚠️ Warning: You have exceeded your monthly income!",
                            "Income Exceeded",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Expense added!");
                }

                clearForm();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid data!");
            }
        });

        addPanel.add(descLabel);
        addPanel.add(amountLabel);
        addPanel.add(dateLabel);
        addPanel.add(categoryLabel);
        addPanel.add(descField);
        addPanel.add(amountField);
        addPanel.add(dateField);
        addPanel.add(categoryBox);
        addPanel.add(addBtn);

        // View Panel with JTable
        viewPanel = new JPanel();
        viewPanel.setLayout(null);
        viewPanel.setBounds(180, 0, 620, 500);

        JScrollPane tableScrollPane = new JScrollPane(expenseTable);
        tableScrollPane.setBounds(20, 20, 570, 360);
        viewPanel.add(tableScrollPane);

        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(120, 400, 100, 25);
        refreshBtn.addActionListener(e -> updateTransactions());
        viewPanel.add(refreshBtn);

        JButton deleteBtn = new JButton("Delete Selected");
        deleteBtn.setBounds(350, 400, 150, 25);
        deleteBtn.addActionListener(e -> {
            int selectedRow = expenseTable.getSelectedRow();
            if (selectedRow != -1 && selectedRow < expenses.size()) {
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to delete this transaction?");
                if (confirm == JOptionPane.YES_OPTION) {
                    expenses.remove(selectedRow);
                    updateTransactions();
                    updateDashboard();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a valid transaction to delete.");
            }
        });
        viewPanel.add(deleteBtn);

        add(dashboardPanel);
        add(addPanel);
        add(viewPanel);

        showPanel(dashboardPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDashboard) {
            showPanel(dashboardPanel);
        } else if (e.getSource() == btnAdd) {
            showPanel(addPanel);
        } else if (e.getSource() == btnView) {
            updateTransactions();
            showPanel(viewPanel);
        }
    }

    void showPanel(JPanel panel) {
        dashboardPanel.setVisible(false);
        addPanel.setVisible(false);
        viewPanel.setVisible(false);
        panel.setVisible(true);
    }

    void updateDashboard() {
        double totalExpense = 0;
        recentModel.setRowCount(0); // Clear recent table

        int count = 0;
        for (int i = expenses.size() - 1; i >= 0 && count < 5; i--, count++) {
            Expense e = expenses.get(i);
            Object[] row = {e.description, "₹" + e.amount, e.date, e.category};
            recentModel.addRow(row);
            totalExpense += e.amount;
        }

        double balance = income - totalExpense;
        dashboardSummary.setText("=== DASHBOARD ===\nTotal Income: ₹" + income +
                "\nTotal Expenses: ₹" + totalExpense +
                "\nCurrent Balance: ₹" + balance);
    }

    void updateTransactions() {
        tableModel.setRowCount(0); // Clear table
        for (Expense e : expenses) {
            Object[] row = {e.description, "₹" + e.amount, e.date, e.category};
            tableModel.addRow(row);
        }
    }

    void clearForm() {
        descField.setText("");
        amountField.setText("");
        dateField.setText("");
        categoryBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new BasicExpenseTracker();
    }
}
