package visao;

import java.io.File;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class TelaInicial extends VBox{
	
	private final int size = 80;
	private final int width = 7;
	private final int heigth = 5;
	private VBox menu;
	private ImageView imgView;
	private Button btnPlay;
	private Button btnSobre;
	private Button btnExit;
	
	public TelaInicial() {
		super();
	}
	
	public Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize((width * size), (heigth * size));
		
		this.menu = new VBox();
		
		Image img = new Image(new File("recursos/imagens/Principal.png").toURI().toString());
		this.imgView = new ImageView(img);
		
		this.btnPlay = new Button("Jogar");
		this.btnSobre = new Button("Sobre");
		this.btnExit = new Button("Sair");
				
		menu.getChildren().add(this.imgView);
		menu.getChildren().addAll(new Button[] {this.btnPlay, this.btnSobre, this.btnExit});
		
		menu.setPrefSize((width * size), (heigth * size));
		menu.setAlignment(Pos.CENTER);
		menu.setSpacing(10);

        root.getChildren().add(this.menu);
				
		return root;
	}
	
	public void setAcaoBtnPlay(EventHandler<Event> acao) {
		btnPlay.setOnMouseClicked(acao);
	}
	
	public void setAcaoBtnSobre(EventHandler<Event> acao) {
		btnSobre.setOnMouseClicked(acao);
	}
	
	public void setAcaoBtnExit(EventHandler<Event> acao) {
		btnExit.setOnMouseClicked(acao);
	}

}
