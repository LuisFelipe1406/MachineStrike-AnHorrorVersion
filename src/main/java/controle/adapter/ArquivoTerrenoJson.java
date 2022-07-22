package controle.adapter;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.tabuleiro.terreno.Terreno;
import modelo.tabuleiro.terreno.TerrenoAbismo;
import modelo.tabuleiro.terreno.TerrenoColina;
import modelo.tabuleiro.terreno.TerrenoFloresta;
import modelo.tabuleiro.terreno.TerrenoGrama;
import modelo.tabuleiro.terreno.TerrenoMontanha;
import modelo.tabuleiro.terreno.TerrenoPantano;

public class ArquivoTerrenoJson implements LeitorArquivoTerreno {

	private Map<String, Terreno> guiaTerrenos;           //Map para relacionar as letras do arquivo com cada terreno (alternativa para um grande switch)
	
	public ArquivoTerrenoJson() {
		terrenosPadroes();
	}
	
	@Override
	public Terreno[][] gerarCasas(String arquivo) throws FileNotFoundException {
		//Buscamos o arquivo no caminhos selecionado
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		
		Gson gson = new Gson();
        List<List<String>> dados = gson.fromJson(br, ArrayList.class);
		
		Terreno[][] casas = new Terreno[8][8];
		
		
		//Percorrendo cada linha
		for (int i = 0; i < dados.size(); i++) {
			List<String> linha = dados.get(i);
			
			for (String s : linha) {
				System.out.println(s);
			}
			System.out.println("--------");

			//Percorrendo cada coluna
			for(int n = 0; n < linha.size(); n++) {
				String coluna = linha.get(n);
				
				casas[n][i] = verificarTerreno(coluna);
			}
		}
		
		return casas;
	}

	@Override
	public void terrenosPadroes() {
		this.guiaTerrenos = new HashMap();
		
		this.guiaTerrenos.put("abismo", new TerrenoAbismo());
		this.guiaTerrenos.put("pantano", new TerrenoPantano());
		this.guiaTerrenos.put("grama", new TerrenoGrama());
		this.guiaTerrenos.put("floresta", new TerrenoFloresta());
		this.guiaTerrenos.put("colina", new TerrenoColina());
		this.guiaTerrenos.put("montanha", new TerrenoMontanha());
	}
	
	@Override
	public Terreno verificarTerreno(String terreno) {
		return this.guiaTerrenos.get(terreno);
	}

}
