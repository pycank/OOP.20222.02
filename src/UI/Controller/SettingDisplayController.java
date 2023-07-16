package UI.Controller;

import java.io.FileNotFoundException;

import Music.BackgroundMusic;
import Music.Sound;
import UI.Utils.Language;
import UI.Utils.Load;
import UI.Utils.Resize;
import UI.Utils.Save;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

public class SettingDisplayController extends SubPaneController {

	@FXML
	private Button MusicBtn;

	@FXML
	private Slider Music;

	@FXML
	private Label MusicLabel;

	@FXML
	private Button SFXBtn;

	@FXML
	private Slider SFX;

	@FXML
	private Label SFXLabel;


	@FXML
	private Button Help;


	@FXML
	private AnchorPane helpPane;



	@FXML
	private HelpController HSController;


	public void initialize() {
		
		try {
			new Load(Music, SFX);
		} catch (FileNotFoundException e) {
			Music.setValue(100);
			SFX.setValue(100);
		}
		
		//Music.lookup(".track").property
		Music.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
            public void changed(ObservableValue<? extends Number> n0, Number n1, Number n2) {
				double d = Music.getValue();
				
				BackgroundMusic.setVolume(d);
				
				Music.lookup(".track").setStyle("-fx-background-color: linear-gradient(to right, #ddc " + d + "%, #eee " + d + "%)");
				
				new Save(Music, SFX);
            }
        });
		
		MusicLabel.textProperty().bind(Music.valueProperty().asString("%.0f"));
		
		SFX.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
            public void changed(ObservableValue<? extends Number> n0, Number n1, Number n2) {
				double d = SFX.getValue();
				
				if (SFX.getValue() == 0) {
					Sound.mute();
				}
				else {
					Sound.unmute();
				}
				
				SFX.lookup(".track").setStyle("-fx-background-color: linear-gradient(to right, #ddc " + d + "%, #eee " + d + "%)");
								
				new Save(Music, SFX);
            }
        });
		
		SFXLabel.textProperty().bind(Bindings.convert(SFX.valueProperty().asString("%.0f")));
		
		Resize.bind(new Region[] {MusicBtn, SFXBtn, Help, Return, Home, helpPane, MusicLabel, SFXLabel}, main);
		
		Language.bindLang(new Labeled[] {Help, Return, Home}, main);
	
	}

	private double preMusic;

	public void muteMusic(MouseEvent e) { // Mute the music
		if (Music.getValue() != 0) {
			preMusic = Music.getValue();
			Music.setValue(0);
		} else {
			Music.setValue(preMusic);
		}
	}

	private double preSFX;

	public void muteSFX(MouseEvent e) { // Mute the SFX
		if (SFX.getValue() != 0) {
			preSFX = SFX.getValue();
			SFX.setValue(0);
		} else {
			SFX.setValue(preSFX);
		}
	}

	public double getSFX() {
		return SFX.getValue();
	}



	public void help(MouseEvent e) { // Show the Help pane
		HSController.visualise();
	}



}