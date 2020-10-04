package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import dao.FuncionarioDao;
import entidade.Funcionario;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FuncionarioController extends Application{
	
	@FXML
    private Button btn_adicionar_funcionario;

    @FXML
    private Button btn_pesquisar_funcionario;

    @FXML
    private Button btn_excluir_funcionario;

    @FXML
    private Button btn_alterar_funcionario;

    @FXML
    private TextArea ta_mostra_funcionario;

    @FXML
    private TextField tx_id_funcionario;

    @FXML
    private TextField tx_nome_funcionario;

    @FXML
    private TextField tx_email_funcionario;

    @FXML
    private TextField tx_telefone_funcionario;

    @FXML
    private TextField tx_cep_funcionario;

    @FXML
    private TextField tx_especialidade_funcionario;

    @FXML
    private Button btn_sair_funcionario;

    @FXML
    private TextField tx_data_admicao_funcionario;

    @FXML
    private TextField tx_salario_funcionario;
    
    @FXML
    private DatePicker dp_demss_funcionario;

    @FXML
    private DatePicker dp_admss_funcionario;
    
	
	@FXML
    void inserirProfessor(ActionEvent event) {
	
		Funcionario funcionario = pegaDados();
    	limpaCampos();
    	int qtde = new FuncionarioDao().inserir(funcionario);
    	listaFuncionario();
    	System.out.println(qtde);
	
    }
	
	private void limpaCampos() {
		tx_salario_funcionario.clear();
		tx_email_funcionario.clear();
		tx_nome_funcionario.clear();
		tx_nome_funcionario.requestFocus();
		dp_admss_funcionario.setValue(null);
		dp_demss_funcionario.setValue(null);
	}
	
    
    private void listaFuncionario() {
    	ta_mostra_funcionario.clear();
		List<Funcionario> listaPessoa = new FuncionarioDao().listAll();
		listaPessoa.forEach(pessoa -> {
			ta_mostra_funcionario.appendText(pessoa.toString() + "\n");
		});
	}
	
    private Funcionario pegaDados() {
		return new Funcionario(tx_nome_funcionario.getText(), Integer.valueOf(tx_telefone_funcionario.getText()), tx_email_funcionario.getText(), tx_cep_funcionario.getText(), tx_especialidade_funcionario.getText(), Date.valueOf(dp_admss_funcionario.getValue()), Date.valueOf(dp_demss_funcionario.getValue()), Double.valueOf(tx_salario_funcionario.getText()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void execute() {
		launch();
	}
	
	@Override
	public void start(Stage stage){
		try {
			AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Principal.fxml"));
			Scene sc = new Scene(pane);
			stage.setScene(sc);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
