package controle.visitor;

import java.io.File;

import javafx.scene.image.Image;
import modelo.Jogador1;
import modelo.Jogador2;
import modelo.pecas.Peca;

public class JogadorPreparaPecasVisitor implements JogadorVisitor {

	//Visitor responsavel por prepapar as pecas para ficarem no sentido e posicao corretas para cada jogador
	
	@Override
	public void visitarJogador1(Jogador1 jog1) {
		for (int i = 0; i < jog1.getPecas().size(); i++) {
			Peca p = jog1.getPecas().get(i);
						
			p.setImage(new Image(new File("recursos/imagens/personagens/"+p.getNome()+".png").toURI().toString()));
			p.setPosicao(new int[] {(i + 1), 7});
		}
	}

	@Override
	public void visitarJogador2(Jogador2 jog2) {
		for (int i = 0; i < jog2.getPecas().size(); i++) {
			Peca p = jog2.getPecas().get(i);
						
			p.setImage(new Image(new File("recursos/imagens/personagens/"+p.getNome()+"Invertido.png").toURI().toString()));
			p.setPosicao(new int[] {(i + 1), 0});
		}
	}

}
