package controle.factory;

import java.io.IOException;

import modelo.tabuleiro.Tabuleiro;

public interface AbstractTabuleiroFactory {
	
	public abstract void construirTabuleiro() throws IOException;
	
	public abstract Tabuleiro getTabuleiro();

}
