package controle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controle.command.CommandInvoker;
import controle.observer.ObserverJogo;
import controle.visitor.JogadorAtualizaVidaVisitor;
import controle.visitor.JogadorPreparaPecasVisitor;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
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
		this.addObservador(telaJogo);
		
		preparaPlayers();
		acoesBotoes();
		
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
		Jogador p1 = this.jogo.getJogadores().get(0);
		Jogador p2 = this.jogo.getJogadores().get(1);
		
		this.telaJogo.getP1Nome().setText(p1.getNome());		
		this.telaJogo.getP2Nome().setText(p2.getNome());
		
		for (ObserverJogo obs : this.observadores) {
			obs.atualizarVidaP1(new Image(new File("recursos/imagens/vida/" + p1.getPontos() + " vidas.png").toURI().toString()));
			obs.atualizarVidaP2(new Image(new File("recursos/imagens/vida/" + p2.getPontos() + " vidas.png").toURI().toString()));
		}
	}
	
	public void acoesBotoes() {
		this.telaJogo.setAcaoBtnPassarAVezP1(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				limparPecas();
				limparCasas();
				
				setEstado(new TurnoMovP2(ControladorJogo.this));
			}
			
		});
		
		this.telaJogo.setAcaoBtnPassarAVezP2(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				limparPecas();
				limparCasas();
				
				setEstado(new TurnoMovP1(ControladorJogo.this));
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
	
	public boolean temPecaAquiP1(UiCasa casa) {
		Jogador j = this.jogo.getJogadores().get(0);

		for (Peca peca : j.getPecas()) {			
			if (peca.getPosicao()[0] == casa.getPosicao()[0] && peca.getPosicao()[1] == casa.getPosicao()[1]) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean temPecaAquiP2(UiCasa casa) {
		Jogador j = this.jogo.getJogadores().get(1);

		for (Peca peca : j.getPecas()) {			
			if (peca.getPosicao()[0] == casa.getPosicao()[0] && peca.getPosicao()[1] == casa.getPosicao()[1]) {
				return true;
			}
		}
		
		return false;
	}
	
	public void verificaMortos() {
		//Percorre os jogadores
		for (Jogador j : this.jogo.getJogadores()) {
			//Percorre as pecas
			for (UiPeca uiPeca : this.jogo.getPersonagensJogo()) {
				//Se a vida da peca for zero
				if (uiPeca.getPeca().getVida() <= 0) {
					this.telaJogo.getGrupoPeca().getChildren().remove(uiPeca);
					
					if (j.getPecas().contains(uiPeca.getPeca())) {
						j.removePonto();
						removerPecaJogo(j, uiPeca);
					}
				}
			}
			
			//Atualiza vida do jogador
			atualizarVida(j);
		}
	}
	
	public void removerPecaJogo(Jogador player, UiPeca remover) {
		//Tira a peca do jogador quando ele morrer
		for (int i = 0; i < player.getPecas().size(); i++) {
			Peca peca = player.getPecas().get(i);
			
			if (peca == remover.getPeca()) {
				player.getPecas().remove(i);
			}
		} 
	}
	
	public void atualizarVida(Jogador player) {
		JogadorAtualizaVidaVisitor atualizaVidaVisitor = new JogadorAtualizaVidaVisitor(this);
		
		player.accept(atualizaVidaVisitor);
	}
	
	public void setEstado(TurnoEstado estado) {
		this.estado = estado;
	}
	
	public TurnoEstado getEstado() {
		return this.estado;
	}
	
	public void proxEstado() {
		this.estado.proxEstado();
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
	
	public void gerarAlerta(String texto) {
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Instrução");
        dialogoInfo.setContentText(texto);
        
		for (ObserverJogo obs : this.getObservadores()) {
			obs.exibirAlerta(dialogoInfo);
		}
	}
	
}