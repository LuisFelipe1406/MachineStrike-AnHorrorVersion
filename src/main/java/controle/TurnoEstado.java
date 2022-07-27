package controle;

import controle.observer.ObserverJogo;
import javafx.scene.control.Alert;

public abstract class TurnoEstado {
	
	protected ControladorJogo jogo;
	
	public TurnoEstado(ControladorJogo jogo) {
		this.jogo = jogo;
		
		gerarAlerta(this.toString());
	}
	
	public abstract void proxEstado();
	
	public abstract void pularAVez();
	
	protected void gerarAlerta(String texto) {
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Instrução");
        dialogoInfo.setContentText(texto);
        
		for (ObserverJogo obs : jogo.getObservadores()) {
			obs.exibirAlerta(dialogoInfo);
		}
	}

}
