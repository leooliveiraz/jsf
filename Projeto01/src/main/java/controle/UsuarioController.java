package controle;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import entidades.Usuario;
import persistencia.DaoUsuario;
import persistencia.GenericDao;
import util.HibernateUtil;
import util.Utilitarios;

@ManagedBean(name="usuarioController")
@ViewScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String cdUsuario;
	private String nmUsuario;
	private String cpf;
	private Date dtNascimento;
	private Date dtCadastro;
	private String senha;
	private List<Usuario> usuarios;
	private Usuario usuario;


	public UsuarioController()  {
		// TODO Auto-generated constructor stub
	}
	
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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastrado com sucesso."));
			return "tabelausuario.xhtml";

		} 	catch(Exception e){
			System.out.println(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro:"+e.getMessage()));
			//e.printStackTrace();

			return "tabelausuario.xhtml";
		}

	}

	public void alteraUsuario(Usuario usuario){
		try{

			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			usuario.getCdUsuario().toUpperCase();
			usuario.getNmUsuario().toUpperCase();
			usuario.getCpf().toUpperCase();
			DaoUsuario dao = new DaoUsuario(Usuario.class,session);
			dao.atualizar(usuario);
			session.getTransaction().commit();
			session.close();

			System.out.println("OK");


		} 	catch(Exception e){
			System.out.println(e.getMessage());
			
		}

	}
	
	public void chooseCar() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("escolhapaciente", options, null);
    }
	
	public void onCarChosen(SelectEvent event) {
        Usuario car = (Usuario) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", "Id:" + car.getCdUsuario());
         
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void selectUserFromDialog(Usuario car) {
        RequestContext.getCurrentInstance().closeDialog(car);
    }

	@PostConstruct
	public void consultaUsuario(){
		try{

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		this.cdUsuario = usuario.getCdUsuario();
		this.nmUsuario = usuario.getNmUsuario();
		this.cpf = usuario.getCpf();
		this.dtCadastro = usuario.getDtCadastro();
		this.dtNascimento = usuario.getDtNascimento();
		this.senha = usuario.getSenha();
	}

	public void onRowEdit(RowEditEvent event) {
		alteraUsuario(((Usuario) event.getObject()));
        FacesMessage msg = new FacesMessage("Registro editado", ((Usuario) event.getObject()).getCdUsuario());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição cancelada", ((Usuario) event.getObject()).getCdUsuario());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }     
	
}
