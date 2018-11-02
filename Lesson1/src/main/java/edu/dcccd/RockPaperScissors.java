package edu.dcccd;

import javax.swing.*;
import java.util.Random;

public class RockPaperScissors extends JFrame {
    private static final int ROCK = 0;
    private static final int PAPER = 1;
    private static final int SCISSORS = 2;

    private static final String IMG_ROCK = "rock.png";
    private static final String IMG_PAPER = "paper.png";      //Bringing in image files as Strings
    private static final String IMG_SCISSORS = "scissors.png";
    private static final String LET_S_PLAY = "Let's Play!\n\nRock, Paper, Scissors";
    private JPanel panel1;
    private JPanel userPanel;
    private JPanel centerPanel;
    private JPanel computerPanel;
    private JPanel buttonPanel;
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JButton newGameButton;
    private JLabel userChoice;
    private JLabel userLabel;
    private JTextArea result;
    private JLabel computerChoice;
    private JLabel computerLabel;
    private ImageIcon[] images = new ImageIcon[]{
        new ImageIcon(IMG_ROCK),
        new ImageIcon(IMG_PAPER),
        new ImageIcon(IMG_SCISSORS)
    };
    private Random random = new Random();

    private RockPaperScissors() {
        super("Rock Paper Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rockButton.addActionListener(e -> getResult(ROCK));
        paperButton.addActionListener(e -> getResult(PAPER));
        scissorsButton.addActionListener(e -> getResult(SCISSORS));
        newGameButton.addActionListener(e -> newGameButtonListener());

        add(panel1);

        pack();
        setVisible(true);
    }

    private void newGameButtonListener() {
        userLabel.setIcon(new ImageIcon());
        result.setText(LET_S_PLAY);
        computerLabel.setIcon(new ImageIcon());
    }

        private void getResult(int user) {
            int computer = random.nextInt(images.length);
            userLabel.setIcon(images[user]);
            computerLabel.setIcon(images[computer]);
            result.setText(RPSUtil.determineWinner(user, computer));
        }

    public static void main(String[] args) {
        new RockPaperScissors();
    }
}
