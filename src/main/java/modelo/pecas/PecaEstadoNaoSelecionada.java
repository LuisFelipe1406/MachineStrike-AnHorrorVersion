package modelo.pecas;

import java.io.File;
import javafx.scene.image.Image;

public class PecaEstadoNaoSelecionada extends PecaEstado {

	public PecaEstadoNaoSelecionada(Peca peca) {
		super(peca);
		this.peca.setImage(new Image(new File("recursos/imagens/personagens/"+this.peca.getNome()+"BW.png").toURI().toString()));		
	}
	
	@Override
	public void proxEstado() {
		this.peca.setEstado(new PecaEstadoSelecionada(this.peca));
	}	
	
}
