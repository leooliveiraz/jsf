package controle;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.primefaces.event.RowEditEvent;

import entidades.Atendimento;
import persistencia.DaoAtendimento;
import persistencia.GenericDao;
import util.HibernateUtil;

@ManagedBean(name="atendimentoController")
@ViewScoped
public class AtendimentoController {

	public int getCdAtendimento() {
		return cdAtendimento;
	}

	public void setCdAtendimento(int cdAtendimento) {
		this.cdAtendimento = cdAtendimento;
	}

	public int getCdAutorizacaoSaida() {
		return cdAutorizacaoSaida;
	}

	public void setCdAutorizacaoSaida(int cdAutorizacaoSaida) {
		this.cdAutorizacaoSaida = cdAutorizacaoSaida;
	}

	public int getCdPaciente() {
		return cdPaciente;
	}

	public void setCdPaciente(int cdPaciente) {
		this.cdPaciente = cdPaciente;
	}

	public Date getDtAtendimento() {
		return dtAtendimento;
	}

	public void setDtAtendimento(Date dtAtendimento) {
		this.dtAtendimento = dtAtendimento;
	}

	public Date getDtAutorizacaoSaida() {
		return dtAutorizacaoSaida;
	}

	public void setDtAutorizacaoSaida(Date dtAutorizacaoSaida) {
		this.dtAutorizacaoSaida = dtAutorizacaoSaida;
	}

	public String getCdUsuarioSaida() {
		return cdUsuarioSaida;
	}

	public void setCdUsuarioSaida(String cdUsuarioSaida) {
		this.cdUsuarioSaida = cdUsuarioSaida;
	}

	public String getCdUsuarioEntrada() {
		return cdUsuarioEntrada;
	}

	public void setCdUsuarioEntrada(String cdUsuarioEntrada) {
		this.cdUsuarioEntrada = cdUsuarioEntrada;
	}

	public String getUsuarioCdUsuario() {
		return usuarioCdUsuario;
	}

	public void setUsuarioCdUsuario(String usuarioCdUsuario) {
		this.usuarioCdUsuario = usuarioCdUsuario;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	private Atendimento atendimento;
	private List<Atendimento> atendimentos;
	
	private int cdAtendimento;
	private int cdAutorizacaoSaida;
	private int cdPaciente;
	private Date dtAtendimento;
	private Date dtAutorizacaoSaida;
	private String cdUsuarioSaida;
	private String cdUsuarioEntrada;
	private String usuarioCdUsuario;

	public AtendimentoController(){

	}
	
	public String cadastraAtendimento(){
		try {
			Atendimento atendimento = new Atendimento(this.cdAtendimento,);
	
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			
			GenericDao<Atendimento> dao = new GenericDao<Atendimento>(Atendimento.class,session);
			dao.salvar(atendimento);
			session.getTransaction().commit();
			session.close();
			
			return "tabelaatendimento.xhtml";
			
		} catch (Exception e){
			System.out.println(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro:"+e.getMessage()));
			
			return "tabelaatendimento.xhtml";
		}

	}
	
	public void alteraAtendimento(Atendimento atendimento){
		try{

			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			
			atendimento.getDtAtendimento();
			atendimento.getCdPaciente();
			atendimento.getCdUsuarioEntrada().toUpperCase();
			
			DaoAtendimento dao = new DaoAtendimento(Atendimento.class,session);
			dao.atualizar(atendimento);
			session.getTransaction().commit();
			session.close();

			System.out.println("OK");


		} 	catch(Exception e){
			System.out.println(e.getMessage());
			
		}

	}
	
	public List<Atendimento> getAtendimentos(){
		return atendimentos;
	}
	
	public Atendimento getAtendimento(){
		return atendimento;
	}
	
	public void setAtendimento(Atendimento atendimento){
	      this.atendimento = atendimento;
		  this.cdAtendimento = this.atendimento.getCdAtendimento();
		  this.cdAutorizacaoSaida = this.atendimento.getCdAutorizacaoSaida();
		  this.cdPaciente = this.atendimento.getCdPaciente();
		  this.dtAtendimento = this.atendimento.getDtAtendimento();
		  this.dtAutorizacaoSaida = this.atendimento.getDtAutorizacaoSaida();
		  this.cdUsuarioSaida = this.atendimento.getCdUsuarioSaida();
		  this.cdUsuarioEntrada = this.atendimento.getCdUsuarioEntrada();
		  this.usuarioCdUsuario = this.atendimento.getUsuarioCdUsuario();
	}
	
	public void onRowEdit(RowEditEvent event) {
		alteraAtendimento(((Atendimento) event.getObject()));
        FacesMessage msg = new FacesMessage("Registro editado", ((Atendimento) event.getObject()).getCdUsuarioSaida());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição cancelada", ((Atendimento) event.getObject()).getCdUsuarioSaida());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }    
}
