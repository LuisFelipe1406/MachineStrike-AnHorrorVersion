package modelo.tabuleiro;

import modelo.tabuleiro.terreno.Terreno;
import modelo.tabuleiro.terreno.TerrenoGrama;

public class TabuleiroRandom extends Tabuleiro {

	public TabuleiroRandom(Terreno[][] casas) {
		super("Tabuleiro Aleatório", casas);
		
		manterCoerencia();
	}
	
	
	//Apesar da aleatoriedade, sempre teremos as primeiras linhas de cada player como terrenos neutros (grama)
	public void manterCoerencia() {
		for (int i = 0; i < 8; i++) {
			casas[i][0] = new TerrenoGrama();
			casas[i][7] = new TerrenoGrama();
		}
	}

}
