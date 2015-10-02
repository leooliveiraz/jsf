package persistencia;

import org.hibernate.Session;

import entidades.Usuario;

public class DaoUsuario extends GenericDao<Usuario>{

	public DaoUsuario(Class<Usuario> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
	
	
}
