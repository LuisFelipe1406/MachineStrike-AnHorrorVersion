package modelo.pecas;

import java.io.File;

import controle.visitor.PecaVisitor;
import javafx.scene.image.Image;
import modelo.tipos.TipoAtirador;

public class PecaCoringa extends Peca {

	public PecaCoringa(int x, int y) {
		super("Coringa", new TipoAtirador(), 3, 2, 5, 3, 5, new int[]{x, y});
	}
	
	@Override
	public void accept(PecaVisitor visitor) {
		visitor.visitarCoringa(this);
	}
	
}
