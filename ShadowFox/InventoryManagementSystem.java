package shadowfox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class InventoryManagementSystem extends JFrame {
    private JTextField idField, nameField, quantityField, priceField;
    private JButton addButton, updateButton, deleteButton, clearButton;
    private JTable table;
    private DefaultTableModel tableModel;

    public InventoryManagementSystem() {
        // Create the frame
        setTitle("Inventory Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the input fields and buttons
        JLabel idLabel = new JLabel("ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel quantityLabel = new JLabel("Quantity:");
        JLabel priceLabel = new JLabel("Price:");

        idField = new JTextField(10);
        nameField = new JTextField(10);
        quantityField = new JTextField(10);
        priceField = new JTextField(10);

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");

        // Create table to display inventory items
        String[] columns = {"ID", "Name", "Quantity", "Price"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Layout the components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(clearButton);
        inputPanel.add(addButton);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(tableScrollPane, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(e -> addItem());
        updateButton.addActionListener(e -> updateItem());
        deleteButton.addActionListener(e -> deleteItem());
        clearButton.addActionListener(e -> clearFields());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                idField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                nameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                quantityField.setText(tableModel.getValueAt(selectedRow, 2).toString());
                priceField.setText(tableModel.getValueAt(selectedRow, 3).toString());
            }
        });
    }

    // Add new item to the inventory
    private void addItem() {
        if (idField.getText().isEmpty() || nameField.getText().isEmpty() || 
            quantityField.getText().isEmpty() || priceField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        Vector<String> row = new Vector<>();
        row.add(idField.getText());
        row.add(nameField.getText());
        row.add(quantityField.getText());
        row.add(priceField.getText());
        tableModel.addRow(row);

        clearFields();
    }

    // Update selected item in the inventory
    private void updateItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.setValueAt(idField.getText(), selectedRow, 0);
            tableModel.setValueAt(nameField.getText(), selectedRow, 1);
            tableModel.setValueAt(quantityField.getText(), selectedRow, 2);
            tableModel.setValueAt(priceField.getText(), selectedRow, 3);

            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to update.");
        }
    }

    // Delete selected item from the inventory
    private void deleteItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to delete.");
        }
    }

    // Clear input fields
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InventoryManagementSystem ims = new InventoryManagementSystem();
            ims.setVisible(true);
        });
    }
}

