package modelo.pecas;

import java.io.File;

import controle.visitor.PecaVisitor;
import javafx.scene.image.Image;
import modelo.tipos.TipoCorredor;
import modelo.tipos.TipoPeca;

public class PecaMichaelJackson extends Peca {
	
	public PecaMichaelJackson(int x, int y) {
		super("Michael Jackson", new TipoCorredor(), 2, 2, 4, 3, 3, new int[]{x, y});
	}

	@Override
	public void accept(PecaVisitor visitor) {
		visitor.visitarMichaelJackson(this);
	}
	
}
