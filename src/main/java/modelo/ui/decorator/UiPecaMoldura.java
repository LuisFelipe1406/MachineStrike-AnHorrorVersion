package modelo.ui.decorator;

import java.io.File;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.pecas.Peca;
import modelo.ui.decorator.builder.MolduraBuilder;

public class UiPecaMoldura extends UiPecaDecorator {

	private Peca peca;
	private int telaSize;
	private UiPecaBase pecaBase;
	
	public UiPecaMoldura(MolduraBuilder builder) {
		super(builder.peca, builder.telaSize, builder.pecaBase);
		
		this.peca = builder.peca;
		this.telaSize = builder.telaSize;
		this.pecaBase = builder.pecaBase;
		
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
				      "-fx-fill: black;" +
		              "-fx-padding: 0 0 0 6px;");
		
		Label ataque = new Label(String.valueOf(peca.getAtaque() + peca.getBonus()));
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
