package modelo.ui.decorator;

import modelo.pecas.Peca;

public abstract class UiPecaDecorator extends UiPecaBase {

	private UiPecaBase pecaBase;
	
	public UiPecaDecorator(Peca peca, int telaSize, UiPecaBase pecaBase) {
		super(peca, telaSize);
		this.pecaBase = pecaBase;
	}
	
	public UiPecaBase getPecaBase() {
		return this.pecaBase;
	}
	
	@Override
	public void atualizarImg() {
		this.pecaBase.atualizarImg();
	}

}
