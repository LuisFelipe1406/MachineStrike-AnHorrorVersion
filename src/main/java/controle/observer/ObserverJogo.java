package controle.observer;

import javafx.scene.image.Image;
import modelo.ui.decorator.UiPecaBase;

public interface ObserverJogo {

	public void p1Move();
	
	public void p1Atk();
	
	public void p2Move();
	
	public void p2Atk();
	
	public void p1Selecao(UiPecaBase peca);
	
	public void p2Selecao(UiPecaBase peca);
	
	public void atualizarVidaP1(Image img);
	
	public void atualizarVidaP2(Image img);
	
}
