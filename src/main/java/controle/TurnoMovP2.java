package controle;

import controle.observer.ObserverJogo;
import modelo.ui.UiPeca;

public class TurnoMovP2 extends TurnoMovimento {
	
	public TurnoMovP2(ControladorJogo jogo) {
		super(jogo);
		
		for (ObserverJogo obs : jogo.getObservadores()) {
			obs.p2Move();
		}
		
		this.jogo.setContMov(0);
		
		acoesPecas();
	}
	
	public void acoesPecas() {
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			//Somente as pecas do player 1
			if (this.jogo.getJogo().getJogadores().get(1).getPecas().contains(uiPeca.getPeca())) {
				//Definir acao da peca
				uiPeca.setOnMouseClicked(acoesPeca(uiPeca));
			}
		}
	}

	@Override
	public void proxEstado() {
		jogo.setEstado(new TurnoAtkP2(jogo));
	}

	@Override
	public void pularAVez() {
		jogo.setEstado(new TurnoMovP1(jogo));
	}
	
	public String toString() {
		return "Player 2 | Movimento";
	}

}
