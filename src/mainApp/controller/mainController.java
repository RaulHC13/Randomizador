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
import resources.Dialogos;

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
		
		List<String> resultado = null;
		
		ArrayList<String> participantesLista = new ArrayList<>(getParticipantes());
		
		Collections.shuffle(participantesLista);
		
		try {
			
			resultado = participantesLista.subList(0, getNumGanadores());
			obsGanadores = FXCollections.observableArrayList(resultado);
		} catch (Exception e) {
			Dialogos.mostrarDialogoAdvertencia("ERROR", "No puede haber más ganadores que participantes.");
			
		}
		
		return obsGanadores;
	}
	
	@FXML public void setResultado() {
		
		LVGanadores.setItems(getGanadores());
	}
	
	private Integer getNumGanadores() {
		
		int num = 0;
		try {
			
		 num = Integer.parseInt(TFNParticipantes.getText().trim());
		 
		} catch (NumberFormatException e) {
			Dialogos.mostrarDialogoAdvertencia("ERROR", "No se ha introducido un número válido");
		}
		return num;
	}
}