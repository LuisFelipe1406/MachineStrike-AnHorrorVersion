package modelo.ui;

import modelo.ui.decorator.UiPecaBase;

public abstract class UiPecaEstado {
	
	protected UiPeca uiPeca;
	
	public UiPecaEstado(UiPeca uiPeca) {
		this.uiPeca = uiPeca;
	}
	
	public abstract void proxEstado();

}
