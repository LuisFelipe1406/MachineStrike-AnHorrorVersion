package modelo.ui.decorator;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.pecas.Peca;
import modelo.ui.UiPecaEstado;
import modelo.ui.UiPecaNaoSelecionada;

public abstract class UiPecaBase extends Group {
	
	//Estendemos a ImageView do JavaFx para criar um nó nosso no qual podemos armazenar a peca a qual ele se refere
	//Isso foi feito para podermos manipular o estado da peca e consequentemente sua imagem
	
	private ImageView imgview;
	protected Peca peca;	
	protected int telaSize;
	
	public UiPecaBase(Peca peca, int telaSize) {
		this.imgview = new ImageView(peca.getImage());
		this.telaSize = telaSize;
		this.peca = peca;
		
		super.prefHeight((this.telaSize));
		super.prefWidth((this.telaSize));
		this.imgview.setFitHeight(this.telaSize);
		this.imgview.setFitWidth(this.telaSize);
		
		super.getChildren().add(imgview);
	}
	
	public Peca getPeca() {
		return this.peca;
	}
	
	public void setarImagem(Image imagem) {
		this.imgview.setImage(imagem);
	}
	
	public abstract void atualizarImg();

}
