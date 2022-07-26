package controle.observer;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import modelo.ui.decorator.UiPecaBase;

public interface ObserverJogo {

	void p1Move();
	
	void p1Atk();
	
	void p2Move();
	
	void p2Atk();
	
	void fimDeJogo();
	
	void p1Selecao(UiPecaBase peca);
	
	void p2Selecao(UiPecaBase peca);
	
	void atualizarVidaP1(Image img);
	
	void atualizarVidaP2(Image img);
	
	void exibirAlerta(Alert alerta);
	
}
