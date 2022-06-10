package mainApp.controller;

import java.util.HashSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class mainController {
	
	
	@FXML private Button BTRandomizar, BTSalir;
	@FXML private TextArea TAParticipantes;
	@FXML private TextField TFNParticipantes;
	@FXML private ListView <String> LVGanadores;
	
	private ObservableList<String> obsGanadores = FXCollections.observableArrayList();
	
	private HashSet<String> hashSetParticipantes = new HashSet<>();
	
	@FXML
	private void salir(ActionEvent evento) {
		((Stage) BTSalir.getScene().getWindow()).close();
	}
	
	public ObservableList<String> getParticipantes() {
		
		String [] participantes = TAParticipantes.getText().split("\\R");
		
		
		obsGanadores = FXCollections.observableArrayList(participantes);
		
		return obsGanadores;
	}
	
	
	
	private void getGanadores() {
		
	}
	
	@FXML public void setResultado() {
		
		LVGanadores.setItems(getParticipantes());
	}
	
	private Integer getNumParticipantes() {
		int num = 0;
		
		try {
			
		 num = Integer.parseInt(TAParticipantes.getText());
		 
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
}
