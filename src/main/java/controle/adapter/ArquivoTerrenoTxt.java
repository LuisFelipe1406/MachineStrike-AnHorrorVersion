package controle.adapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import modelo.tabuleiro.terreno.Terreno;
import modelo.tabuleiro.terreno.TerrenoAbismo;
import modelo.tabuleiro.terreno.TerrenoColina;
import modelo.tabuleiro.terreno.TerrenoFloresta;
import modelo.tabuleiro.terreno.TerrenoGrama;
import modelo.tabuleiro.terreno.TerrenoMontanha;
import modelo.tabuleiro.terreno.TerrenoPantano;

public class ArquivoTerrenoTxt implements LeitorArquivoTerreno {
	
	private Map<String, Terreno> guiaTerrenos;           //Map para relacionar as letras do arquivo com cada terreno (alternativa para um grande switch)
	
	public ArquivoTerrenoTxt() {
		terrenosPadroes();
	}

	@Override
	public Terreno[][] gerarCasas(String arquivo) throws IOException {
		//Buscamos o arquivo no caminhos selecionado
		File file = new File(arquivo);
		String dados = new String(Files.readAllBytes(file.toPath()));
		
		Terreno[][] casas = new Terreno[8][8];
		
		//Percorrendo cada linha
		for (int i = 0; i < dados.split("\\r?\\n").length; i++) {
			String linha = dados.split("\\r?\\n")[i];
			
			//Percorrendo cada coluna
			for(int n = 0; n < linha.split("  ").length; n++) {
				String coluna = linha.split("  ")[n];
				
				casas[i][n] = verificarTerreno(coluna);
			}
		}
		
		return casas;
	}

	@Override
	public void terrenosPadroes() {
		this.guiaTerrenos = new HashMap();
		
		this.guiaTerrenos.put("A", new TerrenoAbismo());
		this.guiaTerrenos.put("P", new TerrenoPantano());
		this.guiaTerrenos.put("G", new TerrenoGrama());
		this.guiaTerrenos.put("F", new TerrenoFloresta());
		this.guiaTerrenos.put("C", new TerrenoColina());
		this.guiaTerrenos.put("M", new TerrenoMontanha());
	}
	
	@Override
	public Terreno verificarTerreno(String terreno) {
		return this.guiaTerrenos.get(terreno);
	}

}
