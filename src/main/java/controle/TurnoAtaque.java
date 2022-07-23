package controle;

import controle.command.AtacarCommand;
import controle.command.MoverCommand;
import controle.observer.ObserverJogo;
import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.ui.UiCasa;
import modelo.ui.UiPeca;
import modelo.ui.decorator.UiPecaBase;

public abstract class TurnoAtaque extends TurnoEstado {

	public TurnoAtaque(ControladorJogo jogo) {
		super(jogo);
		
		setAcoesCasa();
	}
	
	public void setAcoesCasa() {
		for (int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) { 
				UiCasa casa = this.jogo.getJogo().getCasasJogo()[x][y];
				
				//Definir acoes da casa
				casa.setOnMouseClicked(acoesCasa(casa));
			}
		}
	}
	
	public EventHandler<Event> acoesCasa(UiCasa uiCasa) {
		EventHandler<Event> evento = new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
												
			}
			
		};
		
		return evento;
	}
	
	public void ataquesPossiveis(UiPeca uiPeca) {
		int pecaX = uiPeca.getPeca().getPosicao()[0];
		int pecaY = uiPeca.getPeca().getPosicao()[1];
		
		// Marcando possiveis ataques no eixo horizontal
		for (int x = (pecaX - uiPeca.getPeca().getAlcance()); x <= (pecaX + uiPeca.getPeca().getAlcance()); x++) {
			if (x >= 0 && x <= 7) {
				UiCasa casa = this.jogo.getJogo().getCasasJogo()[x][pecaY];
				
				if (this.jogo.temPecaAqui(casa)) {
					casa.trocarEstado();
				}				
			}
		}
		
		// Marcando possiveis ataques no eixo vertical
		for (int y = (pecaY - uiPeca.getPeca().getAlcance()); y <= (pecaY + uiPeca.getPeca().getAlcance()); y++) {
			if (y >= 0 && y <= 7) {
				UiCasa casa = this.jogo.getJogo().getCasasJogo()[pecaX][y];
				
				if (this.jogo.temPecaAqui(casa)) {
					casa.trocarEstado();
				}
			}			
		}
	}

	@Override
	public abstract void proxEstado();

	@Override
	public abstract void pularAVez();
	
}
