package controller;

import java.io.IOException;
import java.util.List;

import dao.Cliente_FisicoDao;
import entidade.Cliente_Fisico;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Cliente_FisicoController extends Application{

	
	   @FXML
	    private Button btn_adicionar_cliente;

	    @FXML
	    private Button btn_pesquisar_cliente;

	    @FXML
	    private Button btn_excluir_cliente;

	    @FXML
	    private Button btn_alterar_cliente;

	    @FXML
	    private TextField tx_nome_cliente;

	    @FXML
	    private TextField tx_email_cliente;

	    @FXML
	    private TextField tx_telefone_cliente;

	    @FXML
	    private TextField tx_cpf_cliente;

	    @FXML
	    private TextField tx_cep_cliente;

	    @FXML
	    private Button btn_sair_cliente;
	    
	    @FXML
	    private TextArea ta_mostra_cf;
	
	    
	@FXML
    void inserirClientef(ActionEvent event) {
	
		Cliente_Fisico cliente_fisico = pegaDados();
    	limpaCampos();
    	int qtde = new Cliente_FisicoDao().inserir(cliente_fisico);
    	listaCliente_Fisico();
    	System.out.println(qtde);
	
    }
	
	private void limpaCampos() {
		tx_email_cliente.clear();
		tx_telefone_cliente.clear();
		tx_cpf_cliente.clear();
		tx_cep_cliente.clear();
		tx_nome_cliente.clear();
		tx_nome_cliente.requestFocus();
	}
	
    
    private void listaCliente_Fisico() {
    	ta_mostra_cf.clear();
		List<Cliente_Fisico> listaCliente_Fisico = new Cliente_FisicoDao().listAll();
		listaCliente_Fisico.forEach(cliente_fisico -> {
			ta_mostra_cf.appendText(cliente_fisico.toString() + "\n");
		});
	}
	
    private Cliente_Fisico pegaDados() {
		return new Cliente_Fisico(tx_nome_cliente.getText(), Integer.valueOf(tx_telefone_cliente.getText()), Integer.valueOf(tx_cpf_cliente.getText()), tx_email_cliente.getText(), tx_cep_cliente.getText());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void execute() {
		launch();
	}

	@Override
	public void start(Stage stage){
		 
		try {
	            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("ViewClientes.fxml"));
	            Scene sc = new Scene(pane);
	            stage.setScene(sc);
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }   
		
	}
	
}
