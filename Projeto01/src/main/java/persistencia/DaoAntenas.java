package persistencia;

import org.hibernate.Session;

import entidades.Antenas;

public class DaoAntenas extends GenericDao<Antenas> {

	public DaoAntenas(Class<Antenas> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
