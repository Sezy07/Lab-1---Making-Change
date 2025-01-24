import javax.swing.*;

class Register {
    private final Denomination[] denominations = {
            new Denomination("Hundred Note", 100.0, "bill", "hundred.png"),
            new Denomination("Fifty Note", 50.0, "bill", "fifty.png"),
            new Denomination("Twenty Note", 20.0, "bill", "twenty.png"),
            new Denomination("Ten Note", 10.0, "bill", "ten.png"),
            new Denomination("Five Note", 5.0, "bill", "five.png"),
            new Denomination("One Note", 1.0, "bill", "one.png"),
            new Denomination("Quarter", 0.25, "coin", "quarter.png"),
            new Denomination("Dime", 0.10, "coin", "dime.png"),
            new Denomination("Nickel", 0.05, "coin", "nickel.png"),
            new Denomination("Penny", 0.01, "coin", "penny.png")
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