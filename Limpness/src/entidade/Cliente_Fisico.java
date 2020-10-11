package entidade;

public class Cliente_Fisico {

			private int ID_cli_fisico;
			private String nome_cli_f;
			private int tel_cli_f;
			private int cpf_func;
			private String email_cli_f;
			private String cep_cli_f;
			
			public Cliente_Fisico() {
				
			}
					
			public Cliente_Fisico(int iD_cli_fisico, String nome_cli_f, int tel_cli_f, int cpf_func, String email_cli_f,
					String cep_cli_f) {
				super();
				ID_cli_fisico = iD_cli_fisico;
				this.nome_cli_f = nome_cli_f;
				this.tel_cli_f = tel_cli_f;
				this.cpf_func = cpf_func;
				this.email_cli_f = email_cli_f;
				this.cep_cli_f = cep_cli_f;
			}


			public Cliente_Fisico(String nome_cli_f, int tel_cli_f, int cpf_func, String email_cli_f,
					String cep_cli_f) {
				super();
				this.nome_cli_f = nome_cli_f;
				this.tel_cli_f = tel_cli_f;
				this.cpf_func = cpf_func;
				this.email_cli_f = email_cli_f;
				this.cep_cli_f = cep_cli_f;
			}


			public int getID_cli_fisico() {
				return ID_cli_fisico;
			}


			public void setID_cli_fisico(int iD_cli_fisico) {
				ID_cli_fisico = iD_cli_fisico;
			}


			public String getNome_cli_f() {
				return nome_cli_f;
			}


			public void setNome_cli_f(String nome_cli_f) {
				this.nome_cli_f = nome_cli_f;
			}


			public int getTel_cli_f() {
				return tel_cli_f;
			}


			public void setTel_cli_f(int tel_cli_f) {
				this.tel_cli_f = tel_cli_f;
			}


			public int getCpf_func() {
				return cpf_func;
			}


			public void setCpf_func(int cpf_func) {
				this.cpf_func = cpf_func;
			}


			public String getEmail_cli_f() {
				return email_cli_f;
			}


			public void setEmail_cli_f(String email_cli_f) {
				this.email_cli_f = email_cli_f;
			}


			public String getCep_cli_f() {
				return cep_cli_f;
			}


			public void setCep_cli_f(String cep_cli_f) {
				this.cep_cli_f = cep_cli_f;
			}


			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ID_cli_fisico;
				result = prime * result + ((cep_cli_f == null) ? 0 : cep_cli_f.hashCode());
				result = prime * result + cpf_func;
				result = prime * result + ((email_cli_f == null) ? 0 : email_cli_f.hashCode());
				result = prime * result + ((nome_cli_f == null) ? 0 : nome_cli_f.hashCode());
				result = prime * result + tel_cli_f;
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
				Cliente_Fisico other = (Cliente_Fisico) obj;
				if (ID_cli_fisico != other.ID_cli_fisico)
					return false;
				if (cep_cli_f == null) {
					if (other.cep_cli_f != null)
						return false;
				} else if (!cep_cli_f.equals(other.cep_cli_f))
					return false;
				if (cpf_func != other.cpf_func)
					return false;
				if (email_cli_f == null) {
					if (other.email_cli_f != null)
						return false;
				} else if (!email_cli_f.equals(other.email_cli_f))
					return false;
				if (nome_cli_f == null) {
					if (other.nome_cli_f != null)
						return false;
				} else if (!nome_cli_f.equals(other.nome_cli_f))
					return false;
				if (tel_cli_f != other.tel_cli_f)
					return false;
				return true;
			}


			@Override
			public String toString() {
				return "Cliente_Fisico ID_cli_fisico=" + ID_cli_fisico + ", nome_cli_f=" + nome_cli_f + ", tel_cli_f="
						+ tel_cli_f + ", cpf_func=" + cpf_func + ", email_cli_f=" + email_cli_f + ", cep_cli_f="
						+ cep_cli_f;
			}
	
			
			
}
