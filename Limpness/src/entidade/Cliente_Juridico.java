package entidade;

public class Cliente_Juridico {

	private int ID_cli_juridico;
	private String nome_cli_j;
	private int tel_cli_j;
	private String email_cli_j;
	private String cep_cli_j;
	private Double cnpj_cli_j;
	private String categoria_cli_j;
	
	
	public Cliente_Juridico() {
		
	}

	
	public Cliente_Juridico(String nome_cli_j, int tel_cli_j, String email_cli_j, String cep_cli_j, Double cnpj_cli_j,
			String categoria_cli_j) {
		super();
		this.nome_cli_j = nome_cli_j;
		this.tel_cli_j = tel_cli_j;
		this.email_cli_j = email_cli_j;
		this.cep_cli_j = cep_cli_j;
		this.cnpj_cli_j = cnpj_cli_j;
		this.categoria_cli_j = categoria_cli_j;
	}


	public Cliente_Juridico(int iD_cli_juridico, String nome_cli_j, int tel_cli_j, String email_cli_j, String cep_cli_j,
			Double cnpj_cli_j, String categoria_cli_j) {
		super();
		ID_cli_juridico = iD_cli_juridico;
		this.nome_cli_j = nome_cli_j;
		this.tel_cli_j = tel_cli_j;
		this.email_cli_j = email_cli_j;
		this.cep_cli_j = cep_cli_j;
		this.cnpj_cli_j = cnpj_cli_j;
		this.categoria_cli_j = categoria_cli_j;
	}


	public int getID_cli_juridico() {
		return ID_cli_juridico;
	}


	public void setID_cli_juridico(int iD_cli_juridico) {
		ID_cli_juridico = iD_cli_juridico;
	}


	public String getNome_cli_j() {
		return nome_cli_j;
	}


	public void setNome_cli_j(String nome_cli_j) {
		this.nome_cli_j = nome_cli_j;
	}


	public int getTel_cli_j() {
		return tel_cli_j;
	}


	public void setTel_cli_j(int tel_cli_j) {
		this.tel_cli_j = tel_cli_j;
	}


	public String getEmail_cli_j() {
		return email_cli_j;
	}


	public void setEmail_cli_j(String email_cli_j) {
		this.email_cli_j = email_cli_j;
	}


	public String getCep_cli_j() {
		return cep_cli_j;
	}


	public void setCep_cli_j(String cep_cli_j) {
		this.cep_cli_j = cep_cli_j;
	}


	public Double getCnpj_cli_j() {
		return cnpj_cli_j;
	}


	public void setCnpj_cli_j(Double cnpj_cli_j) {
		this.cnpj_cli_j = cnpj_cli_j;
	}


	public String getCategoria_cli_j() {
		return categoria_cli_j;
	}


	public void setCategoria_cli_j(String categoria_cli_j) {
		this.categoria_cli_j = categoria_cli_j;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_cli_juridico;
		result = prime * result + ((categoria_cli_j == null) ? 0 : categoria_cli_j.hashCode());
		result = prime * result + ((cep_cli_j == null) ? 0 : cep_cli_j.hashCode());
		result = prime * result + ((cnpj_cli_j == null) ? 0 : cnpj_cli_j.hashCode());
		result = prime * result + ((email_cli_j == null) ? 0 : email_cli_j.hashCode());
		result = prime * result + ((nome_cli_j == null) ? 0 : nome_cli_j.hashCode());
		result = prime * result + tel_cli_j;
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
		Cliente_Juridico other = (Cliente_Juridico) obj;
		if (ID_cli_juridico != other.ID_cli_juridico)
			return false;
		if (categoria_cli_j == null) {
			if (other.categoria_cli_j != null)
				return false;
		} else if (!categoria_cli_j.equals(other.categoria_cli_j))
			return false;
		if (cep_cli_j == null) {
			if (other.cep_cli_j != null)
				return false;
		} else if (!cep_cli_j.equals(other.cep_cli_j))
			return false;
		if (cnpj_cli_j == null) {
			if (other.cnpj_cli_j != null)
				return false;
		} else if (!cnpj_cli_j.equals(other.cnpj_cli_j))
			return false;
		if (email_cli_j == null) {
			if (other.email_cli_j != null)
				return false;
		} else if (!email_cli_j.equals(other.email_cli_j))
			return false;
		if (nome_cli_j == null) {
			if (other.nome_cli_j != null)
				return false;
		} else if (!nome_cli_j.equals(other.nome_cli_j))
			return false;
		if (tel_cli_j != other.tel_cli_j)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Cliente_Juridico [ID_cli_juridico=" + ID_cli_juridico + ", nome_cli_j=" + nome_cli_j + ", tel_cli_j="
				+ tel_cli_j + ", email_cli_j=" + email_cli_j + ", cep_cli_j=" + cep_cli_j + ", cnpj_cli_j=" + cnpj_cli_j
				+ ", categoria_cli_j=" + categoria_cli_j + "]";
	}
	
	
}
