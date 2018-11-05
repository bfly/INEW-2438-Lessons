public class RPSUtil {
    private final static int ROCK = 0;
    private final static int PAPER = 1;
    private final static int SCISSORS = 2;
    private static final String YOU_WIN = "You win!";
    private static final String ROCK_SMASHES_SCISSORS = "Rock smashes scissors.";
    private static final String PAPER_WRAPS_ROCK = "Paper wraps rock.";
    private static final String COMPUTER_WINS = "Computer wins.";
    private static final String SCISSORS_CUTS_PAPER = "Scissors cuts paper.";

    static String determineWinner(int user, int computer) {
        String result;
        String rule;
        if( user == computer ) {
            result = "It's a tie.";
            rule = "Play again?";
        } else if(user == ROCK) {
            if( computer == PAPER ) {
                result = COMPUTER_WINS;
                rule = PAPER_WRAPS_ROCK;
            } else {
                result = YOU_WIN;
                rule = ROCK_SMASHES_SCISSORS;
            }
        } else if ( user == PAPER) {
            if ( computer == ROCK ) {
                result = YOU_WIN;
                rule = PAPER_WRAPS_ROCK;
            } else {
                result = COMPUTER_WINS;
                rule = SCISSORS_CUTS_PAPER;
            }
        } else {
            if( computer == ROCK) {
                result = COMPUTER_WINS;
                rule = ROCK_SMASHES_SCISSORS;
            } else {
                result = YOU_WIN;
                rule = SCISSORS_CUTS_PAPER;
            }
        }
        return String.format("%s\n\n%s", result, rule);
    }
}
