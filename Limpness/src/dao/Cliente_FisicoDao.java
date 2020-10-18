package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoDb;
import entidade.Cliente_Fisico;

public class Cliente_FisicoDao extends ConexaoDb{

	final String SQL_INSERT_CLIENTE_FISICO = "INSERT INTO Cliente_fisico (NOME_CLI_F, TEL_CLI_F, CPF_FUNC, EMAIL_CLI_F, CEP_CLI_F) VALUES ( ?, ?, ?, ?, ?)";
	final String SQL_SELECT_CLIENTE_FISICO = "SELECT * FROM Cliente_fisico";
	
	public int inserir(Cliente_Fisico clientef){
		int quantidade = 0;

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_INSERT_CLIENTE_FISICO);) {
			pst.setString(1, clientef.getNome_cli_f());
			pst.setInt(2, clientef.getTel_cli_f());
			pst.setDouble(3, clientef.getCpf_func());
			pst.setString(4, clientef.getEmail_cli_f());
			pst.setString(5, clientef.getCep_cli_f());
			quantidade = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidade;
	}
	
	public List<Cliente_Fisico> listAll(){
		List<Cliente_Fisico> listaCliente_Fisico = new ArrayList<Cliente_Fisico>();
		
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_CLIENTE_FISICO);){

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Cliente_Fisico clientef = new Cliente_Fisico();
				clientef.setID_cli_fisico(rs.getInt("ID_CLI_FISICO"));
				clientef.setNome_cli_f(rs.getString("NOME_CLI_F"));
				clientef.setTel_cli_f(rs.getInt("TEL_CLI_F"));
				clientef.setCpf_func(rs.getInt("CPF_FUNC"));
				clientef.setEmail_cli_f(rs.getString("EMAIL_CLI_F"));
				clientef.setCep_cli_f(rs.getString("CEP_CLI_F"));
				listaCliente_Fisico.add(clientef);
				System.out.println(clientef);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCliente_Fisico;
	}

}

