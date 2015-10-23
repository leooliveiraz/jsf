package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "responsavel", catalog = "rfid_maternidade")
public class Responsavel implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8878432293855408609L;
	private int cdResponsavel;
	private String nmResponsavel;
	private String celular1;
	private String celular2;
	private String telefone;
	private String telefoneComercial;
	private String email;
	private String cpf;
	
	

	@Id
	@Column(name = "cd_responsavel", unique = true, nullable = false)
	public int getCdResponsavel() {
		return cdResponsavel;
	}
	public void setCdResponsavel(int cdResponsavel) {
		this.cdResponsavel = cdResponsavel;
	}
	

	@Column(name = "nm_responsavel", length = 100)
	public String getNmResponsavel() {
		return nmResponsavel;
	}
	public void setNmResponsavel(String nmResponsavel) {
		this.nmResponsavel = nmResponsavel;
	}
	
	@Column(name = "celular1", length = 20)
	public String getCelular1() {
		return celular1;
	}
	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}
	
	@Column(name = "celular2", length = 20)
	public String getCelular2() {
		return celular2;
	}
	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}
	
	@Column(name = "telefone", length = 20)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Column(name = "telefone_comercial", length = 20)
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	@Column(name = "email", length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "cpf", length = 11)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
