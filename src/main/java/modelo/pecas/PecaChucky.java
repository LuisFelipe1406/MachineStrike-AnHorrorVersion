package modelo.pecas;

import java.io.File;

import controle.visitor.PecaVisitor;
import javafx.scene.image.Image;
import modelo.tipos.TipoCorredor;

public class PecaChucky extends Peca {

	public PecaChucky(int x, int y) {
		super("Chucky", new TipoCorredor(), 1, 1, 3, 2, 3, new int[]{x, y});
	}
	
	@Override
	public void accept(PecaVisitor visitor) {
		visitor.visitarChucky(this);
	}
	
}
