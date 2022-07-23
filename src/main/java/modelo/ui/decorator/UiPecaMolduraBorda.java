package modelo.ui.decorator;

import java.io.File;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.pecas.Peca;
import modelo.pecas.PecaEstadoSelecionada;

public class UiPecaMolduraBorda extends UiPecaDecorator {

	public UiPecaMolduraBorda(Peca peca, int telaSize, UiPecaBase pecaBase) {
		super(peca, telaSize, pecaBase);
		
		atualizarImg();
		criarMoldura();
	}

	@Override
	public void atualizarImg() {		
		getPeca().setEstado(new PecaEstadoSelecionada(peca));;
		
		setarImagem(new Image(new File("recursos/imagens/personagens/"+ peca.getNome() +".png").toURI().toString()));
	}
	
	public void criarMoldura() {
		ImageView moldura = new ImageView(new Image(new File("recursos/imagens/personagens/Moldura.png").toURI().toString()));
		moldura.setFitHeight(this.telaSize);
		moldura.setFitWidth(this.telaSize);
		moldura.setStyle("-fx-border-color: gray;" +
                         "-fx-border-width: 1px 1px 1px 1px;" +
                         "-fx-border-style: solid;");
		
		Label vida = new Label(String.valueOf(peca.getVida()));
		vida.setStyle("-fx-font: 20 calibri;" +
				      "-fx-font-weight: bold;" +
				      "-fx-fill: black;" +
		              "-fx-padding: 0 0 0 6px;");
		
		Label ataque = new Label(String.valueOf(peca.getAtaque()));
		ataque.setStyle("-fx-font: 20 calibri;" +
			      "-fx-font-weight: bold;" +
			      "-fx-fill: black;" +
	              "-fx-padding: 0 0 0 64px;");
		
		Label valor = new Label(String.valueOf(peca.getValor()));
		valor.setStyle("-fx-font: 20 calibri;" +
			      "-fx-font-weight: bold;" +
			      "-fx-fill: black;" +
	              "-fx-padding: 56px 0 0 6px;");
		
		super.getChildren().add(moldura);
		super.getChildren().addAll(new Label[] {vida, ataque, valor});
	}
	
}
