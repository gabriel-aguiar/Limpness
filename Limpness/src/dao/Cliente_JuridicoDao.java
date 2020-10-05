package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoDb;
import entidade.Cliente_Juridico;

public class Cliente_JuridicoDao extends ConexaoDb{

	final String SQL_INSERT_CLIENTE_JURIDICO = "INSERT INTO Cliente_Juridico (NOME_CLI_J, TEL_CLI_J, EMAIL_CLI_J, CEP_CLI_J, CNPJ_CLI_J, CATEGORIA_CLI_J) VALUES ( ?, ?, ?, ?, ?, ?)";
	final String SQL_SELECT_CLIENTE_JURIDICO = "SELECT * FROM Cliente_Juridico";
	
	public int inserir(Cliente_Juridico clientej){
		int quantidade = 0;

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_INSERT_CLIENTE_JURIDICO);) {
			pst.setString(1, clientej.getNome_cli_j());
			pst.setInt(2, clientej.getTel_cli_j());
			pst.setString(3, clientej.getEmail_cli_j());
			pst.setString(4, clientej.getCep_cli_j());
			pst.setDouble(5, clientej.getCnpj_cli_j());
			pst.setString(6, clientej.getCategoria_cli_j());
			quantidade = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidade;
	}
	
	public List<Cliente_Juridico> listAll(){
		List<Cliente_Juridico> listaCliente_Juridico = new ArrayList<Cliente_Juridico>();
		
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_CLIENTE_JURIDICO);){

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Cliente_Juridico clientej = new Cliente_Juridico();
				clientej.setID_cli_juridico(rs.getInt("ID_CLI_JURIDICO"));
				clientej.setNome_cli_j(rs.getString("NOME_CLI_J"));
				clientej.setTel_cli_j(rs.getInt("TEL_CLI_J"));
				clientej.setEmail_cli_j(rs.getString("EMAIL_CLI_J"));
				clientej.setCep_cli_j(rs.getString("CEP_CLI_J"));
				clientej.setCnpj_cli_j(rs.getDouble("CNPJ_CLI_J"));
				clientej.setCategoria_cli_j((rs.getString("CATEGORIA_CLI_J")));
				listaCliente_Juridico.add(clientej);
				System.out.println(clientej);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCliente_Juridico;
	}

}
