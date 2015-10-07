package controle;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import entidades.Usuario;
import persistencia.DaoUsuario;
import persistencia.GenericDao;
import util.HibernateUtil;
import util.Utilitarios;

@ManagedBean(name="usuarioController")
@ViewScoped
public class UsuarioController {

	private String cdUsuario;
	private String nmUsuario;
	private String cpf;
	private Date dtNascimento;
	private Date dtCadastro;
	private String senha;
	private List<Usuario> usuarios;
	
	
	public String cadastraUsuario(){
		try{

			Usuario usuario = new Usuario(this.getCdUsuario(), this.getNmUsuario(), this.getCpf(), this.getDtNascimento(), this.getDtNascimento(), Utilitarios.sha256(this.getSenha()));
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class,session);
			dao.salvar(usuario);
			session.getTransaction().commit();
			session.close();
			
			System.out.println("OK");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
			return "tabelausuario.xhtml";
			
		} 	catch(Exception e){
			System.out.println("NÃO");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces N Rocks."));
			//e.printStackTrace();

			return null;
		}

	}
	@PostConstruct
	public void consultaUsuario(){
		try{

			Usuario usuario = new Usuario(this.getCdUsuario(), this.getNmUsuario(), this.getCpf(), this.getDtNascimento(), this.getDtNascimento(), this.getSenha());
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class,session);

			this.usuarios = dao.buscaTodos();

			session.getTransaction().commit();
			session.close();
			for (int i = 0;i<usuarios.size();i++){
				System.out.println(usuarios.get(i).getCdUsuario()+" "+usuarios.get(i).getNmUsuario()+" "+usuarios.get(i).getCpf());
			}
		} 	catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
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

	public List<Usuario> getUsuarios(){
		return usuarios;
	}

}
