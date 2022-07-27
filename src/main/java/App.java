import java.io.IOException;

import controle.ControladorInicio;
import controle.ControladorSelecaoPersonagem;
import controle.Jogo;
import controle.factory.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
		
	public static void main (String[] args) {
		launch(args);		
	}

	@Override
	public void start(Stage inicial) throws IOException  {	
		ControladorInicio controleInicio = new ControladorInicio(inicial);
	}
	
}
