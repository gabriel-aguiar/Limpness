package controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import dao.EquipamentoDao;
import entidade.Equipamento;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	    private Label label_label;
	    
	    @FXML
	    private TextField tx_busca_id;
	
	    
	    @FXML
	    void buscarEquipamento(ActionEvent event) {

	    	String idString = tx_busca_id.getText();
	    	Equipamento equipamento = null;
			if (!idString.equals("")) {
				try {
					int id = Integer.valueOf(idString);
					equipamento = new EquipamentoDao().findByID(id);
				} catch (Exception e) {

				}

				if (equipamento != null) {
					label_label.setVisible(true);
					label_label.setText(equipamento.getID_equipamento() + "");
					tx_nome_equipamento.setText(equipamento.getNome());
					tx_qnt_equipamento_equipamento.setText(equipamento.getQnt_equip() + "");
					tx_tipo_equipamento_equipamento.setText(equipamento.getTipo_equip());
					tx_id_funcionario_equipamento.setText(equipamento.getID_funcionario() + "");
				}

			}
			tx_busca_id.clear();
	    	
	    }
	
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
    
    @FXML
    void AlterarEquipamento(ActionEvent event) {

    	Equipamento lista = pegaDadosID();
		limpaCampos();
		int qtde = new EquipamentoDao().alterar(lista);
		listaEquipamento();
    	
    }
    
    @FXML
    void excluiEquipamento(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Deletar Equipamento");
    	alert.setContentText("Tem certeza que deseja deletar o Equipamento?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		Equipamento Professor = pegaDadosID();
    		int qtde = new EquipamentoDao().deletar(Professor.getID_equipamento());
    		listaEquipamento();
    	}
    	limpaCampos();
    	}

	private Equipamento pegaDadosID() {
		return new Equipamento (Integer.valueOf(label_label.getText()), tx_nome_equipamento.getText(), Integer.valueOf(tx_qnt_equipamento_equipamento.getText()), tx_tipo_equipamento_equipamento.getText(), Integer.valueOf(tx_id_funcionario_equipamento.getText()));
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
