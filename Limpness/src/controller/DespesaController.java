package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import dao.DespesasDao;
import dao.FuncionarioDao;
import entidade.Despesa;
import entidade.Funcionario;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DespesaController extends Application{
	
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
    void inserirDespesas(ActionEvent event) {
	
    	Despesa despesa = pegaDados();
    	limpaCampos();
    	int qtde = new DespesasDao().inserir(despesa);
    	listaDespesa();
    	System.out.println(qtde);
	
    }
	
	private void limpaCampos() {
		tx_valor_despesas.clear();
		tx_tipo_despesa_despesas.clear();
		ta_descricao_despesa.clear();
		dp_despesa.setValue(null);
	}
	
    
    private void listaDespesa() {
    	ta_descricao_despesa.clear();
		List<Despesa> listaDespesa = new DespesasDao().listAll();
		listaDespesa.forEach(despesa -> {
			ta_descricao_despesa.appendText(despesa.toString() + "\n");
		});
	}
	
    private Despesa pegaDados() {
		return new Despesa(Integer.valueOf(tx_valor_despesas.getText()), tx_tipo_despesa_despesas.getText(), Date.valueOf(dp_despesa.getValue()), ta_descricao_despesa.getText());
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
}
