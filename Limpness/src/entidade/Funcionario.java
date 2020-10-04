package entidade;

import java.sql.Date;

public class Funcionario {

	private int ID_funcionario; 
	private String nome_func;
	private int tel_func;
	private String email_func;
	private String endereco_func;
	private String especialidade_func;
	private Date data_admss_func;
	private Date data_demss_func;
	private Double salario_finc;
	
	public Funcionario() {
		
	}

	public Funcionario(int iD_funcionario, String nome_func, int tel_func, String email_func, String endereco_func,
			String especialidade_func, Date data_admss_func, Date data_demss_func, Double salario_finc) {
		super();
		ID_funcionario = iD_funcionario;
		this.nome_func = nome_func;
		this.tel_func = tel_func;
		this.email_func = email_func;
		this.endereco_func = endereco_func;
		this.especialidade_func = especialidade_func;
		this.data_admss_func = data_admss_func;
		this.data_demss_func = data_demss_func;
		this.salario_finc = salario_finc;
	}

	public Funcionario(String nome_func, int tel_func, String email_func, String endereco_func,
			String especialidade_func, Date data_admss_func, Date data_demss_func, Double salario_finc) {
		super();
		this.nome_func = nome_func;
		this.tel_func = tel_func;
		this.email_func = email_func;
		this.endereco_func = endereco_func;
		this.especialidade_func = especialidade_func;
		this.data_admss_func = data_admss_func;
		this.data_demss_func = data_demss_func;
		this.salario_finc = salario_finc;
	}

	public int getID_funcionario() {
		return ID_funcionario;
	}

	public void setID_funcionario(int iD_funcionario) {
		ID_funcionario = iD_funcionario;
	}

	public String getNome_func() {
		return nome_func;
	}

	public void setNome_func(String nome_func) {
		this.nome_func = nome_func;
	}

	public int getTel_func() {
		return tel_func;
	}

	public void setTel_func(int tel_func) {
		this.tel_func = tel_func;
	}

	public String getEmail_func() {
		return email_func;
	}

	public void setEmail_func(String email_func) {
		this.email_func = email_func;
	}

	public String getEndereco_func() {
		return endereco_func;
	}

	public void setEndereco_func(String endereco_func) {
		this.endereco_func = endereco_func;
	}

	public String getEspecialidade_func() {
		return especialidade_func;
	}

	public void setEspecialidade_func(String especialidade_func) {
		this.especialidade_func = especialidade_func;
	}

	public Date getData_admss_func() {
		return data_admss_func;
	}

	public void setData_admss_func(Date data_admss_func) {
		this.data_admss_func = data_admss_func;
	}

	public Date getData_demss_func() {
		return data_demss_func;
	}

	public void setData_demss_func(Date data_demss_func) {
		this.data_demss_func = data_demss_func;
	}

	public Double getSalario_finc() {
		return salario_finc;
	}

	public void setSalario_finc(Double salario_finc) {
		this.salario_finc = salario_finc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_funcionario;
		result = prime * result + ((data_admss_func == null) ? 0 : data_admss_func.hashCode());
		result = prime * result + ((data_demss_func == null) ? 0 : data_demss_func.hashCode());
		result = prime * result + ((email_func == null) ? 0 : email_func.hashCode());
		result = prime * result + ((endereco_func == null) ? 0 : endereco_func.hashCode());
		result = prime * result + ((especialidade_func == null) ? 0 : especialidade_func.hashCode());
		result = prime * result + ((nome_func == null) ? 0 : nome_func.hashCode());
		result = prime * result + ((salario_finc == null) ? 0 : salario_finc.hashCode());
		result = prime * result + tel_func;
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
		Funcionario other = (Funcionario) obj;
		if (ID_funcionario != other.ID_funcionario)
			return false;
		if (data_admss_func == null) {
			if (other.data_admss_func != null)
				return false;
		} else if (!data_admss_func.equals(other.data_admss_func))
			return false;
		if (data_demss_func == null) {
			if (other.data_demss_func != null)
				return false;
		} else if (!data_demss_func.equals(other.data_demss_func))
			return false;
		if (email_func == null) {
			if (other.email_func != null)
				return false;
		} else if (!email_func.equals(other.email_func))
			return false;
		if (endereco_func == null) {
			if (other.endereco_func != null)
				return false;
		} else if (!endereco_func.equals(other.endereco_func))
			return false;
		if (especialidade_func == null) {
			if (other.especialidade_func != null)
				return false;
		} else if (!especialidade_func.equals(other.especialidade_func))
			return false;
		if (nome_func == null) {
			if (other.nome_func != null)
				return false;
		} else if (!nome_func.equals(other.nome_func))
			return false;
		if (salario_finc == null) {
			if (other.salario_finc != null)
				return false;
		} else if (!salario_finc.equals(other.salario_finc))
			return false;
		if (tel_func != other.tel_func)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario ID_funcionario=" + ID_funcionario + ", nome_func=" + nome_func + ", tel_func=" + tel_func
				+ ", email_func=" + email_func + ", endereco_func=" + endereco_func + ", especialidade_func="
				+ especialidade_func + ", data_admss_func=" + data_admss_func + ", data_demss_func=" + data_demss_func
				+ ", salario_finc=" + salario_finc;
	};
	
	
	
}
