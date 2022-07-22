package modelo.ui;

public abstract class UiCasaEstado {

	protected UiCasa uiCasa;
	
	public UiCasaEstado(UiCasa uiCasa) {
		this.uiCasa = uiCasa;
	}
	
	public abstract void proxEstado();

	
}
