package controle.command;

import controle.ControladorJogo;
import controle.Jogo;
import controle.visitor.TerrenosCaminharVisitor;
import modelo.Jogador;
import modelo.pecas.Peca;
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
		//Verica se ha uma peca e se a casa esta entre as possibilidades de movimento
		if (this.peca != null && this.casa.getEstado().getClass() == UiCasaSelecionada.class && !temPecaAqui(casa)) {
			if (this.peca.getPeca().getMovimentoLiberado()) {
				//Guarda a posicao atual para usar no undo
				this.posAtual = peca.getPeca().getPosicao();
				
				//Move a peca
				this.peca.getPeca().setPosicao(this.casa.getPosicao());
				this.peca.atualizarPosicao();
				
				//Aplica efeito do terreno na peca
				TerrenosCaminharVisitor caminharVisitor = new TerrenosCaminharVisitor(this.peca.getPeca());
				this.casa.getTerreno().accept(caminharVisitor);
			} else {
				//Se tentar movimentar e nao conseguir ira liberar o movimento para a proxima jogada
				this.peca.getPeca().setMovimentoLiberado(true);
				
				this.jogo.gerarAlerta("Gastou movimento para sair do terreno que o prendia.");
			}
			
			//Limpa as pecas e casas
			limparPecas();
			limparCasas();
			
			//Contador de movimento para mudanca de turno
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
		for (Jogador j : this.jogo.getJogo().getJogadores()) {
			for (Peca peca : j.getPecas()) {			
				if (peca.getPosicao()[0] == casa.getPosicao()[0] && peca.getPosicao()[1] == casa.getPosicao()[1]) {
					return true;
				}
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
