package persistencia;

import org.hibernate.Session;

import entidades.TipoAlerta;

public class DaoTipoAlerta extends GenericDao<TipoAlerta> {
	public DaoTipoAlerta(Class<TipoAlerta> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
}
