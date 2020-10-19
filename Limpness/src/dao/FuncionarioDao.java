package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexao.ConexaoDb;
import entidade.Funcionario;

public class FuncionarioDao extends ConexaoDb{

	final String SQL_INSERT_FUNCIONARIO = "INSERT INTO Funcionario (NOME_FUNC, TEL_FUNC, EMAIL_FUNC, ENDERECO_FUNC, ESPECIALIDADE_FUNC, DATA_ADMSS_FUNC, DATA_DEMSS_FUNC, SALARIO_FINC) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
	final String SQL_SELECT_FUNCIONARIO = "SELECT * FROM Funcionario";
	final String SQL_SELECT_FUNCIONARIO_ID = "SELECT * FROM Funcionario WHERE ID_funcionario = ?";
	final String SQL_ALTERA_FUNCIONARIO = "UPDATE Funcionario SET NOME_FUNC = ?, TEL_FUNC = ?, EMAIL_FUNC = ?, ENDERECO_FUNC = ?, ESPECIALIDADE_FUNC = ?, DATA_ADMSS_FUNC = ?, DATA_DEMSS_FUNC = ?, SALARIO_FINC = ? WHERE ID_funcionario = ?  ";
	final String SQL_DELETA_FUNCIONARIO = "DELETE FROM Funcionario WHERE ID_funcionario = ?";
	
	public int inserir(Funcionario funcionario){
		int quantidade = 0;

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_INSERT_FUNCIONARIO);) {
			pst.setString(1, funcionario.getNome_func());
			pst.setInt(2, funcionario.getTel_func());
			pst.setString(3, funcionario.getEmail_func());
			pst.setString(4, funcionario.getEndereco_func());
			pst.setString(5, funcionario.getEspecialidade_func());
			pst.setDate(6,Date.valueOf(funcionario.getData_admss_func().toString()));
			pst.setDate(7,Date.valueOf(funcionario.getData_demss_func().toString()));
			pst.setDouble(8, funcionario.getSalario_finc());
			quantidade = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidade;
	}
	
	public List<Funcionario> listAll(){
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_FUNCIONARIO);){

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setID_funcionario(rs.getInt("ID_FUNCIONARIO"));
				funcionario.setNome_func(rs.getString("NOME_FUNC"));
				funcionario.setTel_func(rs.getInt("TEL_FUNC"));
				funcionario.setEmail_func(rs.getString("EMAIL_FUNC"));
				funcionario.setEndereco_func(rs.getString("ENDERECO_FUNC"));
				funcionario.setEspecialidade_func(rs.getString("ESPECIALIDADE_FUNC"));
				funcionario.setData_admss_func(Date.valueOf((rs.getString("DATA_ADMSS_FUNC"))));
				funcionario.setData_demss_func(Date.valueOf((rs.getString("DATA_DEMSS_FUNC"))));
				funcionario.setSalario_finc(rs.getDouble("SALARIO_FINC"));
				listaFuncionario.add(funcionario);
				System.out.println(funcionario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaFuncionario;
	}
	
	public Funcionario findByID(int id)
	{
		Funcionario funcionario = null;
		try(Connection connection = this.conectar();
				PreparedStatement pst	= connection.prepareStatement(SQL_SELECT_FUNCIONARIO_ID);)
		{
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				funcionario = new Funcionario();					
				funcionario.setID_funcionario(rs.getInt("ID_FUNCIONARIO"));
				funcionario.setNome_func(rs.getString("NOME_FUNC"));
				funcionario.setTel_func(rs.getInt("TEL_FUNC"));
				funcionario.setEmail_func(rs.getString("EMAIL_FUNC"));
				funcionario.setEndereco_func(rs.getString("ENDERECO_FUNC"));
				funcionario.setEspecialidade_func(rs.getString("ESPECIALIDADE_FUNC"));
				funcionario.setData_admss_func(Date.valueOf((rs.getString("DATA_ADMSS_FUNC"))));
				funcionario.setData_demss_func(Date.valueOf((rs.getString("DATA_DEMSS_FUNC"))));
				funcionario.setSalario_finc(rs.getDouble("SALARIO_FINC"));
				
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	  return funcionario;
	}
		
	public int alterar(Funcionario funcionario) {

		int quantidade = 0;		
		try (Connection connection = this.conectar();
			PreparedStatement pst	= connection.prepareStatement(SQL_ALTERA_FUNCIONARIO);)
		{
			pst.setString(1, funcionario.getNome_func());
			pst.setInt(2,  funcionario.getTel_func());
			pst.setString(3, funcionario.getEmail_func());
			pst.setString(4, funcionario.getEndereco_func());
			pst.setString(5, funcionario.getEspecialidade_func());
			pst.setDate(6,Date.valueOf(funcionario.getData_admss_func().toString()));
			pst.setDate(7,Date.valueOf(funcionario.getData_demss_func().toString()));
			pst.setDouble(8, funcionario.getSalario_finc());
			pst.setInt(9, funcionario.getID_funcionario());
			quantidade = pst.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return quantidade;
	}
	
	
	public int deleta(Funcionario funcionario)
	{
		int quantidade = 0;
		
		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_DELETA_FUNCIONARIO);)
		{
			pst.setInt(1, funcionario.getID_funcionario());
			quantidade = pst.executeUpdate();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	 
		
		return quantidade;
	}	
	
}
