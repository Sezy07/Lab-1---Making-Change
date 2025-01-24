import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Purse Contents:", 10, 20);

        double totalValue = purse.getValue();
        g.drawString("Total Value: $" + String.format("%.2f", totalValue), 10, 40);

        int x = 10;
        int y = 60;
        int imageSpacing = 120;
        int lineHeight = 60;
        int imageHeight = 75;

        List<Map.Entry<Denomination, Integer>> denominationList = new ArrayList<>(purse.getCash().entrySet());
        denominationList.sort(Comparator.comparingDouble(entry -> entry.getKey().amt));

        for (Map.Entry<Denomination, Integer> entry : denominationList) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();
            g.drawString(denom.name + ": " + count, x, y);

            ImageIcon icon = new ImageIcon(denom.img);
            Image img = icon.getImage();
            if (img != null) {
                for (int i = 0; i < count; i++) {
                    int imgX = x + (i % 5) * imageSpacing;
                    int imgY = y + 20 + (i / 5) * lineHeight;
                    g.drawImage(img, imgX, imgY, imageHeight, imageHeight, this);
                }
            } else {
                g.drawString("Image not found", x, y + 20);
            }

            y += lineHeight + imageHeight;
        }
    }
}


