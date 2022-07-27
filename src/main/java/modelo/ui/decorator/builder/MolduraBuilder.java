package modelo.ui.decorator.builder;

import modelo.pecas.Peca;
import modelo.ui.decorator.UiPecaBase;
import modelo.ui.decorator.UiPecaMoldura;

public class MolduraBuilder {

	public Peca peca;
	public int telaSize;
	public UiPecaBase pecaBase;
	
	public MolduraBuilder peca(Peca peca) {
		this.peca = peca;
		
		return this;
	}
	
	public MolduraBuilder telaSize(int telaSize) {
		this.telaSize = telaSize;
		
		return this;
	}
	
	public MolduraBuilder pecaBase(UiPecaBase pecaBase) {
		this.pecaBase = pecaBase;
		
		return this;
	}
	
	public UiPecaMoldura build() {
		UiPecaMoldura decorator = new UiPecaMoldura(this);
		
		return decorator;
	}
	
	public void reset() {
		this.peca = null;
		this.telaSize = 0;
		this.pecaBase = null;
	}
	
}
