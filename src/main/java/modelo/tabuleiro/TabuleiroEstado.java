package modelo.tabuleiro;

public abstract class TabuleiroEstado {

	protected Tabuleiro tabuleiro;
	
	public TabuleiroEstado(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public abstract void proxEstado();
	
}
