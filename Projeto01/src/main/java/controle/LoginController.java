package controle;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import entidades.Usuario;
import persistencia.DaoUsuario;
import util.HibernateUtil;

@ManagedBean(name="loginController")
@SessionScoped
public class LoginController {

	private String cdUsuario;
	private String nmUsuario;
	private String cpf;
	private Date dtNascimento;
	private Date dtCadastro;
	private String senha;


	public String realizaLogin(){
		try{

			Usuario usuario = new Usuario();
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoUsuario dao = new DaoUsuario(Usuario.class, session);

			usuario = dao.buscaLogin(cdUsuario, senha);

			session.close();
			System.out.println(usuario.getCdUsuario()+" "+usuario.getNmUsuario()+" "+usuario.getCpf());
			
			this.cdUsuario = usuario.getCdUsuario();
			this.nmUsuario = usuario.getNmUsuario();
			this.cpf = usuario.getNmUsuario();
			this.dtNascimento = usuario.getDtNascimento();
			this.dtCadastro = usuario.getDtCadastro();
			this.senha = usuario.getSenha();
				
			return "home.xhtml";
			

		} 	catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Login não Efetuado.",
					"Usuario não encontrado.");
			context.addMessage(null, mensagem);	

			return null;
		}
	}	




	public String getCdUsuario() {
		return cdUsuario;
	}


	public void setCdUsuario(String cdUsuario) {
		this.cdUsuario = cdUsuario;
	}


	public String getNmUsuario() {
		return nmUsuario;
	}


	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Date getDtNascimento() {
		return dtNascimento;
	}


	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}


	public Date getDtCadastro() {
		return dtCadastro;
	}


	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

}
