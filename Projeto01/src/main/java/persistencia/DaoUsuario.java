package persistencia;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.Utilitarios;
import entidades.Usuario;

public class DaoUsuario extends GenericDao<Usuario>{

	private Session session;
	private Class classe;
	
	public DaoUsuario(Class<Usuario> classe, Session session) {
		super(classe, session);
		this.session = session;
		this.classe = classe;
		// TODO Auto-generated constructor stub
	}
	
	public Usuario buscaLogin(String id,String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		Criteria criterio = this.session.createCriteria(this.classe);
		criterio.add(Restrictions.eq("senha", Utilitarios.sha256(senha)));
		criterio.add(Restrictions.eq("id", id));
		return (Usuario) criterio.uniqueResult();
	}

	public Usuario buscaLogin1(String id, String senha) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
