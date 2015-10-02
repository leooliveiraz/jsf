package persistencia;

import org.hibernate.Session;

import entidades.AlertasId;


import persistencia.GenericDao;

public class DaoAlertasId extends GenericDao<AlertasId>{

	public DaoAlertasId(Class<AlertasId> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
