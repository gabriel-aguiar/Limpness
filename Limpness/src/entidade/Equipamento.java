package entidade;

public class Equipamento {
	
	private int ID_equipamento;
	private String nome;
	private int qnt_equip;
	private String tipo_equip;
	private int ID_funcionario;
	
	public Equipamento() {
		
	}

	public Equipamento(String nome, int qnt_equip, String tipo_equip, int iD_funcionario) {
		super();
		this.nome = nome;
		this.qnt_equip = qnt_equip;
		this.tipo_equip = tipo_equip;
		ID_funcionario = iD_funcionario;
	}

	public Equipamento(int iD_equipamento, String nome, int qnt_equip, String tipo_equip, int iD_funcionario) {
		super();
		ID_equipamento = iD_equipamento;
		this.nome = nome;
		this.qnt_equip = qnt_equip;
		this.tipo_equip = tipo_equip;
		ID_funcionario = iD_funcionario;
	}

	public int getID_equipamento() {
		return ID_equipamento;
	}

	public void setID_equipamento(int iD_equipamento) {
		ID_equipamento = iD_equipamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQnt_equip() {
		return qnt_equip;
	}

	public void setQnt_equip(int qnt_equip) {
		this.qnt_equip = qnt_equip;
	}

	public String getTipo_equip() {
		return tipo_equip;
	}

	public void setTipo_equip(String tipo_equip) {
		this.tipo_equip = tipo_equip;
	}

	public int getID_funcionario() {
		return ID_funcionario;
	}

	public void setID_funcionario(int iD_funcionario) {
		ID_funcionario = iD_funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_equipamento;
		result = prime * result + ID_funcionario;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + qnt_equip;
		result = prime * result + ((tipo_equip == null) ? 0 : tipo_equip.hashCode());
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
		Equipamento other = (Equipamento) obj;
		if (ID_equipamento != other.ID_equipamento)
			return false;
		if (ID_funcionario != other.ID_funcionario)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (qnt_equip != other.qnt_equip)
			return false;
		if (tipo_equip == null) {
			if (other.tipo_equip != null)
				return false;
		} else if (!tipo_equip.equals(other.tipo_equip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipamento ID_equipamento=" + ID_equipamento + ", nome=" + nome + ", qnt_equip=" + qnt_equip
				+ ", tipo_equip=" + tipo_equip + ", ID_funcionario=" + ID_funcionario;
	}
	
	
}
