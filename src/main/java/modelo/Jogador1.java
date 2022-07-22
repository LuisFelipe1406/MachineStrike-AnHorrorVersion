package modelo;

import controle.visitor.JogadorVisitor;

public class Jogador1 extends Jogador {

	public Jogador1(String nome) {
		super(nome);
	}

	@Override
	public void accept(JogadorVisitor visitor) {
		visitor.visitarJogador1(this);
	}

}
