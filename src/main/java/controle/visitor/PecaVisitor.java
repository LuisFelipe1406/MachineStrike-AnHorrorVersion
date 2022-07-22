package controle.visitor;

import modelo.pecas.*;

public interface PecaVisitor {

	public void visitarChucky(PecaChucky chucky);
	
	public void visitarCoringa(PecaCoringa coringa);
	
	public void visitarFredKrueger(PecaFredKrueger fredKrueger);
	
	public void visitarHallowen(PecaHallowen hallowen);
	
	public void visitarJason(PecaJason jason);
	
	public void visitarJigsaw(PecaJigsaw jigsaw);
	
	public void visitarMichaelJackson(PecaMichaelJackson michaelJackson);
	
	public void visitarMichaelMyers(PecaMichaelMyers michaelMyers);
	
	public void visitarPennywise(PecaPennywise pennywise);
	
	public void visitarSerraEletrica(PecaSerraEletrica serraEletrica);	
	
}
