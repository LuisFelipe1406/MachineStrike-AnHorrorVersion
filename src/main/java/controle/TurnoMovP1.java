package controle;

import controle.command.MoverCommand;
import controle.observer.ObserverJogo;
import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.pecas.Peca;
import modelo.ui.UiCasa;
import modelo.ui.UiPeca;
import modelo.ui.decorator.UiPecaBase;
import modelo.ui.decorator.UiPecaMoldura;
import modelo.ui.decorator.UiPecaMolduraBorda;

public class TurnoMovP1 extends TurnoMovimento {

	public TurnoMovP1(ControladorJogo jogo) {
		super(jogo);
		
		for (ObserverJogo obs : jogo.getObservadores()) {
			obs.p1Move();
			obs.exibirAlerta(gerarAlerta("Player 1 | Turno de Movimento"));
		}
		
		acoesPecas();
	}
	
	public void acoesPecas() {
		//As pecas do player 1 movem e as do player 2 nao fazem nada
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			//Somente as pecas do player 1
			if (this.jogo.getJogo().getJogadores().get(0).getPecas().contains(uiPeca.getPeca())) {	
				//Definir acao da peca
				uiPeca.setOnMouseClicked(acoesPeca(uiPeca));
			}
		}
		
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			//Somente as pecas do player 2
			if (this.jogo.getJogo().getJogadores().get(1).getPecas().contains(uiPeca.getPeca())) {				
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
					
					obs.p1Selecao(pecaMoldura);
				}
				
				uiPeca.trocarEstado();
				
				movimentosPossiveis(uiPeca);
			}
			
		};
		
		return evento;
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
