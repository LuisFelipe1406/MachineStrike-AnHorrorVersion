package modelo.ui;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import modelo.tabuleiro.terreno.Terreno;

public class UiCasa extends Rectangle {
	
	private Terreno terreno;
	private int[] posicao;
	private int telaSize;
	private UiCasaEstado estado;
	
	public UiCasa(Terreno terreno, int x, int y, int telaSize) {
		this.posicao = new int[] {x, y};
		this.telaSize = telaSize;
		this.estado = new UiCasaNaoSelecionada(this);
		
		setWidth(this.telaSize);
		setHeight(this.telaSize);
		
		relocate((this.posicao[0] * this.telaSize), (this.posicao[1] * this.telaSize));
		
		setFill(new ImagePattern(terreno.getImage()));
	}
	
	public int[] getPosicao() {
		return posicao;
	}

	public void setEstado(UiCasaEstado estado) {
		this.estado = estado;
	}
	
	public UiCasaEstado getEstado() {
		return this.estado;
	}
	
	public void trocarEstado() {
		this.estado.proxEstado();
	}
	
	public Terreno getTerreno() {
		return this.terreno;
	}
	
}
