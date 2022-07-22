package modelo.pecas;

public abstract class PecaEstado {

	protected Peca peca;
	
	public PecaEstado(Peca peca) {
		this.peca = peca;
	}
	
	public abstract void proxEstado();
	
}
