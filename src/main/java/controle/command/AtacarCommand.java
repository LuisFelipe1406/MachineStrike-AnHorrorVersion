package controle.command;

import controle.ControladorJogo;
import modelo.ui.UiCasa;
import modelo.ui.UiCasaSelecionada;
import modelo.ui.UiPeca;
import modelo.ui.UiPecaSelecionada;

public class AtacarCommand extends Command {

	private ControladorJogo jogo;
	private UiPeca pecaAtk;
	private UiPeca pecaDef;
	
	public AtacarCommand(ControladorJogo jogo, UiPeca pecaDef) {
		this.jogo = jogo;
		this.pecaDef = pecaDef;
		this.pecaAtk = getPecaSelecionada();
	}
	
	@Override
	public void execute() {
		//Se a peça de ataque for nao nula e a peca de defesa estiver selecionada (for um ataque possivel)
		if (this.pecaAtk != null && this.getCasaDef().getEstado().getClass() == UiCasaSelecionada.class) {
			//A vida da peca apos sofrer o ataque
			int vida = this.pecaDef.getPeca().getVida() - (this.pecaAtk.getPeca().getAtaque() + this.pecaAtk.getPeca().getBonus());
			
			//Controle para manter a vida sempre nao negativa
			if (vida < 0) {
				vida = 0;
			}
				
			this.pecaDef.getPeca().setVida(vida);
			
			//Verifica se a peca morreu
			jogo.verificaMortos();
			
			//Limpa as casas para nova selecao
			jogo.limparPecas();
			jogo.limparCasas();
			
			//Atualiza o turno do jogo
			jogo.proxEstado();
		}
	}

	@Override
	public void undo() {
		this.pecaDef.getPeca().setVida(this.pecaDef.getPeca().getVida() - this.pecaAtk.getPeca().getAtaque());
	}

	@Override
	public void redo() {
		this.pecaDef.getPeca().setVida(this.pecaDef.getPeca().getVida() + this.pecaAtk.getPeca().getAtaque());
	}
	
	public UiPeca getPecaSelecionada() {
		for (UiPeca uiPeca : this.jogo.getJogo().getPersonagensJogo()) {
			if (uiPeca.getEstado().getClass() == UiPecaSelecionada.class) {
				return uiPeca;
			}
		}
		
		return null;
	}
	
	public UiCasa getCasaDef() {
		int x = this.pecaDef.getPeca().getPosicao()[0];
		int y = this.pecaDef.getPeca().getPosicao()[1];
		
		return this.jogo.getJogo().getCasasJogo()[x][y];
	}

}
