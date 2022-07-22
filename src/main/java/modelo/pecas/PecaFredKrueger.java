package modelo.pecas;

import java.io.File;

import controle.visitor.PecaVisitor;
import javafx.scene.image.Image;
import modelo.tipos.TipoCorpo;

public class PecaFredKrueger extends Peca {

	public PecaFredKrueger(int x, int y) {
		super("Fred Krueger", new TipoCorpo(), 1, 2, 2, 4, 3, new int[]{x, y});
	}
	
	@Override
	public void accept(PecaVisitor visitor) {
		visitor.visitarFredKrueger(this);
	}
	
}
