package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.Cliente_JuridicoDao;
import dao.EquipamentoDao;
import entidade.Cliente_Juridico;
import entidade.Equipamento;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Cliente_JuridicoController extends Application implements Initializable{

	
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
    private Label label_label;
    
    @FXML
    private TextField tx_busca_id;
    
    
    @FXML
    void buscarCliente_Juridico(ActionEvent event) {

    	String idString = tx_busca_id.getText();
    	Cliente_Juridico cliente_juridico = null;
		if (!idString.equals("")) {
			try {
				int id = Integer.valueOf(idString);
				cliente_juridico = new Cliente_JuridicoDao().findByID(id);
			} catch (Exception e) {

			}

			if (cliente_juridico != null) {
				label_label.setVisible(true);
				label_label.setText(cliente_juridico.getID_cli_juridico() + "");
				tx_nome_cliente_j.setText(cliente_juridico.getNome_cli_j());
				tx_email_cliente_j.setText(cliente_juridico.getEmail_cli_j());
				tx_telefone_cliente_j.setText(cliente_juridico.getTel_cli_j() + "");
				tx_cnpj_cliente_j.setText(cliente_juridico.getCnpj_cli_j() + "");
				tx_cep_cliente_j.setText(cliente_juridico.getCep_cli_j());
				tx_categoria_cliente_j.setText(cliente_juridico.getCategoria_cli_j());
			}

		}
		tx_busca_id.clear();
    	
    }
    
    
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
    
    @FXML
    void AlterarCliente_Juridico(ActionEvent event) {

    	Cliente_Juridico lista = pegaDadosID();
		limpaCampos();
		int qtde = new Cliente_JuridicoDao().alterar(lista);
		listaCliente_Juridico();
    	
    }
    
    @FXML
    void excluiCliente_Juridico(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Deletar Cliente");
    	alert.setContentText("Tem certeza que deseja deletar o Cliente?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		Cliente_Juridico clientej = pegaDadosID();
    		int qtde = new Cliente_JuridicoDao().deletar(clientej.getID_cli_juridico());
    		listaCliente_Juridico();
    	}
    	limpaCampos();
    	}

	
    private Cliente_Juridico pegaDados() {
		return new Cliente_Juridico(tx_nome_cliente_j.getText(), Integer.valueOf(tx_telefone_cliente_j.getText()), tx_email_cliente_j.getText(), tx_cep_cliente_j.getText(), Double.valueOf(tx_cnpj_cliente_j.getText()), tx_categoria_cliente_j.getText());
	}
	
    private Cliente_Juridico pegaDadosID() {
		return new Cliente_Juridico (Integer.valueOf(label_label.getText()), tx_nome_cliente_j.getText(), Integer.valueOf(tx_telefone_cliente_j.getText()), tx_email_cliente_j.getText(), tx_cep_cliente_j.getText(), Double.valueOf(tx_cnpj_cliente_j.getText()), tx_categoria_cliente_j.getText());
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		listaCliente_Juridico();
	}
	
}
