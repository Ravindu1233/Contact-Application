import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return name + "-" + phoneNumber;
    }
}

class MyFrame extends JFrame implements ActionListener {
    private DefaultListModel<String> listModel;
    private JList<String> contacList;

    JPanel inputPanel, mainPanel, buttoPanel;
    JLabel nameLabel, phoneLabel;
    JTextField nameField, phoneField;
    JButton addButton, deleteButton;

    MyFrame() {
        listModel = new DefaultListModel<>();
        contacList = new JList<>(listModel);

        inputPanel = new JPanel(new GridLayout(2, 2));

        nameLabel = new JLabel("Name: ");
        phoneLabel = new JLabel("Phone Number: ");

        nameField = new JTextField();
        phoneField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);

        addButton = new JButton("Add Button");
        deleteButton = new JButton("Delete Button");

        buttoPanel = new JPanel(new FlowLayout());
        buttoPanel.add(addButton);
        buttoPanel.add(deleteButton);

        addButton.addActionListener(this);
        deleteButton.addActionListener(this);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(contacList), BorderLayout.CENTER);
        mainPanel.add(buttoPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String phoneNumber = phoneField.getText();

            Contact contact = new Contact(name, phoneNumber);
            listModel.addElement(contact.toString());

            nameField.setText("");
            phoneField.setText("");
        }
        if (e.getSource() == deleteButton) {
            int selectedIndex = contacList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }

        }
    }
}

class main {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.setTitle("Contact Management System");
        frame.setSize(400, 350);
    }

}