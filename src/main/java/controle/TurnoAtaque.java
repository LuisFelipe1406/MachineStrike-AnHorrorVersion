package controle;

import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.ui.UiCasa;
import modelo.ui.UiPeca;

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

	@Override
	public abstract void proxEstado();

	@Override
	public abstract void pularAVez();
	
}
