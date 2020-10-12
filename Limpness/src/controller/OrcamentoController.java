package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.OrcamentoDao;
import entidade.Orcamento;
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

public class OrcamentoController extends Application implements Initializable {

    @FXML
    private Button btn_adicionar_orcamento;

    @FXML
    private Button btn_pesquisar_orcamento;

    @FXML
    private Button btn_excluir_orcamento;

    @FXML
    private Button btn_alterar_orcamento;

    @FXML
    private TextArea ta_mostra_orcamento;

    @FXML
    private TextField tx_tipo_local_orcamento;

    @FXML
    private TextField tx_tipo_limpeza_orcamento;

    @FXML
    private TextField tx_qnt_funcionario_orcamento;

    @FXML
    private TextField tx_cep_orcamento;

    @FXML
    private Button btn_sair_orcamento;

    @FXML
    private TextField tx_id_cliente_orcamento;

    @FXML
    private TextField tx_busca_id_orcamento;

    @FXML
    private Label label_label;

    @FXML
    void buscarOrcamento(ActionEvent event) {

    	String idString = tx_busca_id_orcamento.getText();
    	Orcamento orcamento = null;
		if (!idString.equals("")) {
			try {
				int id = Integer.valueOf(idString);
				orcamento = new OrcamentoDao().findByID(id);
			} catch (Exception e) {

			}

			if (orcamento != null) {
				label_label.setVisible(true);
				label_label.setText(orcamento.getID_orcamento() + "");
				tx_tipo_local_orcamento.setText(orcamento.getTipo_local());
				tx_tipo_limpeza_orcamento.setText(orcamento.getTipo_limpeza());
				tx_qnt_funcionario_orcamento.setText(orcamento.getQnt_funcionario() + "");
				tx_cep_orcamento.setText(orcamento.getCep());
				tx_id_cliente_orcamento.setText(orcamento.getID_cli_fisico()+ "");

			}

		}
		tx_busca_id_orcamento.clear();
    	
    }
    
    
    
    @FXML
    void inserirOrcamento(ActionEvent event) {
	
    	Orcamento orcamento = pegaDados();
    	limpaCampos();
    	int qtde = new OrcamentoDao().inserir(orcamento);
    	listaOrcamento();
    	
	
    }
	
	private void limpaCampos() {
		tx_tipo_local_orcamento.clear();
		tx_tipo_limpeza_orcamento.clear();
		tx_qnt_funcionario_orcamento.clear();
		tx_cep_orcamento.clear();
		
	}
	
    
    private void listaOrcamento() {
    	ta_mostra_orcamento.clear();
		List<Orcamento> listaOrcamento = new OrcamentoDao().listAll();
		listaOrcamento.forEach(orcamento -> {
			ta_mostra_orcamento.appendText(orcamento.toString() + "\n");
		});
	}
	
    @FXML
    void AlterarOrcamento(ActionEvent event) {

    	Orcamento lista = pegaDadosID();
		limpaCampos();
		int qtde = new OrcamentoDao().alterar(lista);
		listaOrcamento();
    	
    }
    
    @FXML
    void excluiOrcamento(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Deletar Orcamento");
    	alert.setContentText("Tem certeza que deseja deletar o Orcamento?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		Orcamento orcamento = pegaDadosID();
    		int qtde = new OrcamentoDao().deletar(orcamento.getID_orcamento());
    		listaOrcamento();
    	}
    	limpaCampos();
    	}
    
    private Orcamento pegaDados() {
		return new Orcamento(tx_tipo_local_orcamento.getText(),tx_tipo_limpeza_orcamento.getText(),Integer.valueOf(tx_qnt_funcionario_orcamento.getText()),tx_cep_orcamento.getText(),Integer.valueOf(tx_id_cliente_orcamento.getText()));
	}
	
	
    private Orcamento pegaDadosID() {
		return new Orcamento (Integer.valueOf(label_label.getText()),tx_tipo_local_orcamento.getText(),tx_tipo_limpeza_orcamento.getText(),Integer.valueOf(tx_qnt_funcionario_orcamento.getText()),tx_cep_orcamento.getText(),Integer.valueOf(tx_id_cliente_orcamento.getText()));

	}
	
	public void execute() {
		launch();
	}

	@Override
	public void start(Stage stage){
		 
		try {
	            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("ViewOrcamento.fxml"));
	            Scene sc = new Scene(pane);
	            stage.setScene(sc);
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }   
		
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		listaOrcamento();
	}
}

	



