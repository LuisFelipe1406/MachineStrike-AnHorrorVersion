package controle.observer;

import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import modelo.ui.UiSelecaoTabuleiro;

public interface ObserverSelecaoTabuleiro {

	void gerarGrid(GridPane gridTabuleiros);
	
	void gerarTabRandom(UiSelecaoTabuleiro uiSelTabuleiro);
	
	void indicarTabuleiro(String texto);
	
	void TabuleiroEscolhido();
	
	void exibirAlerta(Alert alerta);
	
}
