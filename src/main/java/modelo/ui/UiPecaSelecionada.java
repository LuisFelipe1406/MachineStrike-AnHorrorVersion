package modelo.ui;

import javafx.scene.effect.ColorAdjust;
import modelo.ui.decorator.UiPecaBase;

public class UiPecaSelecionada extends UiPecaEstado {

	public UiPecaSelecionada(UiPeca uiPeca) {
		super(uiPeca);
				
		ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(+0.3);
        
        uiPeca.setEffect(colorAdjust);
	}

	@Override
	public void proxEstado() {
		this.uiPeca.setEstado(new UiPecaNaoSelecionada(this.uiPeca));
	}	
	
}
