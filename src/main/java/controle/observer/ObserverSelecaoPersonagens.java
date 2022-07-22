package controle.observer;

import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;

public interface ObserverSelecaoPersonagens {

	void selecaoP1();
	
	void selecaoP2();
	
	void selecaoTerminou();
	
	void gerarGrid(GridPane gridPersonagens);
	
	void atualizaEscolha(int cont);
	
	void exibirAlerta(Alert alerta);
	
}
