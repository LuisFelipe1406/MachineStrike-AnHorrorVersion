package modelo.tabuleiro;

import java.io.File;

import javafx.scene.image.Image;

public class TabuleiroEstadoNaoSelecionado extends TabuleiroEstado {

	public TabuleiroEstadoNaoSelecionado(Tabuleiro tabuleiro) {
		super(tabuleiro);
		
		tabuleiro.setImage(new Image(new File("recursos/imagens/TabuleiroBW.png").toURI().toString()));
	}

	@Override
	public void proxEstado() {
		tabuleiro.setEstado(new TabuleiroEstadoSelecionado(tabuleiro));
	}
		
}
