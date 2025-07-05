import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class InventoryManagementSystem {
    private JFrame frame;
    private DefaultTableModel tableModel;
    private JTable table;
    private JLabel totalValueLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventoryManagementSystem().createAndShow());
    }

    private void createAndShow() {
        frame = new JFrame("Inventory Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout(10, 10));

        // Table setup
        tableModel = new DefaultTableModel(new Object[]{"Name", "Code", "Price", "Quantity", "Total"}, 0);
        table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Buttons panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton addBtn = new JButton("Add Item");
        JButton deleteBtn = new JButton("Delete Selected");
        totalValueLabel = new JLabel("Total Value: ₹0");
        panel.add(addBtn);
        panel.add(deleteBtn);
        panel.add(totalValueLabel);
        frame.add(panel, BorderLayout.SOUTH);

        // Button actions
        addBtn.addActionListener(e -> addItem());
        deleteBtn.addActionListener(e -> deleteSelected());

        frame.setVisible(true);
    }

    private void addItem() {
        JTextField nameF = new JTextField();
        JTextField codeF = new JTextField();
        JTextField priceF = new JTextField();
        JTextField qtyF = new JTextField();

        JPanel p = new JPanel(new GridLayout(4, 2, 5, 5));
        p.add(new JLabel("Name:")); p.add(nameF);
        p.add(new JLabel("Code:")); p.add(codeF);
        p.add(new JLabel("Price:")); p.add(priceF);
        p.add(new JLabel("Quantity:")); p.add(qtyF);

        int res = JOptionPane.showConfirmDialog(frame, p, "Add New Item", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            try {
                String name = nameF.getText().trim();
                int code = Integer.parseInt(codeF.getText().trim());
                int price = Integer.parseInt(priceF.getText().trim());
                int qty = Integer.parseInt(qtyF.getText().trim());
                int total = price * qty;
                tableModel.addRow(new Object[]{name, code, price, qty, total});
                recalcTotal();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteSelected() {
        int sel = table.getSelectedRow();
        if (sel >= 0) {
            tableModel.removeRow(sel);
            recalcTotal();
        } else {
            JOptionPane.showMessageDialog(frame, "Select a row first.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void recalcTotal() {
        int sum = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            sum += (int) tableModel.getValueAt(i, 4);
        }
        totalValueLabel.setText("Total Value: ₹" + sum);
    }
}
