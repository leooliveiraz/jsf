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
import entidades.Tags;
import entidades.TagsAtendimento;
import entidades.Usuario;
import persistencia.DaoAtendimento;
import persistencia.DaoPaciente;
import persistencia.DaoTags;
import persistencia.DaoTagsAtendimento;
import persistencia.GenericDao;
import util.HibernateUtil;

@ManagedBean(name="atendimentoController")
@ViewScoped
public class AtendimentoController implements Serializable {

	private List<Atendimento> lista;
	private List<Paciente> listaPaciente;
	private List<Tags> listaTags;

	private static final long serialVersionUID = 1L;

	private int cdAtendimento;
	private int cdPaciente;
	private String nmPaciente;
	private Date dtAtendimento;
	private Date dtAlta;
	private String cdUsuarioSaida;
	private String cdUsuarioEntrada;	
	private Atendimento atendimento;

	private String paciente_cpf;
	private Date paciente_dtNascimento;
	private String paciente_sexo;
	private String paciente_nmMae;
	private String paciente_nmPai;
	private String paciente_cep;
	private String paciente_logradouro;
	private Integer paciente_numero;
	private String paciente_complemento;
	private String paciente_cidade;
	private String paciente_uf;
	private String paciente_observacao;


	private String tag_vinculada;
	private int cd_tag;


	public int getCd_tag() {
		return cd_tag;
	}

	public void setCd_tag(int cd_tag) {
		this.cd_tag = cd_tag;
	}

	public String getTag_vinculada() {
		return tag_vinculada;
	}

	public void setTag_vinculada(String tag_vinculada) {
		this.tag_vinculada = tag_vinculada;
	}

	public String getPaciente_cpf() {
		return paciente_cpf;
	}

	public void setPaciente_cpf(String paciente_cpf) {
		this.paciente_cpf = paciente_cpf;
	}

	public Date getPaciente_dtNascimento() {
		return paciente_dtNascimento;
	}

	public void setPaciente_dtNascimento(Date paciente_dtNascimento) {
		this.paciente_dtNascimento = paciente_dtNascimento;
	}

	public String getPaciente_sexo() {
		return paciente_sexo;
	}

	public void setPaciente_sexo(String paciente_sexo) {
		this.paciente_sexo = paciente_sexo;
	}

	public String getPaciente_nmMae() {
		return paciente_nmMae;
	}

	public void setPaciente_nmMae(String paciente_nmMae) {
		this.paciente_nmMae = paciente_nmMae;
	}

	public String getPaciente_nmPai() {
		return paciente_nmPai;
	}

	public void setPaciente_nmPai(String paciente_nmPai) {
		this.paciente_nmPai = paciente_nmPai;
	}

	public String getPaciente_cep() {
		return paciente_cep;
	}

	public void setPaciente_cep(String paciente_cep) {
		this.paciente_cep = paciente_cep;
	}

	public String getPaciente_logradouro() {
		return paciente_logradouro;
	}

	public void setPaciente_logradouro(String paciente_logradouro) {
		this.paciente_logradouro = paciente_logradouro;
	}

	public Integer getPaciente_numero() {
		return paciente_numero;
	}

	public void setPaciente_numero(Integer paciente_numero) {
		this.paciente_numero = paciente_numero;
	}

	public String getPaciente_complemento() {
		return paciente_complemento;
	}

	public void setPaciente_complemento(String paciente_complemento) {
		this.paciente_complemento = paciente_complemento;
	}

	public String getPaciente_cidade() {
		return paciente_cidade;
	}

	public void setPaciente_cidade(String paciente_cidade) {
		this.paciente_cidade = paciente_cidade;
	}

	public String getPaciente_uf() {
		return paciente_uf;
	}

	public void setPaciente_uf(String paciente_uf) {
		this.paciente_uf = paciente_uf;
	}

	public String getPaciente_observacao() {
		return paciente_observacao;
	}

	public void setPaciente_observacao(String paciente_observacao) {
		this.paciente_observacao = paciente_observacao;
	}

	public String getNmPaciente() {
		return nmPaciente;
	}

	public void setNmPaciente(String nmPaciente) {
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


	public List<Tags> getListaTags() {
		return listaTags;
	}

	public void setListaTags(List<Tags> listaTags) {
		this.listaTags = listaTags;
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
		buscaTagsVinculo();
		this.dtAtendimento = new Date();
	}	



	public void cadastraAtendimento(){
		try{
			System.out.println(this.cdUsuarioEntrada);
			this.dtAtendimento = new Date();
			if(this.cdPaciente==0 || this.cd_tag == 0){
				System.out.println(this.cdPaciente);
				System.out.println(this.cd_tag);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Não Foi possível cadastrar o Atendimento, por favor informe o paciente e a tag"));

			}else{
				System.out.println(this.cdPaciente);
				System.out.println(this.cd_tag);
				Atendimento atendimento = new Atendimento(this.cdPaciente, new Date(),this.cdUsuarioEntrada);
				Session session = new HibernateUtil().getSession();
				DaoAtendimento dao = new DaoAtendimento(Atendimento.class, session);
				session.beginTransaction();
				dao.salvar(atendimento);
				session.getTransaction().commit();

				this.atendimento = dao.buscaUltimoRegistro(session );
				this.cdAtendimento = this.atendimento.getCdAtendimento();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastrado Atendimento:"+cdAtendimento));

				session.close();
				vinculaTag();
			}
		}catch(Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Não Foi possivel cadastrar o Atendimento"));

		}	

		//return "home.xhtml";
	}


	public void buscaPacientes(){		
		try{

			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoPaciente dao = new DaoPaciente(Paciente.class,session);
			this.listaPaciente = dao.listaSemAtendimento(session);
			session.close();
		} 	catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
		}

	}
	public void buscaTagsVinculo(){		
		try{

			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoTags dao = new DaoTags(Tags.class,session);
			this.listaTags = dao.buscaTagsAtivas(session);
			session.close();
		} 	catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
		}

	}

	public void cadastraPacientes(){
		Paciente paciente = new Paciente(this.nmPaciente, this.paciente_cpf, this.paciente_dtNascimento, this.paciente_sexo, this.paciente_nmMae, this.paciente_nmPai, this.paciente_cep, this.paciente_logradouro, this.paciente_numero, this.paciente_complemento, this.paciente_cidade, this.paciente_uf, this.paciente_observacao);
		try{
			Session session = HibernateUtil.getSession();
			DaoPaciente dao = new DaoPaciente(Paciente.class, session);
			session.beginTransaction();
			dao.salvar(paciente);
			session.getTransaction().commit();
			this.cdPaciente = dao.ultimoRegistro();
			buscaPacientes();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void vinculaTag(){
		try{
			System.out.println("usuario é "+ this.cdUsuarioEntrada);
			Session session = HibernateUtil.getSession();
			DaoTagsAtendimento daoVinculo = new DaoTagsAtendimento(TagsAtendimento.class, session);
			DaoTags daoTag = new DaoTags(Tags.class, session);
			session.beginTransaction();
			TagsAtendimento tagsAtendimento = new TagsAtendimento(this.cdUsuarioEntrada,this.cdAtendimento,this.tag_vinculada,"S",new Date());
			daoTag.atualizar(new Tags(this.cd_tag,this.tag_vinculada,"S","S"));
			daoVinculo.salvar(tagsAtendimento);
			session.getTransaction().commit();	

			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
