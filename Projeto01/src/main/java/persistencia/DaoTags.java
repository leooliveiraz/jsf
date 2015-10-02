package persistencia;

import org.hibernate.Session;

import entidades.Tags;

public class DaoTags extends GenericDao<Tags> {

	public DaoTags(Class<Tags> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
