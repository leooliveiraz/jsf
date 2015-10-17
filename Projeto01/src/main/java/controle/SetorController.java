package controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.primefaces.event.RowEditEvent;

import persistencia.DaoSetor;
import util.HibernateUtil;
import entidades.Setor;
import entidades.Usuario;

@ManagedBean
@ViewScoped
public class SetorController implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cdSetor;
	private String nmSetor;
	private String snAtivo;
	private List<Setor> lista;
	private Setor setor;
	public int getCdSetor() {
		return cdSetor;
	}
	public void setCdSetor(int cdSetor) {
		this.cdSetor = cdSetor;
	}
	public String getNmSetor() {
		return nmSetor;
	}
	public void setNmSetor(String nmSetor) {
		this.nmSetor = nmSetor;
	}
	public String getSnAtivo() {
		return snAtivo;
	}
	public void setSnAtivo(String snAtivo) {
		this.snAtivo = snAtivo;
	}
	public List<Setor> getLista() {
		return lista;
	}
	public void setLista(List<Setor> lista) {
		this.lista = lista;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
		this.nmSetor = setor.getNmSetor().toUpperCase();
		this.snAtivo = setor.getSnAtivo().toUpperCase();
	}
	
	public String cadastraSetor(){
		try{

			Setor setor = new Setor(this.cdSetor,this.nmSetor.toUpperCase(),this.snAtivo.toUpperCase());
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoSetor dao = new DaoSetor(Setor.class,session);
			dao.salvar(setor);
			session.getTransaction().commit();
			session.close();

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastrado com sucesso."));
			return "tabelasetor.xhtml";

		} 	catch(Exception e){
			System.out.println(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro:"+e.getMessage()));
			//e.printStackTrace();

			return "tabelasetor.xhtml";
		}

	}
	public String alteraSetor(Setor setor){
		try{

			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoSetor dao = new DaoSetor(Setor.class,session);
			dao.atualizar(setor);
			session.getTransaction().commit();
			session.close();

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastrado com sucesso."));
			return "tabelasetor.xhtml";

		} 	catch(Exception e){
			System.out.println(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro:"+e.getMessage()));
			//e.printStackTrace();

			return "tabelasetor.xhtml";
		}

	}
	
	@PostConstruct
	public void consultaSetor(){
		try{

			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoSetor dao = new DaoSetor(Setor.class,session);

			this.lista = dao.buscaTodos();

			session.getTransaction().commit();
			session.close();
			
		} 	catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
		}
	}
	
	public void onRowEdit(RowEditEvent event) {
		alteraSetor(((Setor) event.getObject()));
        FacesMessage msg = new FacesMessage("Registro editado", ((Setor) event.getObject()).getCdSetor()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição cancelada", ((Setor) event.getObject()).getCdSetor()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }     
}
