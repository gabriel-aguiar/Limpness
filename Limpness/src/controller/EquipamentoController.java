package controller;

import java.io.IOException;
import java.util.List;

import dao.EquipamentoDao;
import entidade.Equipamento;
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

public class EquipamentoController extends Application{

	  @FXML
	    private Button btn_adicionar_equipamento;

	    @FXML
	    private Button btn_pesquisar_equipamento;

	    @FXML
	    private Button btn_excluir_equipamento;

	    @FXML
	    private Button btn_alterar_equipamento;

	    @FXML
	    private TextField tx_id_equipamento;

	    @FXML
	    private TextField tx_nome_equipamento;

	    @FXML
	    private TextField tx_qnt_equipamento_equipamento;

	    @FXML
	    private TextField tx_tipo_equipamento_equipamento;

	    @FXML
	    private TextField tx_id_funcionario_equipamento;

	    @FXML
	    private Button btn_sair_equipamento;
	    
	    @FXML
	    private TextArea ta_mostra_equipamento;

	
	
	@FXML
    void inserirEquipamento(ActionEvent event) {
	
		Equipamento equipamento = pegaDados();
    	limpaCampos();
    	int qtde = new EquipamentoDao().inserir(equipamento);
    	listaEquipamento();
    	System.out.println(qtde);
	
    }
	
	private void limpaCampos() {
		
		tx_id_funcionario_equipamento.clear();
		tx_tipo_equipamento_equipamento.clear();
		tx_qnt_equipamento_equipamento.clear();
		tx_nome_equipamento.clear();
		tx_nome_equipamento.requestFocus();

	}
	
    
    private void listaEquipamento() {
    	ta_mostra_equipamento.clear();
		List<Equipamento> listaEquipamento = new EquipamentoDao().listAll();
		listaEquipamento.forEach(pessoa -> {
			ta_mostra_equipamento.appendText(pessoa.toString() + "\n");
		});
	}
	
    private Equipamento pegaDados() {
		return new Equipamento(tx_nome_equipamento.getText(), Integer.valueOf(tx_qnt_equipamento_equipamento.getText()), tx_tipo_equipamento_equipamento.getText(), Integer.valueOf(tx_id_funcionario_equipamento.getText()));
	}
	
	
	
	
	
	
	
	
	
	
	public void execute() {
		launch();
	}

	@Override
	public void start(Stage stage){
		
		try {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("ViewEquipamentos.fxml"));
            Scene sc = new Scene(pane);
            stage.setScene(sc);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
		
	}
	
}
