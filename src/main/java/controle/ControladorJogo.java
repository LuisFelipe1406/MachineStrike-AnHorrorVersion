package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controle.command.CommandInvoker;
import controle.command.MoverCommand;
import controle.observer.ObserverJogo;
import controle.visitor.JogadorPreparaPecasVisitor;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.ui.*;
import modelo.Jogador;
import modelo.pecas.*;
import modelo.tabuleiro.Tabuleiro;
import modelo.tabuleiro.terreno.Terreno;
import visao.TelaJogo;

public class ControladorJogo {

	private Jogo jogo;
	private TelaJogo telaJogo;
	private CommandInvoker ci;
	private TurnoEstado estado;
	private List<ObserverJogo> observadores; 
	
	public ControladorJogo() throws IOException {
		this.jogo = Jogo.getInstance();
		this.telaJogo = new TelaJogo();
		this.ci = new CommandInvoker();
		this.observadores = new ArrayList<ObserverJogo>();
		
		geraTabuleiro(this.jogo.getTabuleiro());
		geraPecas();
		
		iniciarTela();
		
		preparaPlayers();
		acoesBotoes();
		
		this.addObservador(telaJogo);
		this.estado = new TurnoMovP1(this);
	}
	
	public void addObservador(ObserverJogo obs) {
		this.observadores.add(obs);
	}
	
	public List<ObserverJogo> getObservadores() {
		return this.observadores;
	}
	
	public void iniciarTela() {
		Scene cena = new Scene(telaJogo.createContent());
		
		Stage stageJogo = new Stage();
		
		stageJogo.setTitle("Ataque das Máquinas | O Jogo");
		stageJogo.setScene(cena);
				
		stageJogo.show();
	}
	
	public void preparaPlayers() {
		this.telaJogo.getP1Nome().setText(this.jogo.getJogadores().get(0).getNome());
		
		this.telaJogo.getP2Nome().setText(this.jogo.getJogadores().get(1).getNome());
	}
	
	public void acoesBotoes() {
		this.telaJogo.setAcaoBtnPassarAVez(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				limparPecas();
				limparCasas();
				
				passarAVez();
			}
			
		});
		
		this.telaJogo.setAcaoBtnArrancada(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.telaJogo.setAcaoBtnp1ReverseMove(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				limparPecas();
				limparCasas();
				
				ci.undo();
			}
			
		});
	}
	
	public void geraTabuleiro(Tabuleiro tab) {
		//Inserir tabuleiro na tela
		for (int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				Terreno terreno = tab.getCasas()[x][y]; 
				UiCasa casa;
				casa = new UiCasa(terreno, x, y, this.telaJogo.getSize());
				
				//Adiciona casa na nossa lista para manipulacao futura
				this.jogo.addCasasJogo(casa, x, y);
				
				this.telaJogo.getGrupoCasa().getChildren().add(casa);
			}
		}
	}
	
	public void geraPecas() {
		JogadorPreparaPecasVisitor preparaPecas = new JogadorPreparaPecasVisitor();
		
		for (Jogador player : this.jogo.getJogadores()) {
			player.accept(preparaPecas);
			
			//Inserir pecas na tela 
			for (Peca p : player.getPecas()) {
				UiPeca uiPeca = new UiPeca(p, this.telaJogo.getSize());
				
				//Adiciona o no no grupo para exibir na tela
				this.telaJogo.getGrupoPeca().getChildren().add(uiPeca);
				
				//Adiciona o no na nossa lista para manipulacao futura
				this.jogo.addPersonagemJogo(uiPeca);
			}
		}		
		
	}
	
	public void limparPecas() {
		for (UiPeca uiPeca : this.jogo.getPersonagensJogo()) {			
			uiPeca.setEstado(new UiPecaNaoSelecionada(uiPeca));
		}
	}
	
	public void limparCasas() {
		for (UiCasa[] uiCasas : this.jogo.getCasasJogo()) {
			for (UiCasa uiCasa : uiCasas) {
				uiCasa.setEstado(new UiCasaNaoSelecionada(uiCasa));
			}
		}
	}
	
	public UiPeca getPecaSelecionada() {
		for (UiPeca uiPeca : this.jogo.getPersonagensJogo()) {			
			if (uiPeca.getEstado().getClass() == UiPecaSelecionada.class) {
				return uiPeca;
			}
		}
		
		return null;
	}
	
	public boolean temPecaAqui(UiCasa casa) {
		for (UiPeca uiPeca : this.jogo.getPersonagensJogo()) {			
			if (uiPeca.getPeca().getPosicao()[0] == casa.getPosicao()[0] && uiPeca.getPeca().getPosicao()[1] == casa.getPosicao()[1]) {
				return true;
			}
		}
		
		return false;
	}
	
	public void setEstado(TurnoEstado estado) {
		this.estado = estado;
	}
	
	public TurnoEstado getEstado() {
		return this.estado;
	}
	
	public void proxEstado() {
		this.estado.proxEstado();
		
		System.out.println(this.estado);
	}
	
	public void passarAVez() {
		this.proxEstado();
	}
	
	public void setContMov(int cont) {
		this.jogo.setContMov(cont);
	}
	
	public int getContMov() {
		return jogo.getContMov();
	}
	
	public void resetContMov() {
		this.jogo.setContMov(0);
	}
	
	public Jogo getJogo() {
		return this.jogo;
	}
	
	public CommandInvoker getCi() {
		return this.ci;
	}
	
}
