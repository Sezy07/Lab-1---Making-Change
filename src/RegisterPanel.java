import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RegisterPanel extends JPanel {
    private Register register = new Register();
    private JTextField input = new JTextField(10);
    private PursePanel changePanel = new PursePanel();

    public RegisterPanel() {
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Amount:"));
        inputPanel.add(input);
        JButton button = new JButton("Make Change");
        button.addActionListener(new InputListener());
        inputPanel.add(button);
        add(inputPanel, BorderLayout.NORTH);
        add(changePanel, BorderLayout.CENTER);
    }

    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double amount;
            try {
                amount = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amount);
                changePanel.setPurse(purse);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid amount");
            }
        }
    }
}
