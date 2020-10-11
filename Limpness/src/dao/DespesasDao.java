package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoDb;
import entidade.Despesa;


public class DespesasDao extends ConexaoDb{

	final String SQL_INSERT_DESPESA = "INSERT INTO Despesa (VALOR, TIPO_DESP, DATA_DESP, DESCRICAO_DESP) VALUES ( ?, ?, ?, ?)";
	final String SQL_SELECT_DESPESA = "SELECT * FROM Despesa";
	final String SQL_SELECT_DESPESA_ID = "SELECT * FROM Despesa WHERE ID_DESPESA = ?";
	final String SQL_ALTERA_DESPESA = "UPDATE Despesa SET VALOR=?, TIPO_DESP=? , DATA_DESP=?, DESCRICAO_DESP=? WHERE ID_DESPESA=?";
	final String DELETA_DESPESA = "DELETE FROM Despesa WHERE ID_DESPESA = ?";
	
	public int inserir(Despesa despesa){
		int quantidade = 0;

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_INSERT_DESPESA);) 
		{
			pst.setInt(1, despesa.getValor());
			pst.setString(2, despesa.getTipo_desp());
			pst.setDate(3,Date.valueOf(despesa.getData_desp().toString()));
			pst.setString(4, despesa.getDescricao_desp());
			quantidade = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidade;
	}
	
	public List<Despesa> listAll(){
		List<Despesa> listaDespesa = new ArrayList<Despesa>();
		
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_DESPESA);){

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Despesa despesa = new Despesa();
				despesa.setID_despesa(rs.getInt("ID_DESPESA"));
				despesa.setValor(rs.getInt("VALOR"));
				despesa.setTipo_desp(rs.getString("TIPO_DESP"));
				despesa.setData_desp(Date.valueOf((rs.getString("DATA_DESP"))));
				despesa.setDescricao_desp(rs.getString("DESCRICAO_DESP"));
				listaDespesa.add(despesa);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDespesa;
	}
	
	public Despesa findByID (int id) {
		Despesa despesa = null;
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_DESPESA_ID)){

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				despesa = new Despesa();
				
				despesa.setID_despesa(rs.getInt("ID_DESPESA"));
				despesa.setValor(rs.getInt("VALOR"));
				despesa.setTipo_desp(rs.getString("TIPO_DESP"));
				despesa.setData_desp(rs.getDate("DATA_DESP"));
				despesa.setDescricao_desp(rs.getString("DESCRICAO_DESP"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return despesa;
	}
	
	
	public int alterar(Despesa despesa) {
		int quantidade = 0;

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_ALTERA_DESPESA);) {
			pst.setInt(1, despesa.getValor());
			pst.setString(2, despesa.getTipo_desp());
			pst.setDate(3, despesa.getData_desp());
			pst.setString(4, despesa.getDescricao_desp());
			pst.setInt(5, despesa.getID_despesa());
			quantidade = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidade;
	}
	
	public int deletar(int id) {
        int quantidade = 0;
        try (Connection connection = this.conectar();
            PreparedStatement pst = connection.prepareStatement(DELETA_DESPESA);) {
            pst.setInt(1, id);
            quantidade = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return quantidade;
    }

}