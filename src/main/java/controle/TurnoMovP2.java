package controle;

import controle.observer.ObserverJogo;
import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.ui.UiPeca;
import modelo.ui.decorator.UiPecaBase;
import modelo.ui.decorator.UiPecaMoldura;
import modelo.ui.decorator.UiPecaMolduraBorda;
import modelo.ui.decorator.builder.MolduraBuilder;

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
		//As pecas do player 2 movem e as do player 1 nao fazem nada
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			//Somente as pecas do player 2
			if (this.jogo.getJogo().getJogadores().get(1).getPecas().contains(uiPeca.getPeca())) {				
				//Definir acao da peca
				uiPeca.setOnMouseClicked(acoesPeca(uiPeca));
			}
		}
		
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			//Somente as pecas do player 1
			if (this.jogo.getJogo().getJogadores().get(0).getPecas().contains(uiPeca.getPeca())) {				
				//Definir acao da peca
				uiPeca.setOnMouseClicked(null);
			}
		}
	}
	
	public EventHandler<Event> acoesPeca(UiPeca uiPeca) {
		EventHandler<Event> evento = new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				jogo.limparPecas();
				jogo.limparCasas();
				
				for (ObserverJogo obs : jogo.getObservadores()) {
					UiPecaBase pecaMoldura = new UiPecaMolduraBorda(uiPeca.getPeca(), 80, uiPeca);
					
					obs.p2Selecao(pecaMoldura);
				}
				
				uiPeca.trocarEstado();
				
				movimentosPossiveis(uiPeca);
			}
			
		};
		
		return evento;
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
		return "Player 2 | Turno de Movimento";
	}

}
