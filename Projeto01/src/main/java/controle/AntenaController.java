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

import persistencia.DaoAntenas;
import persistencia.DaoSetor;
import util.HibernateUtil;
import entidades.Antenas;
import entidades.Setor;

@ManagedBean
@ViewScoped
public class AntenaController implements Serializable {


	private static final long serialVersionUID = 1L;
	public Antenas antena;
	public List<Antenas> lista;
	public List<Setor> listaSetor;
	private int cdAntena;
	private String dsAntena;
	private String cdIp;
	private int setorCdSetor;


	public Antenas getAntena() {
		return antena;
	}
	public void setAntena(Antenas antena) {
		this.antena = antena;
	}
	public List<Antenas> getLista() {
		return lista;
	}
	public void setLista(List<Antenas> lista) {
		this.lista = lista;
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
	public String getCdIp() {
		return cdIp;
	}
	public void setCdIp(String cdIp) {
		this.cdIp = cdIp;
	}
	public int getSetorCdSetor() {
		return setorCdSetor;
	}
	public void setSetorCdSetor(int setorCdSetor) {
		this.setorCdSetor = setorCdSetor;
	}
	public List<Setor> getListaSetor() {
		return listaSetor;
	}
	public void setListaSetor(List<Setor> listaSetor) {
		this.listaSetor = listaSetor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String cadastraAntena(){
		try{

			Antenas antena = new Antenas(this.cdAntena,this.dsAntena,this.cdIp,this.setorCdSetor);
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoAntenas dao = new DaoAntenas(Antenas.class,session);
			dao.salvar(antena);
			session.getTransaction().commit();
			session.close();

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastrado com sucesso."));
			return "tabelaantena.xhtml";

		} 	catch(Exception e){
			System.out.println(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro:"+e.getMessage()));
			//e.printStackTrace();

			return "tabelaantena.xhtml";
		}

	}
	public String alteraAntena(Antenas nova_antena){
		try{
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoAntenas dao = new DaoAntenas(Antenas.class,session);
			dao.atualizar(nova_antena);
			session.getTransaction().commit();
			session.close();
			System.out.println("EDITADO");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastrado com sucesso."));
			return "tabelaantena.xhtml";

		}catch(Exception e){
			System.out.println(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro:"+e.getMessage()));
			return "tabelaantena.xhtml";
		}
	}

	public void consultaAntena(){
		try{			
			Session session = HibernateUtil.getSession();
			DaoAntenas dao = new DaoAntenas(Antenas.class,session);
			lista = dao.buscaTodos();			
			session.close();

			for (int i = 0;i<lista.size();i++){
				System.out.println(lista.get(i).getCdAntena()+" ");
			}
		} 	catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
		}
	}

	public void onRowEdit(RowEditEvent event) {
		alteraAntena(((Antenas) event.getObject()));
		FacesMessage msg = new FacesMessage("Registro editado", ((Antenas) event.getObject()).getCdAntena()+"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edição cancelada", ((Antenas) event.getObject()).getCdAntena()+"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}     
	
	@PostConstruct
	public void inciar(){
		consultaAntena();
		buscaSetor();
	}

	public void buscaSetor(){
		try{

			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoSetor dao = new DaoSetor(Setor.class,session);

			this.listaSetor = dao.buscaTodos();

			session.close();

		} 	catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
		}
	}
}
