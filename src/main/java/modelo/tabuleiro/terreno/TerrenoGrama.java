package modelo.tabuleiro.terreno;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import modelo.pecas.Peca;

public class TerrenoGrama extends Terreno {

	public TerrenoGrama() {
		super("Grama", new Image(new File("recursos/imagens/terrenos/Grama.jpg").toURI().toString()));

//		setCor(Color.GREEN);
	}

	//Ao estar na grama o jogador não é afetado
	@Override
	public void pecaAqui(Peca peca) {
		peca.setBonus(0);
	}
	
}
