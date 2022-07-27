package controle.factory;

import java.util.HashMap;
import java.util.Map;

import modelo.tabuleiro.Tabuleiro;
import modelo.tabuleiro.TabuleiroRandom;
import modelo.tabuleiro.terreno.Terreno;
import modelo.tabuleiro.terreno.TerrenoAbismo;
import modelo.tabuleiro.terreno.TerrenoColina;
import modelo.tabuleiro.terreno.TerrenoFloresta;
import modelo.tabuleiro.terreno.TerrenoGrama;
import modelo.tabuleiro.terreno.TerrenoMontanha;
import modelo.tabuleiro.terreno.TerrenoPantano;

public class TabuleiroRandomFactory implements AbstractTabuleiroFactory {

	private Tabuleiro tabuleiro;
	private Map<Integer, Terreno> guiaTerrenos;           //Map para relacionar as letras do arquivo com cada terreno (alternativa para um grande switch)
	
	public TabuleiroRandomFactory() {
		terrenosPadroes();
		construirTabuleiro();
	}
	
	@Override
	public void construirTabuleiro() {
		Terreno[][] casas = new Terreno[8][8];
		
		//Criando terrenos de maneira randômica
		//Percorrendo cada linha
		for (int i = 0; i < 8; i++) {
			//Percorrendo cada coluna
			for(int n = 0; n < 8; n++) {
				casas[i][n] = terrenoRandom();
			}
		}
		
		this.tabuleiro = new TabuleiroRandom(casas);		
	}
	
	private Terreno terrenoRandom() {
		int numero = (int)(Math.random() * (6 - 1) + 1);
		
		return this.guiaTerrenos.get(numero);
	}
	
	public void terrenosPadroes() {
		this.guiaTerrenos = new HashMap();
		
		this.guiaTerrenos.put(1, new TerrenoAbismo());
		this.guiaTerrenos.put(2, new TerrenoPantano());
		this.guiaTerrenos.put(3, new TerrenoGrama());
		this.guiaTerrenos.put(4, new TerrenoFloresta());
		this.guiaTerrenos.put(5, new TerrenoColina());
		this.guiaTerrenos.put(6, new TerrenoMontanha());
	}
	
	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}
}
