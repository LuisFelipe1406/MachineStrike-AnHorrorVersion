package visao;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class TelaSobreProjeto extends VBox {

	private final int size = 80;
	private final int width = 7;
	private final int heigth = 5;
	private VBox menu;
	private Label lblFaculdade;
	private Label lblNome;
	private Label lblEmail;
	private Label lblDesc;
	
	public TelaSobreProjeto() {
		super();
	}
	
	public Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize((width * size), (heigth * size));
		
		this.menu = new VBox();
		this.menu.setPrefSize((width * size), (heigth * size));		
		this.menu.setAlignment(Pos.CENTER);		
		this.menu.setSpacing(10);
		
		this.lblFaculdade = new Label("UDESC CEAVI | Engenharia de Software - 45PPR");
		this.lblNome = new Label("Luis Felipe da Silva");
		this.lblEmail = new Label("luis_felipes14@hotmail.com");
		this.lblDesc = new Label("O trabalho consiste na implementação do jogo de tabuleiro \n"
				+ "Ataque das Máquinas. Nosso objetivo é fazer uma releitura desse que é um \n"
				+ "jogo secundário criado para o jogo Horizon Forbidden West. \n"
				+ "Para a releitura optei por usar personages clássicos de filmes de terror, \n"
				+ "trazendo essa temática para o jogo.");
		
		this.lblDesc.setTextAlignment(TextAlignment.CENTER);
		
		this.menu.getChildren().addAll(new Label[] {this.lblFaculdade, this.lblNome, this.lblEmail, this.lblDesc});
		
		root.getChildren().add(this.menu);
		
		return root;
	}
	
}
