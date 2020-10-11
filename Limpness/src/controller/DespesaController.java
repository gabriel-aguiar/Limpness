package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.DespesasDao;
import entidade.Despesa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DespesaController extends Application implements Initializable{
	
	@FXML
    private Button btn_adicionar_despesas;

    @FXML
    private Button btn_pesquisar_despesas;

    @FXML
    private Button btn_excluir_despesas;

    @FXML
    private Button btn_alterar_despesas;

    @FXML
    private TextArea ta_mostra_despesas;

    @FXML
    private TextField tx_valor_despesas;

    @FXML
    private TextField tx_tipo_despesa_despesas;

    @FXML
    private Button btn_sair_despesas;

    @FXML
    private TextArea ta_descricao_despesa;

    @FXML
    private DatePicker dp_despesa;
    
    
    @FXML
    private Label label_label;

    @FXML
    private TextField tx_busca_id_despesa;
    
	
    @FXML
    void buscarDespesas(ActionEvent event) {

    	String idString = tx_busca_id_despesa.getText();
    	Despesa despesa = null;
		if (!idString.equals("")) {
			try {
				int id = Integer.valueOf(idString);
				despesa = new DespesasDao().findByID(id);
			} catch (Exception e) {

			}

			if (despesa != null) {
				label_label.setVisible(true);
				label_label.setText(despesa.getID_despesa() + "");
				tx_valor_despesas.setText(despesa.getValor() + "");
				tx_tipo_despesa_despesas.setText(despesa.getTipo_desp());
				dp_despesa.setValue(despesa.getData_desp().toLocalDate());
				ta_descricao_despesa.setText(despesa.getDescricao_desp());
			}

		}
		tx_busca_id_despesa.clear();
    	
    }
    
    
    
    @FXML
    void inserirDespesas(ActionEvent event) {
	
    	Despesa despesa = pegaDados();
    	limpaCampos();
    	int qtde = new DespesasDao().inserir(despesa);
    	listaDespesa();
    	
	
    }
	
	private void limpaCampos() {
		tx_valor_despesas.clear();
		tx_tipo_despesa_despesas.clear();
		ta_descricao_despesa.clear();
		dp_despesa.setValue(null);
	}
	
    
    private void listaDespesa() {
    	ta_mostra_despesas.clear();
		List<Despesa> listaDespesa = new DespesasDao().listAll();
		listaDespesa.forEach(despesa -> {
			ta_mostra_despesas.appendText(despesa.toString() + "\n");
		});
	}
	
    @FXML
    void AlterarDespesa(ActionEvent event) {

    	Despesa lista = pegaDadosID();
		limpaCampos();
		int qtde = new DespesasDao().alterar(lista);
		listaDespesa();
    	
    }
    
    @FXML
    void excluiDespesa(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Deletar Despesa");
    	alert.setContentText("Tem certeza que deseja deletar o Despesa?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		Despesa despesa = pegaDadosID();
    		int qtde = new DespesasDao().deletar(despesa.getID_despesa());
    		listaDespesa();
    	}
    	limpaCampos();
    	}
    
    private Despesa pegaDados() {
		return new Despesa(Integer.valueOf(tx_valor_despesas.getText()), tx_tipo_despesa_despesas.getText(), Date.valueOf(dp_despesa.getValue()), ta_descricao_despesa.getText());
	}
	
	
    private Despesa pegaDadosID() {
		return new Despesa (Integer.valueOf(label_label.getText()),Integer.valueOf(tx_valor_despesas.getText()), tx_tipo_despesa_despesas.getText(), Date.valueOf(dp_despesa.getValue()), ta_descricao_despesa.getText());

	}
	
	public void execute() {
		launch();
	}

	@Override
	public void start(Stage stage){
		 
		try {
	            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("ViewDespesas.fxml"));
	            Scene sc = new Scene(pane);
	            stage.setScene(sc);
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }   
		
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		listaDespesa();
	}
}
