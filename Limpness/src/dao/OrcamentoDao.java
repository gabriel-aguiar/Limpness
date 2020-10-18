package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoDb;
import entidade.Orcamento;

public class OrcamentoDao extends ConexaoDb {
	final String SQL_INSERT_ORCAMENTO = "INSERT INTO Orcamento (TIPO_LOCAL, TIPO_LIMPEZA, QNT_FUNCIONARIO, CEP, ID_CLI_FISICO, ID_CLI_JURIDICO) VALUES ( ?, ?, ?, ?, ?, ?)";
	final String SQL_SELECT_ORCAMENTO = "SELECT * FROM Orcamento";
	final String SQL_SELECT_ORCAMENTO_ID = "SELECT * FROM Orcamento WHERE ID_ORCAMENTO = ?";
	final String SQL_ALTERA_ORCAMENTO = "UPDATE Despesa SET TIPO_LOCAL=?, TIPO_LIMPEZA=? , QNT_FUNCIONARIO=?, CEP=?, ID_CLI_FISICO=?, ID_CLI_JURIDICO=? WHERE ID_DESPESA=?";
	final String DELETA_ORCAMENTO = "DELETE FROM Orcamento WHERE ID_ORCAMENTO = ?";
	
	public int inserir(Orcamento orcamento){
		int quantidade = 0;

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_INSERT_ORCAMENTO);) 
		{
			pst.setString(1, orcamento.getTipo_local());
			pst.setString(2, orcamento.getTipo_limpeza());
			pst.setInt(3, orcamento.getQnt_funcionario());
			pst.setString(4, orcamento.getCep());
			pst.setInt(5, orcamento.getID_cli_fisico());
			pst.setInt(6, orcamento.getID_cli_juridico());
			quantidade = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidade;
	}
	
	public List<Orcamento> listAll(){
		List<Orcamento> listaOrcamento = new ArrayList<Orcamento>();
		
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_ORCAMENTO);){

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Orcamento orcamento = new Orcamento();
				orcamento.setID_orcamento(rs.getInt("ID_ORCAMENTO"));
				orcamento.setTipo_local(rs.getString("TIPO_LOCAL"));
				orcamento.setTipo_limpeza(rs.getString("TIPO_LIMPEZA"));
				orcamento.setQnt_funcionario(rs.getInt("QNT_FUNCIONARIO"));
				orcamento.setCep(rs.getString("CEP"));
				orcamento.setID_cli_fisico(rs.getInt("ID_CLI_FISICO"));
				orcamento.setID_cli_fisico(rs.getInt("ID_CLI_JURIDICO"));
				listaOrcamento.add(orcamento);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaOrcamento;
	}
	
	public Orcamento findByID (int id) {
		Orcamento orcamento = null;
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_ORCAMENTO_ID)){

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				orcamento = new Orcamento();
				
				orcamento.setID_orcamento(rs.getInt("ID_ORCAMENTO"));
				orcamento.setTipo_local(rs.getString("TIPO_LOCAL"));
				orcamento.setTipo_limpeza(rs.getString("TIPO_LIMPEZA"));
				orcamento.setQnt_funcionario(rs.getInt("QNT_FUNCIONARIO"));
				orcamento.setCep(rs.getString("CEP"));
				orcamento.setID_cli_fisico(rs.getInt("ID_CLI_FISICO"));
				orcamento.setID_cli_fisico(rs.getInt("ID_CLI_JURIDICO"));
		
			
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orcamento;
	}
	
	
	public int alterar(Orcamento orcamento) {
		int quantidade = 0;

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_ALTERA_ORCAMENTO);) {
			pst.setString(1, orcamento.getTipo_local());
			pst.setString(2, orcamento.getTipo_limpeza());
			pst.setInt(3, orcamento.getQnt_funcionario());
			pst.setString(4, orcamento.getCep());
			pst.setInt(5, orcamento.getID_cli_fisico());
			pst.setInt(6, orcamento.getID_cli_juridico());
			pst.setInt(6, orcamento.getID_orcamento());
			quantidade = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidade;
	}
	
	public int deletar(int id) {
        int quantidade = 0;
        try (Connection connection = this.conectar();
            PreparedStatement pst = connection.prepareStatement(DELETA_ORCAMENTO);) {
            pst.setInt(1, id);
            quantidade = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return quantidade;
    }
}
