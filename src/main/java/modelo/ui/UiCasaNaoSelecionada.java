package modelo.ui;

public class UiCasaNaoSelecionada extends UiCasaEstado {

	public UiCasaNaoSelecionada(UiCasa uiCasa) {
		super(uiCasa);
		
		uiCasa.setStyle("-fx-stroke: black; -fx-stroke-width: 0;");
	}

	@Override
	public void proxEstado() {
		uiCasa.setEstado(new UiCasaSelecionada(uiCasa));
	}

}
