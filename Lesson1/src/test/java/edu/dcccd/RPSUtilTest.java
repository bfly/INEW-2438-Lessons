package edu.dcccd;

import org.junit.Test;

import static edu.dcccd.RPSUtil.determineWinner;
import static org.junit.Assert.*;

public class RPSUtilTest {
    private final static int ROCK = 0;
    private final static int PAPER = 1;
    private final static int SCISSORS = 2;
    private static final String YOU_WIN = "You win!";
    private static final String ROCK_SMASHES_SCISSORS = "Rock smashes scissors.";
    private static final String PAPER_WRAPS_ROCK = "Paper wraps rock.";
    private static final String COMPUTER_WINS = "Computer wins.";
    private static final String SCISSORS_CUTS_PAPER = "Scissors cuts paper.";
    private static final String nls = "\n\n";

    @Test
    public void testTie() {
        assertEquals("It's a tie."+nls+"Play again?", determineWinner(ROCK, ROCK));
    }

    @Test
    public void testRockPaper() {
        assertEquals(COMPUTER_WINS+nls+PAPER_WRAPS_ROCK, determineWinner(ROCK, PAPER));
    }

    @Test
    public void testRockScissors() {
        assertEquals(YOU_WIN+nls+ROCK_SMASHES_SCISSORS, determineWinner(ROCK, SCISSORS));
    }

    @Test
    public void testPaperRock() {
        assertEquals(YOU_WIN+nls+PAPER_WRAPS_ROCK, determineWinner(PAPER, ROCK));
    }

    @Test
    public void testPaperScissors() {
        assertEquals(COMPUTER_WINS+nls+SCISSORS_CUTS_PAPER, determineWinner(PAPER, SCISSORS));
    }

    @Test
    public void testScissorsRock() {
        assertEquals(COMPUTER_WINS+nls+ROCK_SMASHES_SCISSORS, determineWinner(SCISSORS, ROCK));
    }

    @Test
    public void testScissorsPaper() {
        assertEquals(YOU_WIN+nls+SCISSORS_CUTS_PAPER, determineWinner(SCISSORS, PAPER));
    }
}