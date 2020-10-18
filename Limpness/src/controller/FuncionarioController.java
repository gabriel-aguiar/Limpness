package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import dao.FuncionarioDao;
import entidade.Funcionario;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FuncionarioController extends Application implements Initializable{
	
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
    private TextField textFildID;
    
    @FXML
    private Label labelLabelID;

    @FXML
    private Label labelID;
    
	
	@FXML
    void inserirFuncionario(ActionEvent event) {
	
		Funcionario funcionario = pegaDados();
    	limpaCampos();
    	int qtde = new FuncionarioDao().inserir(funcionario);
    	listaFuncionario();
    	System.out.println(qtde);
	
    }
	
	private void limpaCampos() {
		tx_salario_funcionario.clear();
		tx_email_funcionario.clear();
		tx_telefone_funcionario.clear();
		tx_cep_funcionario.clear();
		tx_especialidade_funcionario.clear();
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
	
    private Funcionario pegaDadoId() {
		return new Funcionario(Integer.valueOf(labelID.getText()) , tx_nome_funcionario.getText(), Integer.valueOf(tx_telefone_funcionario.getText()), tx_email_funcionario.getText(), tx_cep_funcionario.getText(), tx_especialidade_funcionario.getText(), Date.valueOf(dp_admss_funcionario.getValue()), Date.valueOf(dp_demss_funcionario.getValue()), Double.valueOf(tx_salario_funcionario.getText()));
	}
    
    @FXML
    void buscarFuncionario(ActionEvent event) {
    	
    	String idString = textFildID.getText();
    	Funcionario funcionario = null;
    	if(!idString.equals(""))
    	{
    		try
    		{
    			int id = Integer.valueOf(idString);
    			funcionario = new FuncionarioDao().findByID(id);
    		}
    		catch (Exception e)
    		{
    			
    		}
    		if (funcionario != null)
    		{
    			labelLabelID.setVisible(true);
    			labelID.setVisible(true);
    			labelID.setText(funcionario.getID_funcionario()+"");
    			tx_nome_funcionario.setText(funcionario.getNome_func());
    			tx_telefone_funcionario.setText(funcionario.getTel_func() + "");
    			tx_email_funcionario.setText(funcionario.getEmail_func());
    			tx_cep_funcionario.setText(funcionario.getEndereco_func());
    			tx_especialidade_funcionario.setText(funcionario.getEspecialidade_func());
    			dp_admss_funcionario.setValue(funcionario.getData_admss_func().toLocalDate());
    			dp_demss_funcionario.setValue(funcionario.getData_demss_func().toLocalDate());
    			tx_salario_funcionario.setText(funcionario.getSalario_finc() + "");
    			
    		}
    	}
    	
    	textFildID.clear();

    }
    
    
    @FXML
    void alterarFuncionario(ActionEvent event) {
    	
    	Funcionario funcionario = pegaDadoId();
    	limpaCampos();
    	int qtde = new FuncionarioDao().alterar(funcionario);
    	listaFuncionario();
    	System.out.println(qtde);
    	
    }
    
    
    @FXML
    void deletaFuncionario(ActionEvent event) {
    	
    	 int opt = JOptionPane.showConfirmDialog(null, "Quem mesmo deletar esse registro?" , "Delete", JOptionPane.YES_NO_OPTION);
   	  if(opt ==0 )
   	  {
   		Funcionario funcionario= pegaDadoId();
   		  limpaCampos(); 	
   	      int qtde = new FuncionarioDao().deleta(funcionario);
   	      listaFuncionario();
   	      System.out.println(qtde);
   	      
   	  }

    }
   

    public void linkfuncionario(ActionEvent event) throws Exception {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(FuncionarioController.class.getResource("ViewFuncionario.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
	public void execute() {
		launch();
	}

	@Override
	public void start(Stage stage){
		 
		try {
	            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("ViewFuncionario.fxml"));
	            Scene sc = new Scene(pane);
	            stage.setScene(sc);
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }   
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		listaFuncionario();
		
	}
}
