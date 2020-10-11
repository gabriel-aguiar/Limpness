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
	
	public int inserir(Despesa despesa){
		int quantidade = 0;

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_INSERT_DESPESA);) {
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
				System.out.println(despesa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDespesa;
	}
}