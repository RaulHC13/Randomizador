package mainApp;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import resources.LocalizadorRecursos;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(LocalizadorRecursos.class.getResource("view/mainView.fxml"));
			AnchorPane root = loader.load();
			
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(LocalizadorRecursos.class.getResource("css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Randomizador");
			primaryStage.getIcons().add(new Image(LocalizadorRecursos.class.getResourceAsStream("images/dice.png")));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}