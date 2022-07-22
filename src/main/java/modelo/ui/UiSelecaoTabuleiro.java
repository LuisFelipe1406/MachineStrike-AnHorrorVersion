package modelo.ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.tabuleiro.Tabuleiro;

public class UiSelecaoTabuleiro extends ImageView {

	//Estendemos a ImageView do JavaFx para criar um nó nosso no qual podemos armazenar o tabuleiro a qual ele se refere
	//Isso foi feito para podermos manipular o tabuleiro e consequentemente sua imagem
		
	private Tabuleiro tabuleiro;
	
	public UiSelecaoTabuleiro(Image img, Tabuleiro tabuleiro) {
		super(img);
		this.tabuleiro = tabuleiro;
	}
	
	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}
	
	
	public void atualizarImg() {
		this.tabuleiro.TrocarEstado();
		this.setImage(this.tabuleiro.getImage());
	}
	
}
