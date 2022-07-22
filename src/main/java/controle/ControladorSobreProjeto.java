package controle;

import javafx.scene.Scene;
import javafx.stage.Stage;
import visao.TelaSobreProjeto;

public class ControladorSobreProjeto {

	private Jogo jogo;
	private TelaSobreProjeto telaSobre;
	
	public ControladorSobreProjeto() {
		this.jogo = Jogo.getInstance();
		this.telaSobre = new TelaSobreProjeto();
		
		iniciarTela();
	}
	
	public void iniciarTela() {
		Scene cena = new Scene(telaSobre.createContent());
		
		Stage stageSobre = new Stage();
		
		stageSobre.setTitle("Ataque das Máquinas | Sobre");
		stageSobre.setScene(cena);
		stageSobre.show();
	}
	
}
