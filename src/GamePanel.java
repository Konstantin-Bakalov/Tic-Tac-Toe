import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        drawLines(g2d);
        repaint();
    }

    private void drawLines(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawLine(100, 0, 100, 300);
        g2d.drawLine(200, 0, 200, 300);
        g2d.drawLine(0, 100, 300, 100);
        g2d.drawLine(0, 200, 300, 200);
    }
}