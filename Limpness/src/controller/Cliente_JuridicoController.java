package controller;

import java.io.IOException;
import java.util.List;

import dao.Cliente_JuridicoDao;
import entidade.Cliente_Juridico;
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

public class Cliente_JuridicoController extends Application{

	
    @FXML
    private Button btn_adicionar_cliente_j;

    @FXML
    private Button btn_pesquisar_cliente_j;

    @FXML
    private Button btn_excluir_cliente_j;

    @FXML
    private Button btn_alterar_cliente_j;

    @FXML
    private TextArea ta_mostra_cj;

    @FXML
    private TextField tx_id_cliente_j;

    @FXML
    private TextField tx_nome_cliente_j;

    @FXML
    private TextField tx_email_cliente_j;

    @FXML
    private TextField tx_telefone_cliente_j;

    @FXML
    private TextField tx_cnpj_cliente_j;

    @FXML
    private TextField tx_cep_cliente_j;

    @FXML
    private Button btn_sair_cliente_j;

    @FXML
    private TextField tx_categoria_cliente_j;
	
	@FXML
    void inserirClientej(ActionEvent event) {
	
		Cliente_Juridico cliente_juridico = pegaDados();
    	limpaCampos();
    	int qtde = new Cliente_JuridicoDao().inserir(cliente_juridico);
    	listaCliente_Juridico();
    	System.out.println(qtde);
	
    }
	
	private void limpaCampos() {
		tx_email_cliente_j.clear();
		tx_telefone_cliente_j.clear();
		tx_cnpj_cliente_j.clear();
		tx_cep_cliente_j.clear();
		tx_categoria_cliente_j.clear();
		tx_nome_cliente_j.clear();
		tx_nome_cliente_j.requestFocus();
	}
	
    
    private void listaCliente_Juridico() {
    	ta_mostra_cj.clear();
		List<Cliente_Juridico> listaCliente_Juridico = new Cliente_JuridicoDao().listAll();
		listaCliente_Juridico.forEach(cliente_juridico -> {
			ta_mostra_cj.appendText(cliente_juridico.toString() + "\n");
		});
	}
	
    private Cliente_Juridico pegaDados() {
		return new Cliente_Juridico(tx_nome_cliente_j.getText(), Integer.valueOf(tx_telefone_cliente_j.getText()), tx_email_cliente_j.getText(), tx_cep_cliente_j.getText(), Double.valueOf(tx_cnpj_cliente_j.getText()), tx_categoria_cliente_j.getText());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void execute() {
		launch();
	}

	@Override
	public void start(Stage stage){
		 
		try {
	            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("ViewClientesJuridicos.fxml"));
	            Scene sc = new Scene(pane);
	            stage.setScene(sc);
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }   
		
	}
	
}
