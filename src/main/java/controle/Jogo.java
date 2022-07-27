package controle;

import java.util.ArrayList;
import java.util.List;

import modelo.*;
import modelo.ui.*;
import modelo.ui.decorator.UiPecaBase;
import modelo.tabuleiro.Tabuleiro;

public class Jogo {

	//Singleton guardando os dados importantes para o jogo
	
	private static Jogo instance;                                                                            //Instância do Singleton
	private static int pecasPorJogador = 7;                                                                  //Limite de pecas por jogador
	private static List<UiPecaBase> personagensSelecao = new ArrayList<UiPecaBase>();                        //Personagens na tela de seleção
	private static List<UiSelecaoTabuleiro> tabuleirosSelecao = new ArrayList<UiSelecaoTabuleiro>();         //Personagens na tela de seleção
	private static List<UiPeca> personagensJogo = new ArrayList<UiPeca>();                                   //Personagens na tela do jogo
	private static UiCasa[][] casasJogo = new UiCasa[8][8];                                                  //Casas na tela do jogo
	private static Tabuleiro tabuleiro;                                                                      //Tabuleiro do jogo 
	private static List<Jogador> jogadores = new ArrayList<Jogador>();                                       //Lista de jogadores
	private static int contMovimento = 0;
	
	private Jogo() { }
	
	public synchronized static Jogo getInstance() {
		if (instance == null) {
			instance = new Jogo();
		}
		
		return instance;
	}
			
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}
	
	public void addJogador(Jogador jogador) {
		this.jogadores.add(jogador);
	}
	
	public List<Jogador> getJogadores() {
		return this.jogadores;
	}
	
	public void addPersonagemSelecao(UiPecaBase personagem) {
		this.personagensSelecao.add(personagem);
	}
	
	public List<UiPecaBase> getPersonagensSelecao() {
		return this.personagensSelecao;
	}
	
	public void addTabuleiro(UiSelecaoTabuleiro tabuleiro) {
		this.tabuleirosSelecao.add(tabuleiro);
	}
	
	public List<UiSelecaoTabuleiro> getTabuleiros() {
		return this.tabuleirosSelecao;
	}
	
	public void addPersonagemJogo(UiPeca personagem) {
		this.personagensJogo.add(personagem);
	}
	
	public List<UiPeca> getPersonagensJogo() {
		return this.personagensJogo;
	}
	
	public void addCasasJogo(UiCasa casa, int x, int y) {
		this.casasJogo[x][y] = casa;
	}
	
	public UiCasa[][] getCasasJogo() {
		return this.casasJogo;
	}
	
	public int getPecasPorJogador() {
		return this.pecasPorJogador;
	}
	
	public void setContMov(int cont) {
		this.contMovimento = cont;
	}
	
	public int getContMov() {
		return this.contMovimento;
	}
	
}
