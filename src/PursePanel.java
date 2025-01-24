import javax.swing.*;
import java.awt.*;

class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Purse Contents:", 10, 20);
        String contents = purse.toString();
        g.drawString(contents, 10, 40);
    }
}