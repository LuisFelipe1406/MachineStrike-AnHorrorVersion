package controle.visitor;

import modelo.pecas.*;

import java.util.ArrayList;
import java.util.List;


public class PecasGetSelecionadasVisitor implements PecaVisitor {

	//Visitor responsavel por criar novos objetos de cada peca, de modo a evitar problemas de referencia
	
	private List<Peca> pecas;
	
	public PecasGetSelecionadasVisitor() {
		this.pecas = new ArrayList<Peca>();
	}
	
	@Override
	public void visitarChucky(PecaChucky chucky) {
		if(chucky.getEstado().getClass() == PecaEstadoSelecionada.class) {
			this.pecas.add(new PecaChucky(0,0));
		}
	}

	@Override
	public void visitarCoringa(PecaCoringa coringa) {
		if(coringa.getEstado().getClass() == PecaEstadoSelecionada.class) {
			this.pecas.add(new PecaCoringa(0,0));
		}
	}

	@Override
	public void visitarFredKrueger(PecaFredKrueger fredKrueger) {
		if(fredKrueger.getEstado().getClass() == PecaEstadoSelecionada.class) {
			this.pecas.add(new PecaFredKrueger(0,0));
		}
	}

	@Override
	public void visitarHallowen(PecaHallowen hallowen) {
		if(hallowen.getEstado().getClass() == PecaEstadoSelecionada.class) {
			this.pecas.add(new PecaHallowen(0,0));
		}
	}

	@Override
	public void visitarJason(PecaJason jason) {
		if(jason.getEstado().getClass() == PecaEstadoSelecionada.class) {
			this.pecas.add(new PecaJason(0,0));
		}
	}

	@Override
	public void visitarJigsaw(PecaJigsaw jigsaw) {
		if(jigsaw.getEstado().getClass() == PecaEstadoSelecionada.class) {
			this.pecas.add(new PecaJigsaw(0,0));
		}
	}

	@Override
	public void visitarMichaelJackson(PecaMichaelJackson michaelJackson) {
		if(michaelJackson.getEstado().getClass() == PecaEstadoSelecionada.class) {
			this.pecas.add(new PecaMichaelJackson(0,0));
		}
	}

	@Override
	public void visitarMichaelMyers(PecaMichaelMyers michaelMyers) {
		if(michaelMyers.getEstado().getClass() == PecaEstadoSelecionada.class) {
			this.pecas.add(new PecaMichaelMyers(0,0));
		}
	}

	@Override
	public void visitarPennywise(PecaPennywise pennywise) {
		if(pennywise.getEstado().getClass() == PecaEstadoSelecionada.class) {
			this.pecas.add(new PecaPennywise(0,0));
		}
	}

	@Override
	public void visitarSerraEletrica(PecaSerraEletrica serraEletrica) {
		if(serraEletrica.getEstado().getClass() == PecaEstadoSelecionada.class) {
			this.pecas.add(new PecaSerraEletrica(0,0));
		}
	}

	public List<Peca> getPecas() {
		return this.pecas;
	}
	
}
