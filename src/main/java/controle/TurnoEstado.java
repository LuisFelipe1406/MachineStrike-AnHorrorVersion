package controle;

import javafx.scene.control.Alert;

public abstract class TurnoEstado {
	
	protected ControladorJogo jogo;
	
	public TurnoEstado(ControladorJogo jogo) {
		this.jogo = jogo;
	}
	
	public abstract void proxEstado();
	
	public abstract void pularAVez();
	
	protected Alert gerarAlerta(String texto) {
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Instrução");
        dialogoInfo.setContentText(texto);
        
        return dialogoInfo;
	}

}
