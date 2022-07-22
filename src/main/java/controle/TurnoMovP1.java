package controle;

import controle.command.MoverCommand;
import controle.observer.ObserverJogo;
import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.pecas.Peca;
import modelo.ui.UiCasa;
import modelo.ui.UiPeca;

public class TurnoMovP1 extends TurnoMovimento {

	public TurnoMovP1(ControladorJogo jogo) {
		super(jogo);
		
		for (ObserverJogo obs : jogo.getObservadores()) {
			obs.p1Move();
		}
		
		acoesPecas();
	}
	
	public void acoesPecas() {
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			//Somente as pecas do player 1
			if (this.jogo.getJogo().getJogadores().get(0).getPecas().contains(uiPeca.getPeca())) {
				//Definir acao da peca
				uiPeca.setOnMouseClicked(acoesPeca(uiPeca));
			}
		}
	}
	
	@Override
	public void proxEstado() {
		jogo.setEstado(new TurnoAtkP1(jogo));
	}

	@Override
	public void pularAVez() {
		jogo.setEstado(new TurnoMovP2(jogo));
	}

	public String toString() {
		return "Player 1 | Movimento";
	}
	
}
