package modelo.pecas;

import java.io.File;

import controle.visitor.PecaVisitor;
import javafx.scene.image.Image;
import modelo.tipos.TipoCorredor;

public class PecaJigsaw extends Peca {

	public PecaJigsaw(int x, int y) {
		super("Jigsaw", new TipoCorredor(), 1, 2, 3, 2, 4, new int[]{x, y});
	}
	
	@Override
	public void accept(PecaVisitor visitor) {
		visitor.visitarJigsaw(this);
	}
	
}
