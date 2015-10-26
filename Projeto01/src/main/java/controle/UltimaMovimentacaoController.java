package controle;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;

import persistencia.DaoUltimasMovimentacoes;
import util.HibernateUtil;
import entidades.UltimasMovimentacoes;

@ManagedBean
@ViewScoped
public class UltimaMovimentacaoController implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4275358510767912299L;
	/**
	 * 
	 */
	private UltimasMovimentacoes ultimasMovimentacoes;
	private List<UltimasMovimentacoes> lista;
	private int numero=0;
	private int cdAtendimento;
	private int cdPaciente;
	private String nmPaciente;
	private String cdTagFornecedor;
	private Date dtMovimentacao;
	private int cdAntena;
	private String dsAntena;
	private int cdSetor;
	private String nmSetor;
	private int cdMovimentacao;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public UltimasMovimentacoes getUltimasMovimentacoes() {
		return ultimasMovimentacoes;
	}
	public void setUltimasMovimentacoes(UltimasMovimentacoes ultimasMovimentacoes) {
		this.ultimasMovimentacoes = ultimasMovimentacoes;
	}
	public List<UltimasMovimentacoes> getLista() {
		return lista;
	}
	public void setLista(List<UltimasMovimentacoes> lista) {
		this.lista = lista;
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
	public String getNmPaciente() {
		return nmPaciente;
	}
	public void setNmPaciente(String nmPaciente) {
		this.nmPaciente = nmPaciente;
	}
	public String getCdTagFornecedor() {
		return cdTagFornecedor;
	}
	public void setCdTagFornecedor(String cdTagFornecedor) {
		this.cdTagFornecedor = cdTagFornecedor;
	}
	public Date getDtMovimentacao() {
		return dtMovimentacao;
	}
	public void setDtMovimentacao(Date dtMovimentacao) {
		this.dtMovimentacao = dtMovimentacao;
	}
	public int getCdAntena() {
		return cdAntena;
	}
	public void setCdAntena(int cdAntena) {
		this.cdAntena = cdAntena;
	}
	public String getDsAntena() {
		return dsAntena;
	}
	public void setDsAntena(String dsAntena) {
		this.dsAntena = dsAntena;
	}
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
	public int getCdMovimentacao() {
		return cdMovimentacao;
	}
	public void setCdMovimentacao(int cdMovimentacao) {
		this.cdMovimentacao = cdMovimentacao;
	}

	public void buscaMovimentacoes(){

		Session session = HibernateUtil.getSession();
		DaoUltimasMovimentacoes dao = new DaoUltimasMovimentacoes(UltimasMovimentacoes.class, session);
		lista = dao.buscaTodos();		
	}
	@PostConstruct
	public void iniciar(){
		buscaMovimentacoes();
	}
	

	public void contar(){
		buscaMovimentacoes();
		numero = lista.get(lista.size()-1).getCdMovimentacao();
		System.out.println(numero);
	}
}
