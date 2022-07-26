package modelo.pecas;

import java.io.File;

import controle.visitor.PecaVisitor;
import javafx.scene.image.Image;
import modelo.tipos.TipoAtirador;

public class PecaHallowen extends Peca {
	
	public PecaHallowen(int x, int y) {
		super("Hallowen", new TipoAtirador(), 2, 1, 2, 3, 4, new int[]{x, y});
	}
	
	@Override
	public void accept(PecaVisitor visitor) {
		visitor.visitarHallowen(this);
	}

}
