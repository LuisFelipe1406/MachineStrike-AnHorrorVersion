package controle.adapter;

import java.io.IOException;

import modelo.tabuleiro.terreno.Terreno;

public interface LeitorArquivoTerreno {

	public Terreno[][] gerarCasas(String arquivo) throws IOException;
	
	public void terrenosPadroes();
	
	public Terreno verificarTerreno(String terreno);
	
}
