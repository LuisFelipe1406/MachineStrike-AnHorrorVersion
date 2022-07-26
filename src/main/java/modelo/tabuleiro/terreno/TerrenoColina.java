package modelo.tabuleiro.terreno;

import java.io.File;

import controle.visitor.TerrenoVisitor;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import modelo.pecas.Peca;

public class TerrenoColina extends Terreno {

	public TerrenoColina() {
		super("Colina", new Image(new File("recursos/imagens/terrenos/Colina.jpg").toURI().toString()));
		
//		setCor(Color.GRAY);
	}
	
	//Ao estar na colina o jogador recebe +2 de ataque
	@Override
	public void accept(TerrenoVisitor visitor) {
		visitor.visitarColina(this);
	}
	
}
