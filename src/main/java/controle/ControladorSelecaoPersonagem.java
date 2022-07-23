package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controle.observer.*;
import controle.visitor.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import visao.*;
import modelo.*;
import modelo.pecas.*;
import modelo.ui.*;
import modelo.ui.decorator.UiPecaMoldura;
import modelo.ui.decorator.UiPecaBase;

public class ControladorSelecaoPersonagem {

	private Jogo jogo;
	private TelaSelecaoPersonagens telaSelecao;
	private Stage stageSelecao;
	private List<ObserverSelecaoPersonagens> observadores;
	
	public ControladorSelecaoPersonagem() {
		this.jogo = Jogo.getInstance();
		this.telaSelecao = new TelaSelecaoPersonagens();
		this.observadores = new ArrayList<ObserverSelecaoPersonagens>();
		
		this.addObservador(this.telaSelecao);
		
		gerarGridPersonagens();
		iniciarTela();
		acoesBotoes();		
		
		for (ObserverSelecaoPersonagens obs : this.observadores) {
			obs.atualizaEscolha(this.escolhasRestantes());
			obs.selecaoP1();
			obs.exibirAlerta(this.gerarAlerta("Player 1, indique seu nome e escolha seus personagens."));
		}
	}
	
	public void addObservador(ObserverSelecaoPersonagens obs) {
		this.observadores.add(obs);
	}
	
	public void iniciarTela() {
		Scene cena = new Scene(telaSelecao.createContent());
		
		this.stageSelecao = new Stage();
		this.stageSelecao.setTitle("Ataque das Máquinas | Seleção de Personagens");
		this.stageSelecao.setScene(cena);
		this.stageSelecao.show();
	}
	
	public void gerarGridPersonagens() {
		GridPane gridPersonagens = new GridPane();
		
		int coluna = 0;
		int linha = 0;
		int marginBottom = 5;
		
		for (int i = 0; i < gerarPersonagens().size(); i++) {
			Peca personagem = gerarPersonagens().get(i);
			UiPecaBase uiSelecao = new UiPecaMoldura(personagem, this.telaSelecao.getSize(), new UiPeca(personagem, this.telaSelecao.getSize()));
			
			//Adiciona o nó a lista de personagens
			this.jogo.addPersonagemSelecao(uiSelecao);
			
			uiSelecao.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {					
					uiSelecao.atualizarImg();
					
					for (ObserverSelecaoPersonagens obs : observadores) {
						obs.gerarGrid(gridPersonagens);
						obs.atualizaEscolha(escolhasRestantes());
					}
				}
					
			});
			
			//Adiciona o nó ao grid
			if (coluna == 5) {
				coluna = 0;
				linha = 1;
				
				marginBottom = 0;
			}
			
			gridPersonagens.add(uiSelecao, coluna, linha, 1, 1);
			gridPersonagens.setMargin(uiSelecao, new Insets(0, 15, marginBottom, 15));
			
			coluna++;
		}
				
		for (ObserverSelecaoPersonagens obs : observadores) {
			obs.gerarGrid(gridPersonagens);
		}
	}
	
	public void acoesBotoes() {
		this.telaSelecao.setAcaoBtnPlayer1(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				if (escolhasRestantes() >= 0) {
					Jogador player1 = new Jogador1(telaSelecao.getNomeP1());
					player1.addPeca(getPecasSelecionadas());
					
					jogo.addJogador(player1);
					limparSelecao();
					
					for (ObserverSelecaoPersonagens obs : observadores) {
						obs.exibirAlerta(gerarAlerta("Player 2, indique seu nome e escolha seus personagens."));
						obs.selecaoP2();
						obs.atualizaEscolha(escolhasRestantes());
					}
				}
			}
		});
		
		this.telaSelecao.setAcaoBtnPlayer2(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				if (escolhasRestantes() >= 0) {
					Jogador player2 = new Jogador2(telaSelecao.getNomeP2());
					player2.addPeca(getPecasSelecionadas()); 			
					
					jogo.addJogador(player2);
					limparSelecao();
					
					for (ObserverSelecaoPersonagens obs : observadores) {
						obs.exibirAlerta(gerarAlerta("Hora do Jogo!"));
						obs.selecaoTerminou();
					}
				}				
			}
			
		});
		
		this.telaSelecao.setAcaobtnPlay(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				try {
					ControladorJogo controladorJogo = new ControladorJogo();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private List<Peca> gerarPersonagens() {
		List<Peca> geradas = new ArrayList<>();
		
		Peca chucky = new PecaChucky(0, 0);		
		Peca coringa = new PecaCoringa(0, 0);
		Peca fredKrueger = new PecaFredKrueger(0, 0);
		Peca hallowen = new PecaHallowen(0, 0);
		Peca jason = new PecaJason(0, 0);
		Peca jigsaw = new PecaJigsaw(0, 0);		
		Peca michaelJackson = new PecaMichaelJackson(0, 0);
		Peca michaelMyers = new PecaMichaelMyers(0, 0);
		Peca pennywise = new PecaPennywise(0, 0);
		Peca serraEletrica = new PecaSerraEletrica(0, 0);
				
		geradas.add(chucky);
		geradas.add(coringa);
		geradas.add(fredKrueger);
		geradas.add(hallowen);
		geradas.add(jason);
		geradas.add(jigsaw);
		geradas.add(michaelJackson);
		geradas.add(michaelMyers);
		geradas.add(pennywise);
		geradas.add(serraEletrica);
		
		return geradas;
	}
	
	public List<Peca> getPecasSelecionadas() {
		PecasGetSelecionadasVisitor pecaTodasVisitor = new PecasGetSelecionadasVisitor();
		
		for (UiPecaBase sel : this.jogo.getPersonagensSelecao()) {
			Peca peca = sel.getPeca();
			
			peca.accept(pecaTodasVisitor);
		}
		
		return pecaTodasVisitor.getPecas();
	}
	
	public int escolhasRestantes() {
		int selecionados = this.getPecasSelecionadas().size();
		
		int restantes = this.jogo.getPecasPorJogador() - selecionados;
		
		if (restantes < 0) {
			for (ObserverSelecaoPersonagens obs : observadores) {
				obs.exibirAlerta(gerarAlerta("Número de peças maior que o permitido"));
			}
		}
		
		return restantes;
	}
	
	public void limparSelecao() {
		for (UiPecaBase sel : this.jogo.getPersonagensSelecao()) {
			Peca peca = sel.getPeca();
			
			peca.setEstado(new PecaEstadoNaoSelecionada(peca));
			
			sel.setarImagem(peca.getImage());
		}
	}
	
	
	private Alert gerarAlerta(String texto) {
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Instrução");
        dialogoInfo.setContentText(texto);
        
        return dialogoInfo;
	}
	
}
