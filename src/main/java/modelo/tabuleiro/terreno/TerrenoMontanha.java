package modelo.tabuleiro.terreno;

import java.io.File;

import controle.visitor.TerrenoVisitor;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import modelo.pecas.Peca;

public class TerrenoMontanha extends Terreno {

	public TerrenoMontanha() {
		super("Montanha", new Image(new File("recursos/imagens/terrenos/Montanha.jpg").toURI().toString()));

//		setCor(Color.WHITE);
	}

	//Ao estar na montanha o jogador recebe +3 de ataque
	@Override
	public void accept(TerrenoVisitor visitor) {
		visitor.visitarMontanha(this);
	}
	
}
