module Randomizador {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens mainApp to javafx.graphics, javafx.fxml;
	opens mainApp.controller to javafx.graphics, javafx.fxml; //Dependencia
}
