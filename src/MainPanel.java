import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        g2d.drawString("Score", 110, 20);
        g2d.drawString("X : " + Frame.scoreX, 10, 50);
        g2d.drawString(Frame.scoreO + " : O", 225, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < Frame.buttons.length; i++) {
            if(e.getSource() == Frame.buttons[i]) {
                if(Frame.isFree[i]) {
                    if(Frame.player.equals("X")) {
                        Frame.buttons[i].setIcon(Frame.iconX);
                        Frame.symbol[i] = 'X';
                        Frame.player = "O";
                    }
                    else {
                        Frame.buttons[i].setIcon(Frame.iconO);
                        Frame.symbol[i] = 'O';
                        Frame.player = "X";
                    }
                    Frame.isFree[i] = false;
                }
                if(checkIfPlayerWins().equals("X")) {
                    Frame.scoreX++;
                    repaint();
                    disableButtons();
                }
                else if(checkIfPlayerWins().equals("O")) {
                    Frame.scoreO++;
                    repaint();
                    disableButtons();
                }
            }
            else if(e.getSource() == Frame.reset) {
                Frame.player = "X";
                for(int j = 0; j < Frame.isFree.length; j++)
                    Frame.isFree[j] = true;
                for(int j = 0; j < Frame.buttons.length; j++)
                    Frame.buttons[j].setIcon(null);
                for(int j = 0; j < Frame.buttons.length; j++)
                    Frame.buttons[j].setEnabled(true);
                for(int j = 0; j < Frame.symbol.length; j++)
                    Frame.symbol[i] = ' ';
            }
        }
    }
    private String checkIfPlayerWins() {
        if(Frame.symbol[0] != ' ' && Frame.symbol[0] == Frame.symbol[1] && Frame.symbol[1] == Frame.symbol[2])
            return (Frame.symbol[0] == 'X' ? "X" : "O");
        else if(Frame.symbol[3] != ' ' && Frame.symbol[3] == Frame.symbol[4] && Frame.symbol[4] == Frame.symbol[5])
            return (Frame.symbol[3] == 'X' ? "X" : "O");
        else if(Frame.symbol[6] != ' ' && Frame.symbol[6] == Frame.symbol[7] && Frame.symbol[7] == Frame.symbol[8])
            return (Frame.symbol[6] == 'X' ? "X" : "O");
        else if(Frame.symbol[0] != ' ' && Frame.symbol[0] == Frame.symbol[3] && Frame.symbol[3] == Frame.symbol[6])
            return (Frame.symbol[0] == 'X' ? "X" : "O");
        else if(Frame.symbol[1] != ' ' && Frame.symbol[1] == Frame.symbol[4] && Frame.symbol[4] == Frame.symbol[7])
            return (Frame.symbol[1] == 'X' ? "X" : "O");
        else if(Frame.symbol[2] != ' ' && Frame.symbol[2] == Frame.symbol[5] && Frame.symbol[5] == Frame.symbol[8])
            return (Frame.symbol[2] == 'X' ? "X" : "O");
        else if(Frame.symbol[0] != ' ' && Frame.symbol[0] == Frame.symbol[4] && Frame.symbol[4] == Frame.symbol[8])
            return (Frame.symbol[0] == 'X' ? "X" : "O");
        else if(Frame.symbol[2] != ' ' && Frame.symbol[2] == Frame.symbol[4] && Frame.symbol[4] == Frame.symbol[6])
            return (Frame.symbol[2] == 'X' ? "X" : "O");
        return "";
    }
    private void disableButtons() {
        for(int i = 0; i < Frame.buttons.length; i++)
            Frame.buttons[i].setEnabled(false);
    }
}
