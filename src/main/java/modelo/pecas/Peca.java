package modelo.pecas;

import java.io.File;

import controle.visitor.PecaVisitor;
import javafx.scene.image.Image;
import modelo.tipos.TipoPeca;

public abstract class Peca {

	private String nome;                //Nome da peça
	private TipoPeca tipo;              //Tipo da peça
	private int vida;                   //Vida da peça
	private int valor;                  //Pontos obtidos ao matar essa peça
	private int movimento;              //Qtd de movimento da peça
	private int ataque;                 //Ataque da peça
	private int bonus;                  //Bônus que a peça tem dependendo do terreno
	private int alcance;                //Alcance do dano da peça
	private int[] posicao;              //Posição da peça   
	private boolean movimentoLiberado;  //Propriedade que representa movimento da peça [TROCAR POR STATE]
	private Image img;                  //Imagem da peça
	private Image imgBW;                //Imagem da peça em preto e branco
	
	private PecaEstado estado;
	
	public Peca(String nome, TipoPeca tipo, int vida, int valor, int movimento, int ataque, int alcance,
			    int[] posicao) {
		this.nome = nome;
		this.tipo = tipo;
		this.vida = vida;
		this.valor = valor;
		this.movimento = movimento;
		this.ataque = ataque;
		this.bonus = 0;
		this.alcance = alcance;
		this.posicao = posicao;

		this.estado = new PecaEstadoNaoSelecionada(this);
		
		this.movimentoLiberado = true;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setTipo(TipoPeca tipo) {
		this.tipo = tipo;
	}
	
	public TipoPeca getTipo() {
		return this.tipo;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void setMovimento(int movimento) {
		this.movimento = movimento;
	}
	
	public int getMovimento() {
		return this.movimento;
	}
	
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	public int getAtaque() {
		return this.ataque;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return this.bonus;
	}
	
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}
	
	public int getAlcance() {
		return this.alcance;
	}
	
	public void setPosicao(int[] pos) {
		//Verificando se não vai além das bordas do tabuleiro 8x8
		if (pos[0] >= 0 && pos[0] < 8 && pos[1] >= 0 && pos[1] < 8) {
			//O movimento pode ser bloqueado por algumas condições do jogo
			if (this.getMovimentoLiberado()) {
				this.posicao = pos;
			} else {
				System.out.println("Movimento bloqueado.");
			}
		}
	}
	
	public int[] getPosicao() {
		return this.posicao;
	}
	
	public void setMovimentoLiberado(boolean bool) {
		this.movimentoLiberado = bool;
	}
	
	public boolean getMovimentoLiberado() {
		return this.movimentoLiberado;
	}
	
	public void setImage(Image img) {
		this.img = img;
	}
	
	public Image getImage() {
		return this.img;
	}
	
	
	public void setEstado(PecaEstado estado) {
		this.estado = estado;
	}
	
	public PecaEstado getEstado() {
		return this.estado;
	}
	
	public void trocarEstado() {
		this.estado.proxEstado();
	}
	
	public String toString() {
		return this.getTipo() + " - " + this.getNome();
	}
	
	public abstract void accept(PecaVisitor visitor);
	
}
