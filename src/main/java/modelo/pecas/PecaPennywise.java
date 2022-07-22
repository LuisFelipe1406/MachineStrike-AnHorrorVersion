package modelo.pecas;

import java.io.File;

import controle.visitor.PecaVisitor;
import javafx.scene.image.Image;
import modelo.tipos.TipoAtirador;
import modelo.tipos.TipoCorredor;
import modelo.tipos.TipoVoador;

public class PecaPennywise extends Peca {

	public PecaPennywise(int x, int y) {
		super("Pennywise", new TipoVoador(), 2, 1, 2, 3, 4, new int[]{x, y});
	}
	
	@Override
	public void accept(PecaVisitor visitor) {
		visitor.visitarPennywise(this);
	}
	
}
