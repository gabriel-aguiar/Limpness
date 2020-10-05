package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalController {

	public void linkfuncionario(ActionEvent event) throws Exception {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(FuncionarioController.class.getResource("ViewFuncionario.fxml"));
			Parent root1 = fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void linkequipamento(ActionEvent event) throws Exception {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(EquipamentoController.class.getResource("ViewEquipamento.fxml"));
			Parent root1 = fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void linkclientej(ActionEvent event) throws Exception {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(Cliente_JuridicoController.class.getResource("ViewClientesJuridicos.fxml"));
			Parent root1 = fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
