package modelo.tabuleiro;

import java.io.File;

import javafx.scene.image.Image;

public class TabuleiroEstadoSelecionado extends TabuleiroEstado {

	public TabuleiroEstadoSelecionado(Tabuleiro tabuleiro) {
		super(tabuleiro);
		
		tabuleiro.setImage(new Image(new File("recursos/imagens/Tabuleiro.png").toURI().toString()));
	}

	@Override
	public void proxEstado() {
		tabuleiro.setEstado(new TabuleiroEstadoNaoSelecionado(tabuleiro));
	}
	
	
}
