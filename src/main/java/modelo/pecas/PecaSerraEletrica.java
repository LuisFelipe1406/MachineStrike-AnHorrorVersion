package modelo.pecas;

import java.io.File;

import controle.visitor.PecaVisitor;
import javafx.scene.image.Image;
import modelo.tipos.TipoCorredor;

public class PecaSerraEletrica extends Peca {

	public PecaSerraEletrica(int x, int y) {
		super("Serra Eletrica", new TipoCorredor(), 3, 2, 4, 4, 2, new int[]{x, y});
	}

	@Override
	public void accept(PecaVisitor visitor) {
		visitor.visitarSerraEletrica(this);
	}
	
}
