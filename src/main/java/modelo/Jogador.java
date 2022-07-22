package modelo;

import java.util.ArrayList;
import java.util.List;

import controle.visitor.JogadorVisitor;
import modelo.pecas.Peca;

public abstract class Jogador {

	private String nome;
	private int pontos;
	private List<Peca> conjunto;
	
	public Jogador(String nome) {
		this.nome = nome;
		this.pontos = 0;
		this.conjunto = new ArrayList<Peca>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void addPonto() {
		this.pontos++;
	}
	
	public void zerarPontos() {
		this.pontos = 0;
	}
	
	public int getPontos() {
		return this.pontos;
	}
	
	public void addPeca(Peca peca) {
		Peca p = peca;
		this.conjunto.add(p);
	}
	
	public void addPeca(List<Peca> pecas) {
		this.conjunto = pecas;
	}
	
	public List<Peca> getPecas() {
		return this.conjunto;
	}
	
	public String toString() {
		return this.getNome();
	}
	
	public abstract void accept(JogadorVisitor visitor);
	
}
