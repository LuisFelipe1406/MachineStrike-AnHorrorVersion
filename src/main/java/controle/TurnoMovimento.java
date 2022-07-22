package controle;

import controle.command.CommandInvoker;
import controle.command.MoverCommand;
import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.tabuleiro.terreno.Terreno;
import modelo.ui.UiCasa;
import modelo.ui.UiPeca;

public abstract class TurnoMovimento extends TurnoEstado {
	
	public TurnoMovimento(ControladorJogo jogo) {
		super(jogo);
		
		this.jogo.setContMov(0);
		
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
				jogo.getCi().execute(new MoverCommand(uiCasa));
				
				jogo.limparPecas();
				jogo.limparCasas();
				
				if (jogo.getContMov() == 2) {
					proxEstado();
					
					jogo.resetContMov();
				}
			}
			
		};
		
		return evento;
	}
	
	public EventHandler<Event> acoesPeca(UiPeca uiPeca) {
		EventHandler<Event> evento = new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				jogo.limparPecas();
				jogo.limparCasas();
				
				uiPeca.trocarEstado();
				
				movimentosPossiveis(uiPeca);
			}
			
		};
		
		return evento;
	}
	
	public void movimentosPossiveis(UiPeca uiPeca) {
		int pecaX = uiPeca.getPeca().getPosicao()[0];
		int pecaY = uiPeca.getPeca().getPosicao()[1];
		
		// Marcando possiveis movimentos no eixo horizontal
		for (int x = (pecaX - uiPeca.getPeca().getMovimento()); x <= (pecaX + uiPeca.getPeca().getMovimento()); x++) {
			if (x >= 0 && x <= 7) {
				UiCasa casa = jogo.getJogo().getCasasJogo()[x][pecaY];
				casa.trocarEstado();
			}
		}
		
		// Marcando possiveis movimentos no eixo vertical
		for (int y = (pecaY - uiPeca.getPeca().getMovimento()); y <= (pecaY + uiPeca.getPeca().getMovimento()); y++) {
			if (y >= 0 && y <= 7) {
				UiCasa casa = jogo.getJogo().getCasasJogo()[pecaX][y];
				casa.trocarEstado();
			}			
		}
	}

	@Override
	public abstract void proxEstado();

	@Override
	public abstract void pularAVez();

}
