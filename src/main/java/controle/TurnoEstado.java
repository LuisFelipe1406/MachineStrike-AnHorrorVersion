package controle;

public abstract class TurnoEstado {
	
	protected ControladorJogo jogo;
	
	public TurnoEstado(ControladorJogo jogo) {
		this.jogo = jogo;
	}
	
	public abstract void proxEstado();
	
	public abstract void pularAVez();

}
