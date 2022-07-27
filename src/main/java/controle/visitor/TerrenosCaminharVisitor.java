package controle.visitor;

import modelo.pecas.Peca;
import modelo.tabuleiro.terreno.*;

public class TerrenosCaminharVisitor implements TerrenoVisitor {

	private Peca peca;
	
	public TerrenosCaminharVisitor(Peca peca) {
		this.peca = peca;
	}
	
	//Abismo só pode receber peças voadoras e estas recebem -2 de ataque
	@Override
	public void visitarAbismo(TerrenoAbismo abismo) {
		if (this.peca.getTipo().getNome() == "Voador") {
			this.peca.setBonus(-2);
		} else {
			this.peca.setMovimentoLiberado(false);
		}
	}

	//Ao estar na colina o jogador recebe +2 de ataque
	@Override
	public void visitarColina(TerrenoColina colina) {
		this.peca.setMovimentoLiberado(true);
		
		this.peca.setBonus(2);
	}

	//Ao estar na floresta o jogador e recebe +1 de ataque
	@Override
	public void visitarFloresta(TerrenoFloresta floresta) {
		this.peca.setMovimentoLiberado(true);
		
		this.peca.setBonus(+1);
	}

	//Ao estar na grama o jogador não é afetado
	@Override
	public void visitarGrama(TerrenoGrama grama) {
		this.peca.setMovimentoLiberado(true);
		
		this.peca.setBonus(0);
	}

	//Ao estar na montanha o jogador recebe +3 de ataque
	@Override
	public void visitarMontanha(TerrenoMontanha montanha) {
		this.peca.setMovimentoLiberado(true);
		
		this.peca.setBonus(3);
	}

	//Ao estar no pântano o jogador perde seu movimento e recebe -1 de ataque
	@Override
	public void visitarPantano(TerrenoPantano pantano) {
		this.peca.setMovimentoLiberado(false);
		
		this.peca.setBonus(-1);
	}

	
	
}
