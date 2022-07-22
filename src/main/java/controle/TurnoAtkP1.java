package controle;

import controle.observer.ObserverJogo;
import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.ui.UiCasa;
import modelo.ui.UiPeca;

public class TurnoAtkP1 extends TurnoAtaque {
	
	public TurnoAtkP1(ControladorJogo jogo) {
		super(jogo);
		
		for (ObserverJogo obs : jogo.getObservadores()) {
			obs.p1Atk();
		}
		
		acoesPecas();
	}
	
	public void acoesPecas() {
		//Pecas do p1 com acoes de ataque e pecas do p2 com acoes de defesa
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			//Somente as pecas do player 1
			if (this.jogo.getJogo().getJogadores().get(0).getPecas().contains(uiPeca.getPeca())) {
				//Definir acao da peca
				uiPeca.setOnMouseClicked(acoesPecaAtk(uiPeca));
			}
		}
		
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			//Somente as pecas do player 1
			if (this.jogo.getJogo().getJogadores().get(1).getPecas().contains(uiPeca.getPeca())) {
				//Definir acao da peca
				uiPeca.setOnMouseClicked(acoesPecaDef(uiPeca));
			}
		}
	}
	
	@Override
	public void proxEstado() {
		jogo.setEstado(new TurnoMovP2(jogo));
	}

	@Override
	public void pularAVez() {
		jogo.setEstado(new TurnoMovP2(jogo));
	}

	public String toString() {
		return "Player 1 | Ataque";
	}
	
}
