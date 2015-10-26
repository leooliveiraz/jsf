package controle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;

import persistencia.DaoAtendimento;
import persistencia.DaoPaciente;
import persistencia.DaoTags;
import persistencia.DaoTagsAtendimento;
import util.HibernateUtil;
import entidades.Atendimento;
import entidades.Tags;
import entidades.TagsAtendimento;

@ManagedBean
@ViewScoped
public class AltaController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8675814324971323832L;
	private List<Atendimento> listaAtendimentos;
	private Atendimento atendimento;
	private TagsAtendimento tagsAtendimento;
	private Tags tags;
	private int cdAtendimento;
	private int cdPaciente;
	private Date dtAtendimento;
	private Date dtAlta;
	private String cdUsuarioSaida;
	private String cdUsuarioEntrada;
	Session session = HibernateUtil.getSession();

	


	public Atendimento getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	public List<Atendimento> getListaAtendimentos() {
		return listaAtendimentos;
	}
	public void setListaAtendimentos(List<Atendimento> listaAtendimentos) {
		this.listaAtendimentos = listaAtendimentos;
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
	@PostConstruct
	public void iniciar(){
		buscaAtendimentosSemAlta();
	}

	public void buscaAtendimentosSemAlta(){
		try{
			DaoAtendimento dao = new DaoAtendimento(Atendimento.class, session);
			this.listaAtendimentos = dao.buscaAtendimentosSemAlta(session);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void buscaTagAtendimento(){
		try{
			DaoTagsAtendimento dao = new DaoTagsAtendimento(TagsAtendimento.class, session);
			this.tagsAtendimento = dao.buscaPorAtendimento(session, this.cdAtendimento);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void buscaTag(){
		try{
			DaoTags dao = new DaoTags(Tags.class, session);
			this.tags = dao.buscaTagsFornecedor(session, this.tagsAtendimento.getCdTagFornecedor());

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void alta(){
		try{
			System.out.println("ALTA PACIENTE");
			this.atendimento.setDtAlta(new Date());
			this.atendimento.setCdUsuarioSaida(this.cdUsuarioSaida);
			DaoAtendimento daoAtendimento = new DaoAtendimento(Atendimento.class, session);
			session.beginTransaction();
			daoAtendimento.atualizar(atendimento);
			session.getTransaction().commit();

			System.out.println("BUSCA TAG DO ATENDIMENTO");
			DaoTagsAtendimento daoTagsAtendimento = new DaoTagsAtendimento(TagsAtendimento.class, this.session);
			this.tagsAtendimento = daoTagsAtendimento.buscaPorAtendimento(session, atendimento.getCdAtendimento());
			this.tagsAtendimento.setDtInativacao(new Date());
			this.tagsAtendimento.setSnAtivo("N");

			System.out.println("TAG LIBERADA");
			session.beginTransaction();
			daoTagsAtendimento.atualizar(this.tagsAtendimento);
			this.session.getTransaction().commit();
			
			
			DaoTags daoTags = new DaoTags(Tags.class, session);
			this.tags = daoTags.buscaTagsFornecedor(session, this.tagsAtendimento.getCdTagFornecedor());
			tags.setSnUso("N");
			session.beginTransaction();
			daoTags.atualizar(this.tags);
			this.session.getTransaction().commit();

			buscaAtendimentosSemAlta();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void darAlta(){
		System.out.println(this.cdUsuarioSaida);
		alta();
	}

	@PreDestroy
	public void fechaConexao(){
		session.close();
		System.out.println("conexão fechada");
	}
}
