package controle;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;

import persistencia.DaoAlertas;
import persistencia.DaoAlertasGerados;
import persistencia.DaoUltimasMovimentacoes;
import util.HibernateUtil;
import entidades.Alertas;
import entidades.AlertasGerados;
import entidades.UltimasMovimentacoes;

@ManagedBean
@ViewScoped
public class AlertaController implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4275358510767912299L;
	/**
	 * 
	 */
	List<AlertasGerados> listaAlertasGerados;
	Alertas alerta = new Alertas();
	private String usuario;
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<AlertasGerados> getListaAlertasGerados() {
		return listaAlertasGerados;
	}

	public void setListaAlertasGerados(List<AlertasGerados> listaAlertasGerados) {
		this.listaAlertasGerados = listaAlertasGerados;
	}

	public Alertas getAlerta() {
		return alerta;
	}

	public void setAlerta(Alertas alerta) {
		this.alerta = alerta;
	}

	public void buscaMovimentacoes(){
		try{

			Session session = HibernateUtil.getSession();
			DaoAlertasGerados dao = new DaoAlertasGerados(AlertasGerados.class, session);
			listaAlertasGerados =dao.busca(session);
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void acionaVerificacao(){
		try{
			this.alerta.setDt_verificado(new Date());
			this.alerta.setSn_verificado("S");
			this.alerta.setCd_usuario(usuario);
			
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			DaoAlertas dao = new DaoAlertas(Alertas.class, session);
			dao.atualizar(this.alerta);
			session.getTransaction().commit();
			session.close();
			buscaMovimentacoes();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void iniciar(){
		buscaMovimentacoes();
	}



}
