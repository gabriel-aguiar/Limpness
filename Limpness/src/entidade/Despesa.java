package entidade;

import java.sql.Date;

public class Despesa {

	private int	ID_despesa;
	private int	valor;
	private String tipo_desp;
	private Date data_desp;
	private String descricao_desp;
	
	public Despesa() {
		
	}
	
	public Despesa(int valor, String tipo_desp, Date data_desp, String descricao_desp) {
		super();
		this.valor = valor;
		this.tipo_desp = tipo_desp;
		this.data_desp = data_desp;
		this.descricao_desp = descricao_desp;
	}


	public Despesa(int iD_despesa, int valor, String tipo_desp, Date data_desp, String descricao_desp) {
		super();
		ID_despesa = iD_despesa;
		this.valor = valor;
		this.tipo_desp = tipo_desp;
		this.data_desp = data_desp;
		this.descricao_desp = descricao_desp;
	}


	public int getID_despesa() {
		return ID_despesa;
	}


	public void setID_despesa(int iD_despesa) {
		ID_despesa = iD_despesa;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public String getTipo_desp() {
		return tipo_desp;
	}


	public void setTipo_desp(String tipo_desp) {
		this.tipo_desp = tipo_desp;
	}


	public Date getData_desp() {
		return data_desp;
	}


	public void setData_desp(Date data_desp) {
		this.data_desp = data_desp;
	}


	public String getDescricao_desp() {
		return descricao_desp;
	}


	public void setDescricao_desp(String descricao_desp) {
		this.descricao_desp = descricao_desp;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_despesa;
		result = prime * result + ((data_desp == null) ? 0 : data_desp.hashCode());
		result = prime * result + ((descricao_desp == null) ? 0 : descricao_desp.hashCode());
		result = prime * result + ((tipo_desp == null) ? 0 : tipo_desp.hashCode());
		result = prime * result + valor;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesa other = (Despesa) obj;
		if (ID_despesa != other.ID_despesa)
			return false;
		if (data_desp == null) {
			if (other.data_desp != null)
				return false;
		} else if (!data_desp.equals(other.data_desp))
			return false;
		if (descricao_desp == null) {
			if (other.descricao_desp != null)
				return false;
		} else if (!descricao_desp.equals(other.descricao_desp))
			return false;
		if (tipo_desp == null) {
			if (other.tipo_desp != null)
				return false;
		} else if (!tipo_desp.equals(other.tipo_desp))
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Despesa ID_despesa=" + ID_despesa + ", valor=" + valor + ", tipo_desp=" + tipo_desp + ", data_desp="
				+ data_desp + ", descricao_desp=" + descricao_desp;
	}

	
}
