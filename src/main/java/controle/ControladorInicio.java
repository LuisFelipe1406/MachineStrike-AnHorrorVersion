package controle;

import java.io.IOException;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import visao.TelaInicial;

public class ControladorInicio {

	private Jogo jogo;
	private TelaInicial telaInicial;
	private Stage inicial;
	
	public ControladorInicio(Stage inicial) {
		this.jogo = Jogo.getInstance();
		this.telaInicial = new TelaInicial();
		this.inicial = inicial;
		
		iniciarTela();
		iniciarBotoes();
	}
	
	public void iniciarTela() {
		Scene cena = new Scene(telaInicial.createContent());
		
		this.inicial.setTitle("Ataque das Máquinas");
		this.inicial.setScene(cena);
		this.inicial.show();
	}
	
	public void iniciarBotoes() {
		this.telaInicial.setAcaoBtnPlay(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				try {
					ControladorSelecaoTabuleiro controladorSelecaoTabuleiro = new ControladorSelecaoTabuleiro();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		this.telaInicial.setAcaoBtnSobre(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ControladorSobreProjeto controladorSobre = new ControladorSobreProjeto();
			}
			
		});
		
		this.telaInicial.setAcaoBtnExit(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				inicial.close();
			}
		});
	}	
	
}
