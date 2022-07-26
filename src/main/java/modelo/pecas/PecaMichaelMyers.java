package modelo.pecas;

import java.io.File;

import controle.visitor.PecaVisitor;
import javafx.scene.image.Image;
import modelo.tipos.TipoCorredor;

public class PecaMichaelMyers extends Peca {

	public PecaMichaelMyers(int x, int y) {
		super("Michael Myers", new TipoCorredor(), 3, 1, 2, 4, 5, new int[]{x, y});
	}

	@Override
	public void accept(PecaVisitor visitor) {
		visitor.visitarMichaelMyers(this);
	}
	
}
