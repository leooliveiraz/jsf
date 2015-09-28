package controle;

import javax.faces.bean.ManagedBean;

public class Ola2Bean {

	private String nome="",sobrenome,nomeCompleto;
	
	public void dizerOla(){
		this.nomeCompleto = this.nome.toUpperCase()+" "+this.sobrenome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	
	
}
