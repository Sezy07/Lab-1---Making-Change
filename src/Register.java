import javax.swing.*;

class Register {
    private final Denomination[] denominations = {
            new Denomination("Hundred Note", 100.0, "bill", "Files for Currency/hundred.jpg"),
            new Denomination("Fifty Note", 50.0, "bill", "Files for Currency/fifty.jpg"),
            new Denomination("Twenty Note", 20.0, "bill", "Files for Currency/twenty.jpg"),
            new Denomination("Ten Note", 10.0, "bill", "Files for Currency/ten.jpg"),
            new Denomination("Five Note", 5.0, "bill", "Files for Currency/five.jpg"),
            new Denomination("One Note", 1.0, "bill", "Files for Currency/one.jpg"),
            new Denomination("Quarter", 0.25, "coin", "Files for Currency/quarter.jpg"),
            new Denomination("Dime", 0.10, "coin", "Files for Currency/dime.jpg"),
            new Denomination("Nickel", 0.05, "coin", "Files for Currency/nickel.jpg"),
            new Denomination("Penny", 0.01, "coin", "Files for Currency/penny.jpg")
    };

    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        for (Denomination denomination : denominations) {
            int count = (int) (amt / denomination.amt);
            if (count > 0) {
                purse.add(denomination, count);
                amt -= count * denomination.amt;
            }
        }
        return purse;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Making Change");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new RegisterPanel());
            frame.pack();
            frame.setVisible(true);
        });
    }
}
