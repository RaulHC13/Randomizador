package mainApp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
	
	@FXML
	private void salir(ActionEvent evento) {
		((Stage) BTSalir.getScene().getWindow()).close();
	}
	
	public HashSet<String> getParticipantes() {
		
		HashSet<String> hashSetParticipantes = new HashSet<>();	
		
		hashSetParticipantes.removeAll(hashSetParticipantes);
		
		String [] participantes = TAParticipantes.getText().split("\\R");
		
		for (String participante : participantes) {
			hashSetParticipantes.add(participante);
		}
		
		return hashSetParticipantes;
	}
	
	private ObservableList<String> getGanadores() {
		
		ArrayList<String> participantesLista = new ArrayList<>(getParticipantes());
		
		Collections.shuffle(participantesLista);
		
		List<String> resultado = participantesLista.subList(0, getNumParticipantes());
		
		obsGanadores = FXCollections.observableArrayList(resultado);
		
		return obsGanadores;
	}
	
	@FXML public void setResultado() {
		
		LVGanadores.setItems(getGanadores());
	}
	
	private Integer getNumParticipantes() {
		
		int num = 0;
		
		try {
			
		 num = Integer.parseInt(TFNParticipantes.getText());
		 
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return num;
	}
}