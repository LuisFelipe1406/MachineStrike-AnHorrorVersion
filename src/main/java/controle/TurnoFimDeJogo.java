package controle;

import controle.observer.ObserverJogo;
import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.ui.UiCasa;
import modelo.ui.UiPeca;

public class TurnoFimDeJogo extends TurnoEstado {

	public TurnoFimDeJogo(ControladorJogo jogo) {
		super(jogo);
		
		for (ObserverJogo obs : jogo.getObservadores()) {
			obs.fimDeJogo();
		}
		
		acoesPecas();
		acoesCasas();
	}
	
	public void acoesPecas() {
		//Retiramos as acoes de todas as pecas
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			uiPeca.setOnMouseClicked(acoesPeca(uiPeca));
		}
	}
	
	public void acoesCasas() {
		//Retiramos as acoes de todas as casas
		for (int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) { 
				UiCasa casa = this.jogo.getJogo().getCasasJogo()[x][y];
				
				//Definir acoes da casa
				casa.setOnMouseClicked(acoesCasa(casa));
			}
		}
	}
	
	public EventHandler<Event> acoesPeca(UiPeca uiPeca) {
		EventHandler<Event> evento = new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

			}
			
		};
		
		return evento;
	}
	
	public EventHandler<Event> acoesCasa(UiCasa uiCasa) {
		EventHandler<Event> evento = new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				
			}
			
		};
		
		return evento;
	}

	@Override
	public void proxEstado() {
		
	}

	@Override
	public void pularAVez() {
		
	}
	
	public String toString() {
		return "Fim de Jogo";
	}
	
	
}
