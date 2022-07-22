package visao;

import java.io.File;
import java.util.List;

import controle.observer.ObserverSelecaoPersonagens;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class TelaSelecaoPersonagens extends VBox implements ObserverSelecaoPersonagens {

	private final int size = 80;
	private final int width = 10;
	private final int heigth = 8;
	private Pane root;
	private VBox selecaoBox;
	private HBox playersBox;
	private VBox p1Box;
	private ImageView p1ImgView;
	private Label p1Lbl;
	private TextField p1Inp;
	private ImageView vsImgView;
	private VBox p2Box;
	private ImageView p2ImgView;
	private Label p2Lbl;
	private TextField p2Inp;
	private HBox personagensBox;
	private GridPane personagensGrid;
	private HBox escolhasBox;
	private Label lblEscolhas;
	private HBox buttonsBox;
	private Button p1BtnPronto;
	private Button p2BtnPronto;
	private Button btnPlay;
	
	public TelaSelecaoPersonagens() {
		super();
	}
	
	public Parent createContent() {
		this.root = new Pane();
		this.root.setPrefSize((width * size), (heigth * size));
				
		this.selecaoBox = new VBox();
		this.selecaoBox.setPrefSize((width * size), (heigth * size));
		this.selecaoBox.setAlignment(Pos.CENTER);
		
		this.playersBox = new HBox();
		this.playersBox.setPrefSize((width * size), (heigth * size));
		this.playersBox.setAlignment(Pos.CENTER);
				
		this.p1Box = new VBox();
		this.p1Box.setAlignment(Pos.TOP_LEFT);
		this.p1Box.setSpacing(5);
		
		Image p1Img = new Image(new File("recursos/imagens/Player1.jpg").toURI().toString());
		this.p1ImgView = new ImageView(p1Img);
		
		this.p1Lbl = new Label("Nome");
		
		this.p1Inp = new TextField();
		this.p1Inp.setMaxWidth(200);
		
		Image vsImg = new Image(new File("recursos/imagens/Versus.png").toURI().toString());
		this.vsImgView = new ImageView(vsImg);
		
		this.p2Box = new VBox();
		this.p2Box.setAlignment(Pos.TOP_RIGHT);
		this.p2Box.setSpacing(5);
		
		Image p2Img = new Image(new File("recursos/imagens/Player2.jpg").toURI().toString());
		this.p2ImgView = new ImageView(p2Img);
		
		this.p2Lbl = new Label("Nome");
		
		this.p2Inp = new TextField();
		this.p2Inp.setMaxWidth(200);
				
		this.p1Box.getChildren().add(this.p1ImgView);
		this.p1Box.getChildren().add(this.p1Lbl);
		this.p1Box.getChildren().add(this.p1Inp);
		this.p2Box.getChildren().add(this.p2ImgView);
		this.p2Box.getChildren().add(this.p2Lbl);
		this.p2Box.getChildren().add(this.p2Inp);
		
		this.playersBox.getChildren().add(this.p1Box);
		this.playersBox.getChildren().add(this.vsImgView);
		this.playersBox.getChildren().add(this.p2Box);
		this.playersBox.setStyle("-fx-padding: 20px 0 20px 0;\n" +
                                 "-fx-border-color: gray;\n" +
                                 "-fx-border-width: 0 0 1px 0;\n" +
                                 "-fx-border-style: solid;\n");
				
		this.personagensBox = new HBox();
		this.personagensBox.setPrefSize((width * size), (heigth * size));
		this.personagensBox.setAlignment(Pos.CENTER);
		this.personagensBox.setStyle("-fx-padding: 20px 0 20px 0;\n" +
		          		             "-fx-border-color: gray;\n" +
		          		             "-fx-border-width: 0 0 1px 0;\n" +
		          		             "-fx-border-style: solid;\n");			
		
		this.personagensBox.getChildren().add(this.personagensGrid);
		
		this.escolhasBox = new HBox();
		this.escolhasBox.setPrefSize((width * size), (heigth * size));
		this.escolhasBox.setAlignment(Pos.CENTER);
		
		this.lblEscolhas = new Label("Escolhas Restantes: ");
		this.lblEscolhas.setStyle("-fx-font: 18 calibri");
		
		this.escolhasBox.getChildren().add(this.lblEscolhas);
		
		this.buttonsBox = new HBox();
		this.buttonsBox.setPrefSize((width * size), (heigth * size));
		this.buttonsBox.setAlignment(Pos.CENTER);
		this.buttonsBox.setStyle("-fx-spacing: 180px");
		
		String styleBotao = "-fx-pref-height: 50px; \n" +
				            "-fx-pref-width: 100px;";
		
		
		this.p1BtnPronto = new Button("P1 - Pronto");
		this.p1BtnPronto.setStyle(styleBotao);
		
		this.btnPlay = new Button("Iniciar jogo");
		this.btnPlay.setStyle(styleBotao);
		this.btnPlay.setDisable(true);		
		
		this.p2BtnPronto = new Button("P2 - Pronto");
		this.p2BtnPronto.setStyle(styleBotao);
				
		this.buttonsBox.getChildren().addAll(new Button[] {this.p1BtnPronto, this.btnPlay, this.p2BtnPronto});
			
		this.selecaoBox.getChildren().add(this.playersBox);
		this.selecaoBox.getChildren().add(this.personagensBox);
		this.selecaoBox.getChildren().add(this.escolhasBox);
		this.selecaoBox.getChildren().add(this.buttonsBox);
		
		this.root.getChildren().add(this.selecaoBox);
		
		return this.root;
	}
	
	public int getSize() {
		return this.size;
	}
		
	public void setAcaoBtnPlayer1(EventHandler<Event> acao) {
		this.p1BtnPronto.setOnMouseClicked(acao);;
	}
	
	public void setAcaoBtnPlayer2(EventHandler<Event> acao) {
		this.p2BtnPronto.setOnMouseClicked(acao);
	}
	
	public void setAcaobtnPlay(EventHandler<Event> acao) {
		this.btnPlay.setOnMouseClicked(acao);
	}
	
	public String getNomeP1() {
		return this.p1Inp.getText();
	}
	
	public String getNomeP2() {
		return this.p2Inp.getText();
	}

	@Override
	public void selecaoP1() {
		this.p2Inp.setDisable(true);
		this.p2BtnPronto.setDisable(true);
	}

	@Override
	public void selecaoP2() {
		this.p1Inp.setDisable(true);
		this.p1BtnPronto.setDisable(true);
		
		this.p2Inp.setDisable(false);
		this.p2BtnPronto.setDisable(false);
	}

	@Override
	public void selecaoTerminou() {
		this.p1Inp.setDisable(true);
		this.p1BtnPronto.setDisable(true);
		
		this.p2Inp.setDisable(true);
		this.p2BtnPronto.setDisable(true);
		
		this.btnPlay.setDisable(false);
	}

	@Override
	public void gerarGrid(GridPane gridPersonagens) {
		this.personagensGrid = gridPersonagens;
	}

	@Override
	public void exibirAlerta(Alert alerta) {
        alerta.showAndWait();
	}

	@Override
	public void atualizaEscolha(int cont) {
		this.lblEscolhas.setText("Escolhas Restantes: " + cont);
	}
	
}