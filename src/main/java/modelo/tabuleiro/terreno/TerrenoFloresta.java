package modelo.tabuleiro.terreno;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import modelo.pecas.Peca;

public class TerrenoFloresta extends Terreno {

	public TerrenoFloresta() {
		super("Floresta", new Image(new File("recursos/imagens/terrenos/Floresta.jpg").toURI().toString()));
		
//		setCor(Color.DARKGREEN);
	}
	
	//Ao estar na floresta o jogador e recebe +1 de ataque
	@Override
	public void pecaAqui(Peca peca) {
		peca.setBonus(+1);
	}
	
}
