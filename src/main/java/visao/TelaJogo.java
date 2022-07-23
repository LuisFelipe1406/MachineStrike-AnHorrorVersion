package visao;

import java.io.File;

import controle.observer.ObserverJogo;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelo.ui.decorator.UiPecaBase;
import modelo.ui.decorator.UiPecaMoldura;

public class TelaJogo implements ObserverJogo {

	private final int size = 80;
	private final int width = 16;
	private final int heigth = 8;
	private HBox jogo;
	private VBox p1Box;
	private Label p1Nome;
	private ImageView p1Pontos;
	private VBox p1BtnBox;
	private Button p1ReverseMove;
	private Button p1PassarAvez;
	private Button p1Arrancada;
	private Label p1Selecionado;
	private UiPecaBase p1ImgSelecionado;
	private VBox tabuleiro;
	private VBox p2Box;
	private Label p2Nome;
	private ImageView p2Pontos;
	private VBox p2BtnBox;
	private Button p2ReverseMove;
	private Button p2PassarAvez;
	private Button p2Arrancada;
	private Label p2Selecionado;
	private UiPecaBase p2ImgSelecionado; 
	private Group grupoCasa;
    private Group grupoPeca;
    
    public TelaJogo() {    	
    	this.grupoCasa = new Group();
    	this.grupoPeca = new Group();
    }
	
	public Parent createContent() {
		Pane root = new Pane();
		
		String txtStyle =  "-fx-padding: 40px 0 0 0;" +
		                   "-fx-font-size: 28 calibri;" +
		                   "-fx-font-weight: bold;";
		
		String btnBoxStyle = "-fx-padding: 50px 0 0 0;" +
				             "-fx-spacing: 30px";
		
		String btnStyle = "-fx-pref-height: 50px;" +
	                      "-fx-pref-width: 100px;";
		
		//Box de tudo
		this.jogo = new HBox();
		this.jogo.setPrefSize((width * size), (heigth * size));
		this.jogo.setAlignment(Pos.CENTER);
		
		//Box do Player 1, localizada a esquerda
		this.p1Box = new VBox();
		this.p1Box.setPrefSize(((width / 4) * size), (heigth * size));
		this.p1Box.setAlignment(Pos.TOP_CENTER);
		
		this.p1Nome = new Label();
		this.p1Nome.setText("Player 1");
		this.p1Nome.setStyle(txtStyle);
		
		Image pontos = new Image(new File("recursos/imagens/vida/7 vidas.png").toURI().toString());
		this.p1Pontos = new ImageView(pontos);
		
		this.p1BtnBox = new VBox();
		this.p1BtnBox.setAlignment(Pos.TOP_CENTER);
		this.p1BtnBox.setStyle(btnBoxStyle);
		
		this.p1ReverseMove = new Button("Reverter Movimento");
		this.p1ReverseMove.setStyle("-fx-pref-height: 50px;" +
                				    "-fx-pref-width: 130px;");
		
		this.p1PassarAvez = new Button("Passar a Vez");
		this.p1PassarAvez.setStyle(btnStyle);
		
		this.p1Arrancada = new Button("Arrancada");
		this.p1Arrancada.setStyle(btnStyle);
				
		this.p1BtnBox.getChildren().add(this.p1PassarAvez);
		this.p1BtnBox.getChildren().add(this.p1ReverseMove);
		this.p1BtnBox.getChildren().add(this.p1Arrancada);
		
		this.p1Selecionado = new Label("Peça Selecionada");
		this.p1Selecionado.setStyle("-fx-padding: 40px 0 30px 0;" +
									"-fx-font-size: 28 calibri;" +
                					"-fx-font-weight: bold;");		
		
		this.p1Box.getChildren().add(this.p1Nome);
		this.p1Box.getChildren().add(this.p1Pontos);
		this.p1Box.getChildren().add(this.p1BtnBox);
		this.p1Box.getChildren().add(this.p1Selecionado);

		//Box do tabuleiro, no centro
		this.tabuleiro = new VBox();
		this.tabuleiro.setPrefSize(((width / 2) * size), (heigth * size));
		this.tabuleiro.setAlignment(Pos.CENTER);
		
		//Box do Player 2, localizada a direita
		this.p2Box = new VBox();
		this.p2Box.setPrefSize(((width / 4) * size), (heigth * size));
		this.p2Box.setAlignment(Pos.TOP_CENTER);
		
		this.p2Nome = new Label();
		this.p2Nome.setText("Player 2");
		this.p2Nome.setStyle(txtStyle);
		
		this.p2Pontos = new ImageView(pontos);
		
		this.p2BtnBox = new VBox();
		this.p2BtnBox.setAlignment(Pos.TOP_CENTER);
		this.p2BtnBox.setStyle(btnBoxStyle);
		
		this.p2ReverseMove = new Button("Reverter Movimento");
		this.p2ReverseMove.setStyle("-fx-pref-height: 50px;" +
			                        "-fx-pref-width: 130px;");
		
		this.p2PassarAvez = new Button("Passar a Vez");
		this.p2PassarAvez.setStyle(btnStyle);
		
		this.p2Arrancada = new Button("Arrancada");
		this.p2Arrancada.setStyle(btnStyle);
		
		this.p2BtnBox.getChildren().add(this.p2PassarAvez);
		this.p2BtnBox.getChildren().add(this.p2ReverseMove);
		this.p2BtnBox.getChildren().add(this.p2Arrancada);
		
		this.p2Selecionado = new Label("Peça Selecionada");
		this.p2Selecionado.setStyle("-fx-padding: 40px 0 30px 0;" +
									"-fx-font-size: 28 calibri;" +
									"-fx-font-weight: bold;");		
		
		this.p2Box.getChildren().add(this.p2Nome);
		this.p2Box.getChildren().add(this.p2Pontos);
		this.p2Box.getChildren().add(this.p2BtnBox);
		this.p2Box.getChildren().add(this.p2Selecionado);
		
		this.grupoCasa.getChildren().add(grupoPeca);
		this.tabuleiro.getChildren().add(grupoCasa);
		
		this.jogo.getChildren().addAll(this.p1Box, this.tabuleiro, this.p2Box);
		
		root.getChildren().add(this.jogo);
		
		return root;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Group getGrupoCasa() {
		return this.grupoCasa;
	}
	
	public Group getGrupoPeca() {
		return this.grupoPeca;
	}
	
	public Label getP1Nome() {
		return this.p1Nome;
	}
	
	public Label getP2Nome() {
		return this.p2Nome;
	}
	
	public void setAcaoBtnPassarAVezP1(EventHandler<Event> acao) {
		this.p1PassarAvez.setOnMouseClicked(acao);
	}
	
	public void setAcaoBtnPassarAVezP2(EventHandler<Event> acao) {
		this.p2PassarAvez.setOnMouseClicked(acao);
	}
	
	public void setAcaoBtnArrancada(EventHandler<Event> acao) {
		this.p1Arrancada.setOnMouseClicked(acao);
		this.p2Arrancada.setOnMouseClicked(acao);
	}
	
	public void setAcaoBtnp1ReverseMove(EventHandler<Event> acao) {
		this.p1ReverseMove.setOnMouseClicked(acao);
		this.p2ReverseMove.setOnMouseClicked(acao);
	}

	@Override
	public void p1Move() {
		this.p1ReverseMove.setDisable(false);
		this.p1PassarAvez.setDisable(false);
		this.p1Arrancada.setDisable(true);
		
		this.p2ReverseMove.setDisable(true);
		this.p2PassarAvez.setDisable(true);
		this.p2Arrancada.setDisable(true);
	}
	
	@Override
	public void p1Atk() {
		this.p1ReverseMove.setDisable(true);
		this.p1PassarAvez.setDisable(false);
		this.p1Arrancada.setDisable(false);
		
		this.p2ReverseMove.setDisable(true);
		this.p2PassarAvez.setDisable(true);
		this.p2Arrancada.setDisable(true);
	}	

	@Override
	public void p2Move() {
		this.p1ReverseMove.setDisable(true);
		this.p1PassarAvez.setDisable(true);
		this.p1Arrancada.setDisable(true);
		
		this.p2ReverseMove.setDisable(false);
		this.p2PassarAvez.setDisable(false);
		this.p2Arrancada.setDisable(true);
	}
	
	@Override
	public void p2Atk() {
		this.p1ReverseMove.setDisable(true);
		this.p1PassarAvez.setDisable(true);
		this.p1Arrancada.setDisable(true);
		
		this.p2ReverseMove.setDisable(true);
		this.p2PassarAvez.setDisable(false);
		this.p2Arrancada.setDisable(false);
	}

	@Override
	public void p1Selecao(UiPecaBase peca) {
		if (this.p1Box.getChildren().size() == 5) {
			this.p1Box.getChildren().remove(4);
		}
		
		this.p1Box.getChildren().add(peca);
	}

	@Override
	public void p2Selecao(UiPecaBase peca) {
		if (this.p2Box.getChildren().size() == 5) {
			this.p2Box.getChildren().remove(4);
		}
		
		this.p2Box.getChildren().add(peca);
	}

	@Override
	public void atualizarVidaP1(Image img) {
		this.p1Pontos.setImage(img);
	}
	
	public void atualizarVidaP2(Image img) {
		this.p2Pontos.setImage(img);
	}	
	
}