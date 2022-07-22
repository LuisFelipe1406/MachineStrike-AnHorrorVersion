package controle.visitor;

import modelo.Jogador1;
import modelo.Jogador2;

public interface JogadorVisitor {

	public void visitarJogador1(Jogador1 jog1);
	
	public void visitarJogador2(Jogador2 jog2);
	
}
