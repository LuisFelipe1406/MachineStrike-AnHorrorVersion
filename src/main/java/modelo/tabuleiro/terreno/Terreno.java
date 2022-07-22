package modelo.tabuleiro.terreno;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import modelo.pecas.Peca;

public abstract class Terreno {

	private String nome;
	private Color cor;
	private Image img;
	
	public Terreno(String nome, Image img) {
		this.nome = nome;
		this.img = img;
	}
		
	public String getNome() {
		return this.nome;
	}
	
	public Color getCor() {
		return this.cor;
	}
		
	public Image getImage() {
		return this.img;
	}
		
	public String toString() {
		return this.getNome();
	}
	
	public abstract void pecaAqui(Peca peca);
	
}
