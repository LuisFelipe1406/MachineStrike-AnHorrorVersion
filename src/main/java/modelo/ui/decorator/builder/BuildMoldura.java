package modelo.ui.decorator.builder;

import modelo.pecas.Peca;
import modelo.ui.decorator.UiPecaBase;
import modelo.ui.decorator.UiPecaDecorator;

public interface BuildMoldura {
	
	//Um builder de decorator, nesse caso, molduras
	
	public UiPecaDecorator buildMoldura(Peca peca, int telaSize, UiPecaBase pecaBase);
	
}
