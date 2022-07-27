package modelo.ui.decorator.builder;

import modelo.pecas.Peca;
import modelo.ui.decorator.UiPecaBase;
import modelo.ui.decorator.UiPecaDecorator;
import modelo.ui.decorator.UiPecaMoldura;

public class BuildMolduraPadrao implements BuildMoldura {

	@Override
	public UiPecaDecorator buildMoldura(Peca peca, int telaSize, UiPecaBase pecaBase) {
		MolduraBuilder builder = new MolduraBuilder();
		builder.peca(peca).telaSize(telaSize).pecaBase(pecaBase);
		
		UiPecaMoldura decorator = builder.build();
				
		return decorator;
	}

}
