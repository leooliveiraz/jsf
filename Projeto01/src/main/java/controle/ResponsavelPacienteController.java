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
import persistencia.DaoResponsavelPaciente;
import util.HibernateUtil;
import entidades.Responsavel;
import entidades.ResponsavelPaciente;

@ManagedBean(name="responsavelPacienteController")
@ViewScoped
public class ResponsavelPacienteController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int responsavelCdResponsavel;
	private int pacienteCdPaciente;
	private int cdResponsavelPaciente;
	
	private List<ResponsavelPaciente> responsavelPacientes;
	private ResponsavelPaciente responsavelPaciente;
	

	public int getResponsavelCdResponsavel() {
		return responsavelCdResponsavel;
	}


	public void setResponsavelCdResponsavel(int responsavelCdResponsavel) {
		this.responsavelCdResponsavel = responsavelCdResponsavel;
	}


	public int getPacienteCdPaciente() {
		return pacienteCdPaciente;
	}


	public void setPacienteCdPaciente(int pacienteCdPaciente) {
		this.pacienteCdPaciente = pacienteCdPaciente;
	}


	public int getCdResponsavelPaciente() {
		return cdResponsavelPaciente;
	}


	public void setCdResponsavelPaciente(int cdResponsavelPaciente) {
		this.cdResponsavelPaciente = cdResponsavelPaciente;
	}


	public List<ResponsavelPaciente> getResponsavelPacientes() {
		return responsavelPacientes;
	}


	public void setResponsavelPacientes(List<ResponsavelPaciente> responsavelPacientes) {
		this.responsavelPacientes = responsavelPacientes;
	}


	public ResponsavelPaciente getResponsavelPaciente() {
		return responsavelPaciente;
	}


	public void setResponsavelPaciente(ResponsavelPaciente responsavelPaciente) {
		this.responsavelPaciente = responsavelPaciente;
	}


	public String salvar() {
		try{
			ResponsavelPaciente responsavelPaciente = new ResponsavelPaciente(this.pacienteCdPaciente, this.responsavelCdResponsavel);
			
			Session session = HibernateUtil.getSession();
			DaoResponsavelPaciente dao = new DaoResponsavelPaciente(ResponsavelPaciente.class, session);
			session.beginTransaction();
			dao.salvar(responsavelPaciente);
			session.getTransaction().commit();
			session.close();	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Vinculado com sucesso."));
			return "vinculoresponsaveis.xhtml";
		}catch(Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro:"+e.getMessage()));
			return "vinculoresponsaveis.xhtml";		
		}
	}
	

	public void atualizar(Responsavel responsavel) {
		try{
						
			Session session = HibernateUtil.getSession();
			DaoResponsavelPaciente dao = new DaoResponsavelPaciente(ResponsavelPaciente.class, session);
			session.beginTransaction();
			dao.atualizar(responsavelPaciente);
			session.getTransaction().commit();
			session.close();			
			
		}catch(Exception e){
			e.printStackTrace();			
		}
	}
	
	@PostConstruct
	public void buscaTodos() {
		try{
						
			Session session = HibernateUtil.getSession();
			DaoResponsavelPaciente dao = new DaoResponsavelPaciente(ResponsavelPaciente.class, session);
			session.beginTransaction();
			responsavelPacientes = dao.buscaTodos();

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

}
