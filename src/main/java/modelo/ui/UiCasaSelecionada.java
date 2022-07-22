package modelo.ui;

public class UiCasaSelecionada extends UiCasaEstado {

	public UiCasaSelecionada(UiCasa uiCasa) {
		super(uiCasa);
		
		uiCasa.setStyle("-fx-stroke: blue; -fx-stroke-width: 1;");		
	}

	@Override
	public void proxEstado() {
		uiCasa.setEstado(new UiCasaNaoSelecionada(uiCasa));
	}

}
