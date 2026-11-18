package productsalesappfinal;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductForm extends JFrame {
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProducts;
    private JTextField txtPrice;

    public ProductForm() {
        setTitle("Product App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(20, 20, 100, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(130, 20, 220, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(20, 60, 100, 25);
        add(lblProduct);

        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProducts = new JComboBox<>(products);
        cmbProducts.setBounds(130, 60, 220, 25);
        add(cmbProducts);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(20, 100, 100, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(130, 100, 220, 25);
        add(txtPrice);

        JButton btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(130, 140, 220, 30);
        add(btnProcess);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        btnProcess.addActionListener(e -> processSales());
        processItem.addActionListener(e -> processSales());
        clearItem.addActionListener(e -> clearForm());
        exitItem.addActionListener(e -> System.exit(0));
    }

    private void processSales() {
        try {
            String customer = txtCustomerName.getText();
            String product = cmbProducts.getSelectedItem().toString();
            double price = Double.parseDouble(txtPrice.getText());

            IProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String message = "Customer Name: " + customer + "\n" +
                             "Product: " + product + "\n" +
                             "VAT: R " + vat + "\n" +
                             "COMMISSION: R " + commission + "\n" +
                             "TOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Log details to data.txt
            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
                writer.println("DATA LOG");
                writer.println("**************************************************");
                writer.println("Customer Name: " + customer);
                writer.println("Product: " + product);
                writer.println("VAT: R " + vat);
                writer.println("COMMISSION: R " + commission);
                writer.println("TOTAL: R " + total);
                writer.println("**************************************************");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid numeric price.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProducts.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        IProducts prod = new Product(sales, names);
        PrintProduct printer = new PrintProduct(prod);
        printer.printReport();

        new ProductForm().setVisible(true);
    }
}