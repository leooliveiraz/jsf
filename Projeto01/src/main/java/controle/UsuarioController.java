package controle;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import entidades.Usuario;
import persistencia.DaoUsuario;
import persistencia.GenericDao;
import util.HibernateUtil;
import util.Utilitarios;

@ManagedBean(name="usuarioController")
@RequestScoped
public class UsuarioController {

	private String cdUsuario;
	private String nmUsuario;
	private String cpf;
	private Date dtNascimento;
	private Date dtCadastro;
	private String senha;
	private List<Usuario> usuarios;

	public void cadastraUsuario(){
		try{

			Usuario usuario = new Usuario(this.getCdUsuario(), this.getNmUsuario(), this.getCpf(), this.getDtNascimento(), this.getDtNascimento(), Utilitarios.sha256(this.getSenha()));
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class,session);

			dao.salvar(usuario);

			session.getTransaction().commit();
			session.close();
		} 	catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
			fail("Erro ao Salvar");
		}

	}

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
			fail("Erro ao Salvar");
		}
	}


	public String realizaLogin(){
		try{

			Usuario usuario = new Usuario(this.getCdUsuario(), this.getNmUsuario(), this.getCpf(), this.getDtNascimento(), this.getDtNascimento(), this.getSenha());
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoUsuario dao = new DaoUsuario(Usuario.class, session);

			usuario = dao.buscaLogin(cdUsuario, senha);

			session.close();
			System.out.println(usuario.getCdUsuario()+" "+usuario.getNmUsuario()+" "+usuario.getCpf());
			
			this.cdUsuario = usuario.getCdUsuario();
				
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

	public List<Usuario> getUsuarios(){
		return usuarios;
	}

}
