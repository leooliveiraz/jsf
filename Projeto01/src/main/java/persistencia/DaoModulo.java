package persistencia;

import org.hibernate.Session;

import entidades.Modulo;

public class DaoModulo extends GenericDao<Modulo>{

	public DaoModulo(Class<Modulo> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
