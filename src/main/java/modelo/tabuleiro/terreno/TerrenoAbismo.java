package modelo.tabuleiro.terreno;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import modelo.pecas.Peca;

public class TerrenoAbismo extends Terreno {
 
	public TerrenoAbismo() {
		super("Abismo", new Image(new File("recursos/imagens/terrenos/Abismo.jpg").toURI().toString()));
	
//		setCor(Color.RED);
	}

	//Abismo só pode receber peças voadoras e estas recebem -2 de ataque
	public void pecaAqui(Peca peca) {
		if (peca.getTipo().getNome() == "Voador") {
			peca.setBonus(-2);
		} else {
			System.out.println("Somente peças voadores podem vir aqui.");
		}
	}
	
}
