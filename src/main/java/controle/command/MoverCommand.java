package controle.command;

import controle.ControladorJogo;
import controle.Jogo;
import modelo.ui.UiCasa;
import modelo.ui.UiCasaNaoSelecionada;
import modelo.ui.UiCasaSelecionada;
import modelo.ui.UiPeca;
import modelo.ui.UiPecaNaoSelecionada;
import modelo.ui.UiPecaSelecionada;

public class MoverCommand extends Command {

	private ControladorJogo jogo;
	private UiPeca peca;
	private int[] posAtual;
	private UiCasa casa;
	
	public MoverCommand(ControladorJogo jogo, UiCasa casa) {
		this.jogo = jogo;
		this.peca = getPecaSelecionada();
		this.casa = casa;
	}
	
	@Override
	public void execute() {
		if (this.peca != null && this.casa.getEstado().getClass() == UiCasaSelecionada.class && !temPecaAqui(casa)) {
			this.posAtual = peca.getPeca().getPosicao();
			
			this.peca.getPeca().setPosicao(this.casa.getPosicao());
			this.peca.atualizarPosicao();

			limparPecas();
			limparCasas();
			
			this.jogo.setContMov(this.jogo.getContMov() + 1);
			
			if (this.jogo.getContMov() == 2) {
				this.jogo.proxEstado();
				
				this.jogo.resetContMov();
			}
		}
	}

	@Override
	public void undo() {
		this.peca.getPeca().setPosicao(this.posAtual);
		this.peca.atualizarPosicao();

		limparPecas();
		limparCasas();
		
		this.jogo.setContMov(this.jogo.getContMov() - 1);
	}

	@Override
	public void redo() {
		this.execute();
	}
	
	public UiPeca getPecaSelecionada() {
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {			
			if (uiPeca.getEstado().getClass() == UiPecaSelecionada.class) {
				return uiPeca;
			}
		}
		
		return null;
	}
	
	public boolean temPecaAqui(UiCasa casa) {
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {			
			if (uiPeca.getPeca().getPosicao()[0] == casa.getPosicao()[0] && uiPeca.getPeca().getPosicao()[1] == casa.getPosicao()[1]) {
				return true;
			}
		}
		
		return false;
	}
	
	public void limparPecas() {
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {			
			uiPeca.setEstado(new UiPecaNaoSelecionada(uiPeca));
		}
	}
	
	public void limparCasas() {
		for (UiCasa[] uiCasas : this.jogo.getJogo().getCasasJogo()) {
			for (UiCasa uiCasa : uiCasas) {
				uiCasa.setEstado(new UiCasaNaoSelecionada(uiCasa));
			}
		}
	}

}
