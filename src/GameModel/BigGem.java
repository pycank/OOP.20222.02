package GameModel;

public class BigGem extends Gem {
	
	public BigGem() {
		super();
	}

	public void bind() {
		this.getStyleClass().add("Gem");
		this.centerXProperty().bind(main.widthProperty().divide(16));
		this.centerYProperty().bind(main.heightProperty().divide(4.5));
		
		this.radiusProperty().bind(main.widthProperty().divide(40));
	}

}
