package UI.Controller;

import UI.Utils.Language;

import UI.Utils.Resize;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.Labeled;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

public class SettingDisplayController extends SubPaneController
{
	@FXML
	private Button Help;

	@FXML
	private AnchorPane helpPane;

	@FXML
	private HelpController HSController;

	public void initialize()
	{
		Resize.bind(new Region[] {Help, Return, Home, helpPane}, main);
		Language.bindLang(new Labeled[] {Help, Return, Home}, main);
	}

	// Called when user clicks the "Help" button. Shows the Help pane.
	public void showHelp(MouseEvent e)
	{
		HSController.showPane();
	}
}