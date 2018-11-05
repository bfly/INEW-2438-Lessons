import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

/**
 * Lesson 2
 * Rock, Paper, Scissors Game using JavaFX
 * This is the controller class.
 */
 
public class RockPaperScissorsGameController
{
   // Named constants.
   private static final int ROCK     =  0;
   private static final int PAPER    =  1;
   private static final int SCISSORS =  2;

   private static final String IMG_ROCK = "rock.png";
   private static final String IMG_PAPER = "paper.png";      //Bringing in image files as Strings
   private static final String IMG_SCISSORS = "scissors.png";
   private static final String LET_S_PLAY = "Let's Play!\n\nRock, Paper, Scissors";

   public TextArea result;

    // ImageViews
   @FXML
   private ImageView computerImageView;
   @FXML
   private ImageView playerImageView;

   // Labels
   @FXML
   private Label playerLabel;
   @FXML
   private Label computerLabel;

   // Buttons
   @FXML
   private Button rockButton;
   @FXML
   private Button paperButton;
   @FXML
   private Button scissorsButton;
   @FXML
   private Button newGameButton;

   // Private fields for the Image,
   // ArrayList, and Random objects.
   private Random rand;
    private Image[] images = new Image[]{
        new Image(IMG_ROCK),
        new Image(IMG_PAPER),
        new Image(IMG_SCISSORS)
    };

   // This method is called when the FXML file is loaded
   public void initialize() {
      // Create a Random object.
      rand = new Random();
      // Reset the game.
      reset();
   }

   // Event listener for the rockButton
   public void rockButtonListener() {
      play(ROCK);
   }

   // Event listener for the paperButton
   public void paperButtonListener() {
      play(PAPER);
   }

   // Event listener for the scissorsButton
   public void scissorsButtonListener() {
      play(SCISSORS);
   }
   
   // Event listener for the newGameButton
   public void newGameButtonListener() {
      reset();
   }

   // The reset method resets the game.
   private void reset() {
      // Remove the images.
      computerImageView.setImage(null);
      playerImageView.setImage(null);

      // Display the new game messages.
      result.setText(LET_S_PLAY);

   }

   // The play method plays a round of the game.
   private void play(int user)
   {
       // Get a random choice for the computer.
       // Private fields for the computer
       // and player choice.
       int computer = rand.nextInt(images.length);

       // Display the computer's choice.
       computerImageView.setImage(images[computer]);
      
       // Display the player's choice.
       playerImageView.setImage(images[(user)]);

       // Determine the winner.
       result.setText(RPSUtil.determineWinner(user, computer));
   }
}