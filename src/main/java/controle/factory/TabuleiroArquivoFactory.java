package controle.factory;

import java.io.IOException;

import controle.adapter.ArquivoTerrenoConf;
import controle.adapter.ArquivoTerrenoJson;
import controle.adapter.ArquivoTerrenoTxt;
import controle.adapter.LeitorArquivoTerreno;
import modelo.tabuleiro.Tabuleiro;
import modelo.tabuleiro.TabuleiroArquivo;
import modelo.tabuleiro.terreno.Terreno;

public class TabuleiroArquivoFactory implements AbstractTabuleiroFactory {

	private Tabuleiro tabuleiro;
	private String terreno;
	private LeitorArquivoTerreno arquivoTerrenos;               //Adapter para ler diferentes tipos de arquivo
	
	public TabuleiroArquivoFactory(String terreno) throws IOException {
		this.terreno = terreno;
		
		construirTabuleiro();
	}
	
	@Override
	public void construirTabuleiro() throws IOException {
		//O arquivo pode ser .TXT, .PROPERTIES ou .JSON
		if (this.terreno.contains("txt")) {
			this.arquivoTerrenos = new ArquivoTerrenoTxt();
		} else if (this.terreno.contains("properties")) {
			this.arquivoTerrenos = new ArquivoTerrenoConf();
		} else if (this.terreno.contains("json")) {
			this.arquivoTerrenos = new ArquivoTerrenoJson();
		}
		
		Terreno[][] casas = this.arquivoTerrenos.gerarCasas(terreno);
		
		this.tabuleiro = new TabuleiroArquivo(terreno.substring(20, 32), casas);
	}
	
	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}
	
}
