package persistencia;

import org.hibernate.Session;

import entidades.UsuarioHasModuloId;

public class DaoUsuarioHasModuloId extends GenericDao<UsuarioHasModuloId>{

	public DaoUsuarioHasModuloId(Class<UsuarioHasModuloId> classe,
			Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
