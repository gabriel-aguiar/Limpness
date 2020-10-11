package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoDb;
import entidade.Equipamento;


public class EquipamentoDao extends ConexaoDb{

		final String SQL_INSERT_EQUIPAMENTO = "INSERT INTO Equipamento (NOME, QNT_EQUIP, TIPO_EQUIP, ID_FUNCIONARIO) VALUES ( ?, ?, ?, ?)";
		final String SQL_SELECT_EQUIPAMENTO = "SELECT * FROM Equipamento";
		
		public int inserir(Equipamento equipamento){
			int quantidade = 0;

			try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_INSERT_EQUIPAMENTO);) {
				pst.setString(1, equipamento.getNome());
				pst.setInt(2, equipamento.getQnt_equip());
				pst.setString(3, equipamento.getTipo_equip());
				pst.setInt(4, equipamento.getID_funcionario());
				quantidade = pst.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return quantidade;
		}
		
		public List<Equipamento> listAll(){
			List<Equipamento> listaEquipamento = new ArrayList<Equipamento>();
			
			try (Connection connection = this.conectar();
					PreparedStatement pst = connection.prepareStatement(SQL_SELECT_EQUIPAMENTO);){

				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					Equipamento equipamento = new Equipamento();
					equipamento.setID_equipamento(rs.getInt("ID_EQUIPAMENTO"));
					equipamento.setNome(rs.getString("NOME"));
					equipamento.setQnt_equip(rs.getInt("QNT_EQUIP"));
					equipamento.setTipo_equip(rs.getString("TIPO_EQUIP"));
					equipamento.setID_funcionario(rs.getInt("ID_FUNCIONARIO"));
					equipamento.setID_equipamento(rs.getInt("ID_EQUIPAMENTO"));
					listaEquipamento.add(equipamento);
					System.out.println(equipamento);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listaEquipamento;
		}
	}
