package UI.Controller;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public abstract class SubPaneController extends MainPane
{
    @FXML
    protected Button Return;
    
    @FXML
    protected Button Home;
    
	// Called when we need the pane to be visible.
	public void showPane()
	{
		// Initialize new transition animation
		TranslateTransition t = new TranslateTransition();
		
		// Set up animation values
		t.setByY(-1000);
		t.setDuration(Duration.seconds(0.3));
		t.setNode(main);
		
		// Play the animation
		t.play();
	}
	
	// Called when we need to hide the pane.
	public void hidePane(MouseEvent e)
	{
		TranslateTransition t = new TranslateTransition();
		
		t.setByY(1000);
		t.setDuration(Duration.seconds(0.3));
		t.setNode(main);
		
		t.play();
	}
	
	// Called when we need to make the home stage visible.
	public void goBackHome(MouseEvent e) throws IOException
	{
		// Loads the home stage fxml file
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Resources/fxml/HomeScreen.fxml"));
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

		// Set the root stage
		stage.getScene().setRoot(root);
		stage.show();
	}
}
