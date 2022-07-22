package modelo;

import controle.visitor.JogadorVisitor;

public class Jogador2 extends Jogador {

	public Jogador2(String nome) {
		super(nome);
	}

	@Override
	public void accept(JogadorVisitor visitor) {
		visitor.visitarJogador2(this);
	}
	
	

}
