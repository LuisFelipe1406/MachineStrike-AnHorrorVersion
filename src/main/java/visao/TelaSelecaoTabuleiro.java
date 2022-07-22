package visao;

import controle.observer.ObserverSelecaoTabuleiro;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelo.ui.UiSelecaoTabuleiro;

public class TelaSelecaoTabuleiro extends VBox implements ObserverSelecaoTabuleiro {

	private final int size = 80;
	private final int width = 10;
	private final int heigth = 8;
	private Pane root;
	private VBox selecaoBox;
	private HBox tabuleirosBox;
	private GridPane tabuleirosGrid;
	private HBox randomBox;
	private Label lblTabRandom;
	private UiSelecaoTabuleiro uiTabRandom;
	private HBox btnBox;
	private TextField inpSelTab;
	private Button btnSelecaoPersonagens;
	
	public TelaSelecaoTabuleiro() {
		super();
	}
	
	public Parent createContent() {
		this.root = new Pane();
		this.root.setPrefSize((width * size), (heigth * size));
		
		this.selecaoBox = new VBox();
		this.selecaoBox.setPrefSize((width * size), (heigth * size));
		this.selecaoBox.setAlignment(Pos.CENTER);
		
		this.tabuleirosBox = new HBox();
		this.tabuleirosBox.setPrefSize((width * size), (heigth * size));
		this.tabuleirosBox.setAlignment(Pos.CENTER);

		this.tabuleirosGrid.setAlignment(Pos.CENTER);
		this.tabuleirosBox.getChildren().add(this.tabuleirosGrid);
		
		this.randomBox = new HBox();
		this.randomBox.setPrefSize((width * size), (heigth * size));
		this.randomBox.setAlignment(Pos.CENTER);
		this.randomBox.setStyle("-fx-spacing: 20px");
		
		
		this.lblTabRandom = new Label("Usar tabuleiro aleatório:");
		this.lblTabRandom.setStyle("-fx-font: 18 calibri");
		
		this.randomBox.getChildren().add(this.lblTabRandom);
		this.randomBox.getChildren().add(this.uiTabRandom);
		
		this.btnBox = new HBox();
		this.btnBox.setPrefSize((width * size), (heigth * size));
		this.btnBox.setAlignment(Pos.CENTER);
		
		this.btnSelecaoPersonagens = new Button("Selecionar Personagens");
		this.btnSelecaoPersonagens.setAlignment(Pos.CENTER);
		this.btnSelecaoPersonagens.setStyle("-fx-pref-height: 50px;" +
                				            "-fx-pref-width: 150px;");
		this.btnSelecaoPersonagens.setDisable(true);
		
		this.inpSelTab = new TextField();
		this.inpSelTab.setDisable(true);
		
		this.btnBox.getChildren().add(this.inpSelTab);
		this.btnBox.getChildren().add(this.btnSelecaoPersonagens);
		
		this.btnBox.setStyle("-fx-spacing: 150px");
		
		this.selecaoBox.getChildren().add(this.tabuleirosBox);
		this.selecaoBox.getChildren().add(this.randomBox);
		this.selecaoBox.getChildren().add(this.btnBox);
		
		root.getChildren().add(this.selecaoBox);
		
		return this.root;
	}
	
	public void setAcaoBtnSelecao(EventHandler<Event> event) {
		this.btnSelecaoPersonagens.setOnMouseClicked(event);
	}

	@Override
	public void gerarGrid(GridPane gridTabuleiros) {
		this.tabuleirosGrid = gridTabuleiros;
	}
	
	@Override
	public void gerarTabRandom(UiSelecaoTabuleiro uiSelTabuleiro) {
		this.uiTabRandom = uiSelTabuleiro;
	}

	@Override
	public void exibirAlerta(Alert alerta) {
        alerta.showAndWait();
	}

	@Override
	public void indicarTabuleiro(String texto) {
		this.inpSelTab.setText(texto);
	}

	@Override
	public void TabuleiroEscolhido() {
		this.btnSelecaoPersonagens.setDisable(false);
	}	
	
}
