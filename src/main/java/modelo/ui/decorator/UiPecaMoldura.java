package modelo.ui.decorator;

import java.io.File;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.pecas.Peca;

public class UiPecaMoldura extends UiPecaDecorator {

	public UiPecaMoldura(Peca peca, int telaSize, UiPecaBase pecaBase) {
		super(peca, telaSize, pecaBase);
		
		criarMoldura();
	}

	@Override
	public void atualizarImg() {		
		getPeca().trocarEstado();
		
		setarImagem((getPeca().getImage()));
	}
	
	public void criarMoldura() {
		ImageView moldura = new ImageView(new Image(new File("recursos/imagens/personagens/Moldura.png").toURI().toString()));
		moldura.setFitHeight(this.telaSize);
		moldura.setFitWidth(this.telaSize);
		
		Label vida = new Label(String.valueOf(peca.getVida()));
		vida.setStyle("-fx-font: 20 calibri;" +
				      "-fx-font-weight: bold;" +
		              "-fx-text-fill: black;");
		
//		Label ataque = new Label(String.valueOf(peca.getAtaque()));
//		ataque.setStyle("-fx-font: 18 calibri");
//		
//		Label valor = new Label(String.valueOf(peca.getValor()));
//		valor.setStyle("-fx-font: 18 calibri");
		
		super.getChildren().add(moldura);
//		super.getChildren().addAll(new Label[] {vida, ataque, valor});
		super.getChildren().addAll(new Label[] {vida});
	}

}
