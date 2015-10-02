package persistencia;

import org.hibernate.Session;

import entidades.Setor;

public class DaoSetor extends GenericDao<Setor> {

	public DaoSetor(Class<Setor> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
