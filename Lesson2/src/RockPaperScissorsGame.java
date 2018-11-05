import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Lesson 1
 * Rock, Paper, Scissors Game using JavaFX
 * This is the main application class.
 */
 
public class RockPaperScissorsGame extends Application
{
   public void start(Stage stage) throws Exception
   {
      // Load the FXML file.
      Parent parent = FXMLLoader.load(getClass().getResource("RockPaperScissorsGame.fxml"));

      // Build the scene graph.
      Scene scene = new Scene(parent);
      
      // Display our window, using the scene graph.
      stage.setTitle("Rock, Paper, Scissors Game");
      stage.setScene(scene);
      stage.show();
   }
   
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
}