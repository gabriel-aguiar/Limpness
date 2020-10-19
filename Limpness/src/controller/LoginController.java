package controller;

import java.awt.Button;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
	    public void Login(ActionEvent event) {
          if (txfUsuario.getText().equals("Limpness") && txfSenha.getText().equals("1234")) {
        	  Stage stage = new Stage();
        	  
        	  try {
        			AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/ViewLogin/PRINCILPAL.fxml"));
        			Scene sc = new Scene(pane);
        			stage.setScene(sc);
        			stage.show();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        	 
        	  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        	  alert.setTitle("teste blabla");
        	  alert.setHeaderText("Bem vindo ao Limpness");
        	  alert.show();
        	  
        	  
          }else {
        	  Alert alert = new Alert(Alert.AlertType.ERROR);
        	  alert.setTitle("teste blabla");
        	  alert.setHeaderText("Senha ou Email esta incorreto.");
        	  alert.show();
          }
	    }

	    @FXML
	    void sair(ActionEvent event) {
              System.exit(0);
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
