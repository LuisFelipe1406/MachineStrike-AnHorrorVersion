package modelo.ui;

import javafx.scene.effect.ColorAdjust;
import modelo.ui.decorator.UiPecaBase;

public class UiPecaNaoSelecionada extends UiPecaEstado {

	public UiPecaNaoSelecionada(UiPeca uiPeca) {
		super(uiPeca);
				
		ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(0);
        
        uiPeca.setEffect(colorAdjust);
	}

	@Override
	public void proxEstado() {
		this.uiPeca.setEstado(new UiPecaSelecionada(this.uiPeca));
	}

}
