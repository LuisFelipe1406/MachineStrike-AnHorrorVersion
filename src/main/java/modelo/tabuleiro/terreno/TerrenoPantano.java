package modelo.tabuleiro.terreno;

import java.io.File;

import controle.visitor.TerrenoVisitor;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import modelo.pecas.Peca;

public class TerrenoPantano extends Terreno {

	public TerrenoPantano() {
		super("Pântano", new Image(new File("recursos/imagens/terrenos/Pantano.jpg").toURI().toString()));
		
//		setCor(Color.BLUE);
	}
	
	//Ao estar no pântano o jogador perde seu movimento e recebe -1 de ataque
	@Override
	public void accept(TerrenoVisitor visitor) {
		visitor.visitarPantano(this);
	}
	
}
