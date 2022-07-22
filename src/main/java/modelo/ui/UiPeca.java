package modelo.ui;

import modelo.pecas.Peca;
import modelo.ui.decorator.UiPecaBase;

public class UiPeca extends UiPecaBase {

	private UiPecaEstado estado;                 //Estado para indicar qual o personagem selecionado para jogar
	
	public UiPeca(Peca peca, int telaSize) {
		super(peca, telaSize);
	
		this.estado = new UiPecaNaoSelecionada(this);
		
		atualizarPosicao();
	}
	
	public void atualizarImg() {		
		getPeca().trocarEstado();
		
		setarImagem((getPeca().getImage()));
	}
	
	public void atualizarPosicao() {
		relocate((peca.getPosicao()[0] * telaSize), (peca.getPosicao()[1] * telaSize));
	}
	
	public void setEstado(UiPecaEstado estado) {
		this.estado = estado;
	}
	
	public UiPecaEstado getEstado() {
		return this.estado;
	}
	
	public void trocarEstado() {
		this.estado.proxEstado();
	}
		
}
