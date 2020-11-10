package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController extends Application implements Initializable{

    @FXML
    private TextField txfUsuario;

    @FXML
    private PasswordField txfSenha;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_sair;

	    @FXML
	    public void Login(ActionEvent event) {
          if (txfUsuario.getText().equals("Limpness") && txfSenha.getText().equals("1234")) {
        	  
        	  
        	  try {
        		  
					FXMLLoader fxmlLoader = new FXMLLoader(PrincipalController.class.getResource("..//central//PRINCILPAL.fxml"));
					Parent root1 = fxmlLoader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root1));
					stage.show();
					

				} catch (Exception e) {
					
					e.printStackTrace();
				}
        	 
        	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	  alert.setTitle("Bem vindo");
        	  alert.setHeaderText("Bem vindo ao Limpness");
        	  alert.show();
        	  
        	  
          }else {
        	  Alert alert = new Alert(Alert.AlertType.ERROR);
        	  alert.setTitle("Erro");
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
