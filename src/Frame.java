import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public static MainPanel mainPanel;
    public static GamePanel gamePanel;
    public static JButton[] buttons;
    public static JButton reset;
    public static String player;
    public static ImageIcon iconX, iconO;
    public static boolean[] isFree;
    public static char[] symbol;
    public static int scoreX, scoreO;
    public static Timer timer;

    public Frame() {
        super("Tic Tac Toe");
        this.setSize(300, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        player = "X";
        loadIcons();
        isFree = new boolean[9];
        for(int i = 0; i < isFree.length; i++) isFree[i] = true;
        scoreX = 0;
        scoreO = 0;
        symbol = new char[9];
        for(int i = 0; i < symbol.length; i++)
            symbol[i] = ' ';

        setMainPanel();
        this.add(mainPanel);
        timer = new Timer(1000, mainPanel);
        timer.start();


        this.setVisible(true);
    }

    private void setMainPanel() {
        mainPanel = new MainPanel();
        mainPanel.setBounds(0, 0, 300, 500);
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(136, 182, 98));
        setGamePanel();
        mainPanel.add(gamePanel);
        mainPanel.add(reset);
    }

    private void setGamePanel() {
        gamePanel = new GamePanel();
        gamePanel.setBounds(0, 100, 300, 300);
//        gamePanel.setBackground(new Color(50, 50, 50));
        gamePanel.setLayout(new GridLayout(3, 3));
        addButtons();
    }

    private void addButtons() {
        buttons = new JButton[9];
        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(mainPanel);
            buttons[i].setOpaque(true);
            buttons[i].setBackground(new Color(136, 182, 98));
            buttons[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            gamePanel.add(buttons[i]);
        }
        reset = new JButton("Reset");
        reset.setBounds(100, 410, 100, 50);
        reset.addActionListener(mainPanel);
        reset.setFocusable(false);
        reset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        reset.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
        reset.setOpaque(true);
        reset.setBackground(new Color(96, 126, 67));
    }

    private void loadIcons() {
        iconX = new ImageIcon("x.png");
        iconO = new ImageIcon("circle.png");
    }
}