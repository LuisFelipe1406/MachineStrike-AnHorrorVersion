package controle;

import controle.command.AtacarCommand;
import controle.observer.ObserverJogo;
import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.ui.UiPeca;
import modelo.ui.decorator.UiPecaBase;
import modelo.ui.decorator.UiPecaMoldura;
import modelo.ui.decorator.UiPecaMolduraBorda;

public class TurnoAtkP2 extends TurnoAtaque {

	public TurnoAtkP2(ControladorJogo jogo) {
		super(jogo);
		
		for (ObserverJogo obs : jogo.getObservadores()) {
			obs.p2Atk();
			obs.exibirAlerta(gerarAlerta("Player 2 | Turno de Ataque"));
		}
		
		acoesPecas();
	}
	
	public void acoesPecas() {
		//Pecas do p2 com acoes de ataque e pecas do p1 com acoes de defesa
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			//Somente as pecas do player 1
			if (this.jogo.getJogo().getJogadores().get(1).getPecas().contains(uiPeca.getPeca())) {				
				//Definir acao da peca
				uiPeca.setOnMouseClicked(acoesPecaAtk(uiPeca));
			}
		}
		
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			//Somente as pecas do player 1
			if (this.jogo.getJogo().getJogadores().get(0).getPecas().contains(uiPeca.getPeca())) {				
				//Definir acao da peca
				uiPeca.setOnMouseClicked(acoesPecaDef(uiPeca));
			}
		}
	}
	
	public EventHandler<Event> acoesPecaAtk(UiPeca uiPeca) {
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
				
				ataquesPossiveis(uiPeca);
			}
			
		};
		
		return evento;
	}
	
	public EventHandler<Event> acoesPecaDef(UiPeca uiPeca) {
		EventHandler<Event> evento = new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				jogo.getCi().execute(new AtacarCommand(jogo, uiPeca));		
			}
			
		};
		
		return evento;
	}
	
	@Override
	public void proxEstado() {
		jogo.setEstado(new TurnoMovP1(jogo));
	}

	@Override
	public void pularAVez() {
		jogo.setEstado(new TurnoMovP1(jogo));
	}

	public String toString() {
		return "Player 2 | Ataque";
	}
	
}
