package shadowfox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Student {
    String name;
    String rollNumber;
    String email;

    public Student(String name, String rollNumber, String email) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.email = email;
    }
}

public class StudentInformationSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTextField nameField, rollNumberField, emailField;

    public StudentInformationSystem() {
        JFrame frame = new JFrame("Student Information System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Create the input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Roll Number:"));
        rollNumberField = new JTextField();
        inputPanel.add(rollNumberField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        JButton addButton = new JButton("Add Student");
        inputPanel.add(addButton);

        JButton updateButton = new JButton("Update Student");
        inputPanel.add(updateButton);

        JButton deleteButton = new JButton("Delete Student");
        inputPanel.add(deleteButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Create the table to display students
        tableModel = new DefaultTableModel(new String[]{"Name", "Roll Number", "Email"}, 0);
        JTable table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Button actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent(table);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent(table);
            }
        });

        frame.setVisible(true);
    }

    private void addStudent() {
        String name = nameField.getText();
        String rollNumber = rollNumberField.getText();
        String email = emailField.getText();

        if (!name.isEmpty() && !rollNumber.isEmpty() && !email.isEmpty()) {
            students.add(new Student(name, rollNumber, email));
            tableModel.addRow(new Object[]{name, rollNumber, email});
            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
        }
    }

    private void updateStudent(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String name = nameField.getText();
            String rollNumber = rollNumberField.getText();
            String email = emailField.getText();

            if (!name.isEmpty() && !rollNumber.isEmpty() && !email.isEmpty()) {
                Student student = students.get(selectedRow);
                student.name = name;
                student.rollNumber = rollNumber;
                student.email = email;
                tableModel.setValueAt(name, selectedRow, 0);
                tableModel.setValueAt(rollNumber, selectedRow, 1);
                tableModel.setValueAt(email, selectedRow, 2);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all fields!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a student to update!");
        }
    }

    private void deleteStudent(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            students.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, "Select a student to delete!");
        }
    }

    private void clearFields() {
        nameField.setText("");
        rollNumberField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentInformationSystem::new);
    }
}