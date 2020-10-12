package entidade;

public class Orcamento {
 private int ID_orcamento;
 private String tipo_local;
 private String tipo_limpeza;
 private int qnt_funcionario;
 private String cep;
 private int ID_cli_fisico;
 
 public Orcamento() {
	 
 }
 
public Orcamento(String tipo_local, String tipo_limpeza, int qnt_funcionario, String cep, int iD_cli_fisico) {
	super();
	this.tipo_local = tipo_local;
	this.tipo_limpeza = tipo_limpeza;
	this.qnt_funcionario = qnt_funcionario;
	this.cep = cep;
	ID_cli_fisico = iD_cli_fisico;
}
public Orcamento(int iD_orcamento, String tipo_local, String tipo_limpeza, int qnt_funcionario, String cep,
		int iD_cli_fisico) {
	super();
	ID_orcamento = iD_orcamento;
	this.tipo_local = tipo_local;
	this.tipo_limpeza = tipo_limpeza;
	this.qnt_funcionario = qnt_funcionario;
	this.cep = cep;
	ID_cli_fisico = iD_cli_fisico;
}

public int getID_orcamento() {
	return ID_orcamento;
}
public void setID_orcamento(int iD_orcamento) {
	ID_orcamento = iD_orcamento;
}
public String getTipo_local() {
	return tipo_local;
}
public void setTipo_local(String tipo_local) {
	this.tipo_local = tipo_local;
}
public String getTipo_limpeza() {
	return tipo_limpeza;
}
public void setTipo_limpeza(String tipo_limpeza) {
	this.tipo_limpeza = tipo_limpeza;
}
public int getQnt_funcionario() {
	return qnt_funcionario;
}
public void setQnt_funcionario(int qnt_funcionario) {
	this.qnt_funcionario = qnt_funcionario;
}
public String getCep() {
	return cep;
}
public void setCep(String cep) {
	this.cep = cep;
}
public int getID_cli_fisico() {
	return ID_cli_fisico;
}
public void setID_cli_fisico(int iD_cli_fisico) {
	ID_cli_fisico = iD_cli_fisico;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ID_cli_fisico;
	result = prime * result + ID_orcamento;
	result = prime * result + ((cep == null) ? 0 : cep.hashCode());
	result = prime * result + qnt_funcionario;
	result = prime * result + ((tipo_limpeza == null) ? 0 : tipo_limpeza.hashCode());
	result = prime * result + ((tipo_local == null) ? 0 : tipo_local.hashCode());
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
	Orcamento other = (Orcamento) obj;
	if (ID_cli_fisico != other.ID_cli_fisico)
		return false;
	if (ID_orcamento != other.ID_orcamento)
		return false;
	if (cep == null) {
		if (other.cep != null)
			return false;
	} else if (!cep.equals(other.cep))
		return false;
	if (qnt_funcionario != other.qnt_funcionario)
		return false;
	if (tipo_limpeza == null) {
		if (other.tipo_limpeza != null)
			return false;
	} else if (!tipo_limpeza.equals(other.tipo_limpeza))
		return false;
	if (tipo_local == null) {
		if (other.tipo_local != null)
			return false;
	} else if (!tipo_local.equals(other.tipo_local))
		return false;
	return true;
}
@Override
public String toString() {
	return "Orcamento [ID_orcamento=" + ID_orcamento + ", tipo_local=" + tipo_local + ", tipo_limpeza=" + tipo_limpeza
			+ ", qnt_funcionario=" + qnt_funcionario + ", cep=" + cep + ", ID_cli_fisico=" + ID_cli_fisico + "]";
}
 
 
 
}
