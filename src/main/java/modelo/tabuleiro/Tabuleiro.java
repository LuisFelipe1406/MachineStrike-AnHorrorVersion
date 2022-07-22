package modelo.tabuleiro;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import modelo.tabuleiro.terreno.Terreno;

public abstract class Tabuleiro {

	private String nome;
	protected Terreno[][] casas;
	private Image img;
	private TabuleiroEstado estado;
	
	public Tabuleiro(String nome, Terreno[][] casas) {
		this.nome = nome;
		this.casas = casas;
		this.estado = new TabuleiroEstadoNaoSelecionado(this);
	}
	
	public String getNome() {
		return this.nome;
	}
		
	public Terreno[][] getCasas() {
		return this.casas;
	}
	
	public void setImage(Image img) {
		this.img = img;
	}
	
	public Image getImage() {
		return this.img;
	}
	
	public void setEstado(TabuleiroEstado estado) {
		this.estado = estado;
	}
	
	public TabuleiroEstado getEstado() {
		return this.estado;
	}
	
	public void TrocarEstado() {
		this.estado.proxEstado();
	}
	
}
