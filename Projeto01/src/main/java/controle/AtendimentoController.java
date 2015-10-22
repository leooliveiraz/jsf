package controle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import entidades.Atendimento;
import entidades.Paciente;
import entidades.Usuario;
import persistencia.DaoAtendimento;
import persistencia.DaoPaciente;
import persistencia.GenericDao;
import util.HibernateUtil;

@ManagedBean(name="atendimentoController")
@ViewScoped
public class AtendimentoController implements Serializable {
	private Atendimento atendimento;
	private List<Atendimento> lista;
	private List<Paciente> listaPaciente;
	
	private static final long serialVersionUID = 1L;
	
	private int cdAtendimento;
	private int cdPaciente;
	private int nmPaciente;
	private Date dtAtendimento;
	private Date dtAlta;
	private String cdUsuarioSaida;
	private String cdUsuarioEntrada;	
	
	
	
	public int getNmPaciente() {
		return nmPaciente;
	}

	public void setNmPaciente(int nmPaciente) {
		this.nmPaciente = nmPaciente;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public List<Atendimento> getLista() {
		return lista;
	}

	public void setLista(List<Atendimento> lista) {
		this.lista = lista;
	}

	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}

	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}

	public int getCdAtendimento() {
		return cdAtendimento;
	}

	public void setCdAtendimento(int cdAtendimento) {
		this.cdAtendimento = cdAtendimento;
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

	public Date getDtAlta() {
		return dtAlta;
	}

	public void setDtAlta(Date dtAlta) {
		this.dtAlta = dtAlta;
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

		public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@PostConstruct
	public void iniciar(){
		buscaPacientes();
	}	
	
	public String cadastraAtendimento(){
		Atendimento atendimento = new Atendimento(this.cdPaciente, new Date(),this.cdUsuarioEntrada);
		Session session = new HibernateUtil().getSession();
		DaoAtendimento dao = new DaoAtendimento(Atendimento.class, session);
		session.beginTransaction();
		dao.salvar(atendimento);
		session.getTransaction().commit();
		session.close();
		
		return "home.xhtml";
	}
	
	
	public void buscaPacientes(){		
		try{

			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoPaciente dao = new DaoPaciente(Paciente.class,session);
			this.listaPaciente = dao.buscaTodos();
			session.close();
			
			for (int i = 0;i<listaPaciente.size();i++){
				System.out.println(listaPaciente.get(i).getCdPaciente()+" "+listaPaciente.get(i).getNmPaciente()+" "+listaPaciente.get(i).getCpf());
			}
		} 	catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
		}
		
	}
	
}
