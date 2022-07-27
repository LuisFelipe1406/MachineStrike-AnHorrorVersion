package modelo.tabuleiro.terreno;

import java.io.File;

import controle.visitor.TerrenoVisitor;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import modelo.pecas.Peca;

public class TerrenoAbismo extends Terreno {
 
	public TerrenoAbismo() {
		super("Abismo", new Image(new File("recursos/imagens/terrenos/Abismo.jpg").toURI().toString()));
	}

	//Abismo só pode receber peças voadoras e estas recebem -2 de ataque
	@Override
	public void accept(TerrenoVisitor visitor) {
		visitor.visitarAbismo(this);
	}

	
}
