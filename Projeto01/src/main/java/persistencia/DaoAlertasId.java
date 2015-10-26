package persistencia;

import org.hibernate.Session;

import entidades.Alertas;


import persistencia.GenericDao;

public class DaoAlertasId extends GenericDao<Alertas>{

	public DaoAlertasId(Class<Alertas> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
