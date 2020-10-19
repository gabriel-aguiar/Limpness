package controller;

import java.awt.Button;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController extends Application {

	 @FXML
	    private TextField txfUsuario;

	    @FXML
	    private PasswordField txfSenha;

	    @FXML
	    private Button btnLogin;

	    @FXML
	    private Button btnsair;

	    @FXML
	    void Login(ActionEvent event) {

	    }

	    @FXML
	    void sair(ActionEvent event) {

	    }
	
	public void execute() {
		launch();
	}

	

	public void start(Stage stage){
		 
		try {
	            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("ViewLogin.fxml"));
	            Scene sc = new Scene(pane);
	            stage.setScene(sc);
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }   
		
	}
	
}
