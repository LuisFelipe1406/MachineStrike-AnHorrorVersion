package modelo.pecas;

import java.io.File;

import javafx.scene.image.Image;

public class PecaEstadoSelecionada extends PecaEstado {

	public PecaEstadoSelecionada(Peca peca) {
		super(peca);
		this.peca.setImage(new Image(new File("recursos/imagens/personagens/"+this.peca.getNome()+".png").toURI().toString()));
	}
	
	@Override
	public void proxEstado() {
		this.peca.setEstado(new PecaEstadoNaoSelecionada(this.peca));
	}	
	
}
