package controle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controle.factory.*;
import controle.observer.ObserverSelecaoTabuleiro;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.tabuleiro.Tabuleiro;
import modelo.tabuleiro.TabuleiroEstadoNaoSelecionado;
import modelo.ui.UiSelecaoTabuleiro;
import visao.TelaSelecaoTabuleiro;

public class ControladorSelecaoTabuleiro {

	private Jogo jogo;
	private TelaSelecaoTabuleiro telaSelecaoTabuleiro;
	private Stage stageSelecao;
	private List<ObserverSelecaoTabuleiro> observadores;
	private AbstractTabuleiroFactory tabuleiroFactory;
	
	public ControladorSelecaoTabuleiro() throws IOException {
		this.jogo = Jogo.getInstance();
		this.telaSelecaoTabuleiro = new TelaSelecaoTabuleiro();
		this.observadores = new ArrayList<ObserverSelecaoTabuleiro>();
		
		this.addObservador(this.telaSelecaoTabuleiro);
		
		for (ObserverSelecaoTabuleiro obs : observadores) {
			obs.gerarGrid(gerarGridTabuleiro());
			obs.gerarTabRandom(gerarTabRandom());
		}
		
		iniciarTela();
		setAcaoBotoes();
	}
	
	public void addObservador(ObserverSelecaoTabuleiro obs) {
		this.observadores.add(obs);
	}
	
	public void iniciarTela() {
		Scene cena = new Scene(telaSelecaoTabuleiro.createContent());
		
		this.stageSelecao = new Stage();
		this.stageSelecao.setTitle("Ataque das Máquinas | Seleção de Tabuleiro");
		this.stageSelecao.setScene(cena);		
		this.stageSelecao.show();
		
		for (ObserverSelecaoTabuleiro obs : observadores) {
			obs.exibirAlerta(this.gerarAlerta("Selecione um tabuleiro para o jogo."));
		}
	}
	
	public void setAcaoBotoes() {
		this.telaSelecaoTabuleiro.setAcaoBtnSelecao(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ControladorSelecaoPersonagem controladorSelecaoPersonagem = new ControladorSelecaoPersonagem();				
			}
		});
	}
	
	public GridPane gerarGridTabuleiro() throws IOException {
		GridPane gridTabuleiros = new GridPane();
		
		//Elenca arquivos dentro da pasta
		File file = new File("recursos/tabuleiros");
		
		int coluna = 0;
		
		for (File f : file.listFiles()) {
			this.tabuleiroFactory = new TabuleiroArquivoFactory(f.toString());
			
			//Cria o no
			Tabuleiro tab = this.tabuleiroFactory.getTabuleiro();
			UiSelecaoTabuleiro uiSelecao = new UiSelecaoTabuleiro(tab.getImage(), tab);
			
			//Adiciona o nó a lista de tabuleiros
			this.jogo.addTabuleiro(uiSelecao);
			
			uiSelecao.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					// Tira a selecao dos outros,e seleciona o atual 
					limparSelecao();
					
					uiSelecao.atualizarImg();
					
					//Esse sera o tabuleiro do jogo
					jogo.setTabuleiro(tab);
					
					for (ObserverSelecaoTabuleiro obs : observadores) {
						obs.indicarTabuleiro(tab.getNome());
						obs.TabuleiroEscolhido();
					}
				}
				
			});
			
			//Adiciona o no ao grid
			gridTabuleiros.add(uiSelecao, coluna, 0, 1, 1);
			gridTabuleiros.setMargin(uiSelecao, new Insets(0, 15, 0, 15));
			
			coluna++;
		}		
		
		return gridTabuleiros;
	}
	
	public UiSelecaoTabuleiro gerarTabRandom() {
		this.tabuleiroFactory = new TabuleiroRandomFactory();
		Tabuleiro tabRandom = this.tabuleiroFactory.getTabuleiro();
		
		UiSelecaoTabuleiro uiSelTabuleiro = new UiSelecaoTabuleiro(tabRandom.getImage(), tabRandom);
		
		//Adiciona o nó a lista de tabuleiros
		this.jogo.addTabuleiro(uiSelTabuleiro);
		
		uiSelTabuleiro.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// Tira a selecao dos outros,e seleciona o atual
				limparSelecao();
				
				uiSelTabuleiro.atualizarImg();

				//Esse sera o tabuleiro do jogo
				jogo.setTabuleiro(tabRandom);
				
				for (ObserverSelecaoTabuleiro obs : observadores) {
					obs.indicarTabuleiro(tabRandom.getNome());
					obs.TabuleiroEscolhido();
				}
			}
			
		});
		
		return uiSelTabuleiro;
	}
	
	public void limparSelecao() {
		for (UiSelecaoTabuleiro uiSel : this.jogo.getTabuleiros()) {
			uiSel.getTabuleiro().setEstado(new TabuleiroEstadoNaoSelecionado(uiSel.getTabuleiro()));
			uiSel.setImage(uiSel.getTabuleiro().getImage());
		}
		
	}
	
	private Alert gerarAlerta(String texto) {
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Instrução");
        dialogoInfo.setContentText(texto);
        
        return dialogoInfo;
	}
	
}
