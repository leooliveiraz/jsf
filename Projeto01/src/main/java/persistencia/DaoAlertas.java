package persistencia;

import org.hibernate.Session;

import entidades.Alertas;

public class DaoAlertas extends GenericDao<Alertas> {

	public DaoAlertas(Class<Alertas> classe, Session session) {
		super(classe, session);
		
	}

}
