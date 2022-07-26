package modelo.pecas;

import java.io.File;

import controle.visitor.PecaVisitor;
import javafx.scene.image.Image;
import modelo.tipos.TipoCorpo;
import modelo.tipos.TipoCorredor;

public class PecaJason extends Peca {

	public PecaJason(int x, int y) {
		super("Jason", new TipoCorpo(), 3, 1, 2, 4, 2, new int[]{x, y});
	}
	
	@Override
	public void accept(PecaVisitor visitor) {
		visitor.visitarJason(this);
	}
	
}
