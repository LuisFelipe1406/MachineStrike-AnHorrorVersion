package controle.command;

import controle.Jogo;
import modelo.ui.UiPeca;
import modelo.ui.UiPecaSelecionada;

public class AtacarCommand extends Command {

	private Jogo jogo;
	private UiPeca pecaAtk;
	private UiPeca pecaDef;
	
	public AtacarCommand(UiPeca pecaDef) {
		this.jogo = Jogo.getInstance();
		this.pecaDef = pecaDef;
		this.pecaAtk = getPecaSelecionada();
	}
	
	@Override
	public void execute() {
		if (this.pecaAtk != null) {
			System.out.println(this.pecaAtk.getPeca() + " atacou " + this.pecaDef.getPeca());
		}
	}

	@Override
	public void undo() {
		
	}

	@Override
	public void redo() {
		
	}
	
	public UiPeca getPecaSelecionada() {
		for (UiPeca uiPeca : this.jogo.getPersonagensJogo()) {
			if (uiPeca.getEstado().getClass() == UiPecaSelecionada.class) {
				return uiPeca;
			}
		}
		
		return null;
	}

}
