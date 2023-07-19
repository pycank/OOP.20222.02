package UI.Controller;


import javafx.fxml.FXML;

import javafx.scene.layout.AnchorPane;

public abstract class MainPane {
	
    @FXML
    protected AnchorPane main;
    
    public abstract void initialize();
    

}
