package controle;

import static org.junit.Assert.fail;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.primefaces.event.RowEditEvent;

import persistencia.DaoResponsavel;
import util.HibernateUtil;
import entidades.Responsavel;

@ManagedBean
@ViewScoped
public class ResponsavelController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cdResponsavel;
	private String nmResponsavel;
	private String celular1;
	private String celular2;
	private String telefone;
	private String telefoneComercial;
	private String email;
	private String cpf;
	private List<Responsavel> listaResponsavel;
	
	
	
	public List<Responsavel> getListaResponsavel() {
		return listaResponsavel;
	}
	public void setListaResponsavel(List<Responsavel> listaResponsavel) {
		this.listaResponsavel = listaResponsavel;
	}
	public int getCdResponsavel() {
		return cdResponsavel;
	}
	public void setCdResponsavel(int cdResponsavel) {
		this.cdResponsavel = cdResponsavel;
	}
	public String getNmResponsavel() {
		return nmResponsavel;
	}
	public void setNmResponsavel(String nmResponsavel) {
		this.nmResponsavel = nmResponsavel;
	}
	public String getCelular1() {
		return celular1;
	}
	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}
	public String getCelular2() {
		return celular2;
	}
	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	public String salvar() {
		try{
			Responsavel responsavel = new Responsavel();
			responsavel.setNmResponsavel(this.nmResponsavel);
			responsavel.setCelular1(this.celular1);
			responsavel.setCelular2(this.celular2);
			responsavel.setTelefone(this.telefone);
			responsavel.setTelefoneComercial(this.telefoneComercial);
			responsavel.setEmail(this.email);
			responsavel.setCpf(this.cpf);
			
			Session session = HibernateUtil.getSession();
			DaoResponsavel dao = new DaoResponsavel(Responsavel.class, session);
			session.beginTransaction();
			dao.salvar(responsavel);
			session.getTransaction().commit();
			session.close();	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastrado com sucesso."));
			return "tabelaresponsavel.xhtml";
		}catch(Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro:"+e.getMessage()));
			return "tabelaresponsavel.xhtml";		
		}
	}
	

	public void atualizar(Responsavel responsavel) {
		try{
						
			Session session = HibernateUtil.getSession();
			DaoResponsavel dao = new DaoResponsavel(Responsavel.class, session);
			session.beginTransaction();
			dao.atualizar(responsavel);
			session.getTransaction().commit();
			session.close();			
			
		}catch(Exception e){
			e.printStackTrace();			
		}
	}
	
	public void buscaTodos() {
		try{
						
			Session session = HibernateUtil.getSession();
			DaoResponsavel dao = new DaoResponsavel(Responsavel.class, session);
			session.beginTransaction();
			listaResponsavel = dao.buscaTodos();
			for(int i=0;i<listaResponsavel.size();i++){
				System.out.println(listaResponsavel.get(i).getNmResponsavel());
			}
			session.close();			
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Not yet implemented");			
		}
	}
	
	public void onRowEdit(RowEditEvent event) {
		atualizar(((Responsavel) event.getObject()));
        FacesMessage msg = new FacesMessage("Registro editado", ((Responsavel) event.getObject()).getCdResponsavel()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição cancelada", ((Responsavel) event.getObject()).getCdResponsavel()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
	@PostConstruct
    public void iniciar(){
    	buscaTodos();
    }
}
