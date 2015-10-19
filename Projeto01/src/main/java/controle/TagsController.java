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

import persistencia.DaoTags;
import util.HibernateUtil;
import entidades.Setor;
import entidades.Tags;

@ManagedBean
@ViewScoped
public class TagsController  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cdTag;
	private String cdTagFornecedor;
	private String snAtivo;
	private String snUso;
	private List<Tags> lista;
	public int getCdTag() {
		return cdTag;
	}
	public void setCdTag(int cdTag) {
		this.cdTag = cdTag;
	}
	public String getCdTagFornecedor() {
		return cdTagFornecedor;
	}
	public void setCdTagFornecedor(String cdTagFornecedor) {
		this.cdTagFornecedor = cdTagFornecedor;
	}
	public String getSnAtivo() {
		return snAtivo;
	}
	public void setSnAtivo(String snAtivo) {
		this.snAtivo = snAtivo;
	}
	public String getSnUso() {
		return snUso;
	}
	public void setSnUso(String snUso) {
		this.snUso = snUso;
	}
	public List<Tags> getLista() {
		return lista;
	}
	public void setLista(List<Tags> lista) {
		this.lista = lista;
	}
	
	public String cadastraTag(){
		try{
			Tags tag = new Tags(this.cdTagFornecedor,this.snAtivo,this.snUso);
			Session session = new HibernateUtil().getSession();
			DaoTags dao = new DaoTags(Tags.class, session);
			session.beginTransaction();
			
			dao.salvar(tag);
			session.getTransaction().commit();
			session.close();			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastrado com sucesso."));
			
			return "tabelatags.xhtml";
		}catch(Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro:"+e.getMessage()));
			return "tabelatags.xhtml";
		}
		
	}
	
	public String alteraTag(Tags tag){
		try{
			Session session = new HibernateUtil().getSession();
			DaoTags dao = new DaoTags(Tags.class, session);
			session.beginTransaction();
			
			dao.atualizar(tag);
			session.getTransaction().commit();
			session.close();			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastrado com sucesso."));
			
			return "tabelatags.xhtml";
		}catch(Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro:"+e.getMessage()));
			return "tabelatags.xhtml";
		}
		
	}
	
	@PostConstruct
	public void buscaTags(){
		try{
			Session session = new HibernateUtil().getSession();
			DaoTags dao = new DaoTags(Tags.class, session);			
			
			lista = dao.buscaTodos();
			session.close();			

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void onRowEdit(RowEditEvent event) {
		alteraTag((Tags) event.getObject());
        FacesMessage msg = new FacesMessage("Registro editado", ((Tags) event.getObject()).getCdTag()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição cancelada", ((Tags) event.getObject()).getCdTag()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }   
	
	
}
