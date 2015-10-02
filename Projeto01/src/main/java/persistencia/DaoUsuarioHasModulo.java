package persistencia;

import org.hibernate.Session;

import entidades.UsuarioHasModulo;

public class DaoUsuarioHasModulo extends GenericDao<UsuarioHasModulo> {

	public DaoUsuarioHasModulo(Class<UsuarioHasModulo> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
