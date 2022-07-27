package controle.visitor;

import modelo.tabuleiro.terreno.*;

public interface TerrenoVisitor {

	public void visitarAbismo(TerrenoAbismo abismo);
	
	public void visitarColina(TerrenoColina colina);
	
	public void visitarFloresta(TerrenoFloresta floresta);
	
	public void visitarGrama(TerrenoGrama grama);
	
	public void visitarMontanha(TerrenoMontanha montanha);
	
	public void visitarPantano(TerrenoPantano pantano);
	
	
}
