package persistencia;

import org.hibernate.Session;

import entidades.ObservacoesId;

public class DaoObservacoesId extends GenericDao<ObservacoesId>{

	public DaoObservacoesId(Class<ObservacoesId> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
	
}
