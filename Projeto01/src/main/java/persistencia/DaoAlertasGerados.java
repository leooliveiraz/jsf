package persistencia;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import entidades.AlertasGerados;
import entidades.UltimasMovimentacoes;
import entidades.UltimasMovimentacoesDiferenca;

public class DaoAlertasGerados extends GenericDao<AlertasGerados>{

	public DaoAlertasGerados(Class<AlertasGerados> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
		
	public List<AlertasGerados> busca(Session session){
		Criteria criteria = session.createCriteria(AlertasGerados.class);
		criteria.addOrder(Order.desc("cd_alerta"));
		return (List<AlertasGerados>) criteria.list();
		
	}
}
