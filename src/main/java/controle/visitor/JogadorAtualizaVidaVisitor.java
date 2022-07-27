package controle.visitor;

import java.io.File;

import controle.ControladorJogo;
import controle.TurnoFimDeJogo;
import controle.observer.ObserverJogo;
import javafx.scene.image.Image;
import modelo.Jogador;
import modelo.Jogador1;
import modelo.Jogador2;

public class JogadorAtualizaVidaVisitor implements JogadorVisitor {

	private ControladorJogo jogo;
	
	public JogadorAtualizaVidaVisitor(ControladorJogo jogo) {
		this.jogo = jogo;
	}
	
	@Override
	public void visitarJogador1(Jogador1 jog1) {
		Jogador player = this.jogo.getJogo().getJogadores().get(0);
		Image img = new Image(new File("recursos/imagens/vida/" + player.getPontos() + " vidas.png").toURI().toString());
		
		for (ObserverJogo obs : this.jogo.getObservadores()) {
			obs.atualizarVidaP1(img);
		}
		
		if (player.getPontos() == 0) {
			getGanhador(player);
		}
	}

	@Override
	public void visitarJogador2(Jogador2 jog2) {
		Jogador player = this.jogo.getJogo().getJogadores().get(1);
		Image img = new Image(new File("recursos/imagens/vida/" + player.getPontos() + " vidas.png").toURI().toString());
		
		for (ObserverJogo obs : this.jogo.getObservadores()) {
			obs.atualizarVidaP2(img);
		}
		
		if (player.getPontos() == 0) {
			getGanhador(player);
		}
	}

	public void getGanhador(Jogador zerado) {
		Jogador ganhador;
		
		if (zerado == this.jogo.getJogo().getJogadores().get(0)) {
		    ganhador = this.jogo.getJogo().getJogadores().get(1); 
		} else {
			ganhador = this.jogo.getJogo().getJogadores().get(0);
		}
		
		this.jogo.setEstado(new TurnoFimDeJogo(this.jogo));
		
		for (ObserverJogo obs : this.jogo.getObservadores()) {
			obs.fimDeJogo();				
		}
		
		this.jogo.gerarAlerta(ganhador.getNome() + " Ganhou!");
	}
	
	
}
